package doismjtecnologia.com.app.domain.repository;

import doismjtecnologia.com.app.domain.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Integer> {
}
