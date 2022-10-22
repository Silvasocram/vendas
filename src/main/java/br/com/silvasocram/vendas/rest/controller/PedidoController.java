package br.com.silvasocram.vendas.rest.controller;

import br.com.silvasocram.vendas.domain.entities.Pedido;
import br.com.silvasocram.vendas.rest.dto.PedidoDTO;
import br.com.silvasocram.vendas.services.PedidoService;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/pedidos")
public class PedidoController {

    private PedidoService pedidoService;

    public PedidoController(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Long save(@RequestBody PedidoDTO pedidoDTO) {
        final Pedido pedido = pedidoService.salvar(pedidoDTO);
        return pedido.getId();
    }
}
