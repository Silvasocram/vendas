package doismjtecnologia.com.app.domain.repository;

import doismjtecnologia.com.app.domain.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
public interface ClienteRepository extends JpaRepository <Cliente, Integer> {
    List<Cliente> findByNomeLike(String nome);
    boolean existsByNome(String nome);
}
