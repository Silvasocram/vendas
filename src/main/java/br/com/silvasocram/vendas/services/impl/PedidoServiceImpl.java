package br.com.silvasocram.vendas.services.impl;

import br.com.silvasocram.vendas.domain.entities.ItemPedido;
import br.com.silvasocram.vendas.domain.entities.Pedido;
import br.com.silvasocram.vendas.domain.repository.ClienteRepository;
import br.com.silvasocram.vendas.domain.repository.ItemPedidoRepository;
import br.com.silvasocram.vendas.domain.repository.PedidoRepository;
import br.com.silvasocram.vendas.domain.repository.ProdutoRepository;
import br.com.silvasocram.vendas.exception.RegraDeNegocioException;
import br.com.silvasocram.vendas.rest.dto.ItemPedidoDTO;
import br.com.silvasocram.vendas.rest.dto.PedidoDTO;
import br.com.silvasocram.vendas.services.PedidoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PedidoServiceImpl implements PedidoService {

    private final PedidoRepository pedidoRepository;
    private final ClienteRepository clienteRepository;
    private final ProdutoRepository produtoRepository;

    private final ItemPedidoRepository itemPedidoRepository;

    @Override
    @Transactional
    public Pedido salvar(PedidoDTO pedidoDTO) {

        var cliente = clienteRepository.findById(pedidoDTO.getCliente())
                .orElseThrow( () -> new RegraDeNegocioException("Código de cliente inválido: "
                        .concat(pedidoDTO.getCliente().toString())));

        var pedido = Pedido.builder()
                .total(pedidoDTO.getTotal())
                .data(LocalDate.now())
                .cliente(cliente)
                .build();

        final List<ItemPedido> itensPedido = converterItens(pedido, pedidoDTO.getItens());

        pedidoRepository.save(pedido);
        itemPedidoRepository.saveAll(itensPedido);

        pedido.setItemPedidos(itensPedido);

        return pedido;
    }

    private List<ItemPedido> converterItens ( Pedido pedido, List<ItemPedidoDTO> itens){

        if(itens.isEmpty()){
            throw new RegraDeNegocioException("Não é possivel realizar um pedido sem itens.");
        }

        return itens.stream()
                .map(dto -> {

                    var produto = produtoRepository
                            .findById(dto.getProduto())
                            .orElseThrow(() -> new RegraDeNegocioException("Código de produto inválido:"
                                    .concat(dto.getProduto().toString())))
                            ;

                    var itemPedido = ItemPedido.builder()
                            .quantidade(dto.getQuantidade())
                            .pedido(pedido)
                            .produto(produto)
                            .build();

                    return itemPedido;
                })
                .collect(Collectors.toList());

    }
}
