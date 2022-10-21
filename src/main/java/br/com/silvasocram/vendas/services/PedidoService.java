package br.com.silvasocram.vendas.services;

import br.com.silvasocram.vendas.domain.entities.Pedido;
import br.com.silvasocram.vendas.exception.RegraDeNegocioException;
import br.com.silvasocram.vendas.rest.dto.PedidoDTO;

public interface PedidoService {
    Pedido salvar (PedidoDTO pedidoDTO) throws RegraDeNegocioException;
}
