package doismjtecnologia.com.app.domain.repository;

import doismjtecnologia.com.app.domain.entity.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido, Integer> {
}
