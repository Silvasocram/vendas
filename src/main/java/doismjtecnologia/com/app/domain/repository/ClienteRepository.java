package doismjtecnologia.com.app.domain.repository;

import doismjtecnologia.com.app.domain.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
public interface ClienteRepository extends JpaRepository <Cliente, Integer> {
    List<Cliente> findByNomeLike(String nome);
    boolean existsByNome(String nome);

    @Query(value = "select c from Cliente c where c.nome like :nome")
    List<Cliente> buscarPorNome(@Param("nome") String nome);

    @Query(value = "select * from Cliente where nome like %?% ", nativeQuery = true)
    List<Cliente> buscarPorNomeSQLNativo(String nome);

}
