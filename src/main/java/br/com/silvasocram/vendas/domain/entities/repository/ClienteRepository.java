package br.com.silvasocram.vendas.domain.entities.repository;

import br.com.silvasocram.vendas.domain.entities.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{
}
