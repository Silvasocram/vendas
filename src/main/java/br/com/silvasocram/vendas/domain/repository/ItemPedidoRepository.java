package br.com.silvasocram.vendas.domain.repository;

import br.com.silvasocram.vendas.domain.entities.ItemPedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemPedidoRepository extends JpaRepository<ItemPedido, Long> {
}
