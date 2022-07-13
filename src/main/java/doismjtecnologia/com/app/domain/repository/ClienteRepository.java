package doismjtecnologia.com.app.domain.repository;

import doismjtecnologia.com.app.domain.entity.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class ClienteRepository{
    @Autowired
    private EntityManager entityManager;

    @Transactional
    public Cliente salvar(Cliente cliente){
        entityManager.persist(cliente);
        return cliente;
    }

    @Transactional
    public Cliente alterar(Cliente cliente){
        if(!entityManager.contains(cliente)){
            entityManager.merge(cliente);
        }
        entityManager.merge(cliente);
        return cliente;
    }

    @Transactional(readOnly = true)
    public List<Cliente> obterPorNome(String nome){
        String jpql = "select c from Cliente c where c.nome like :nome";
        final TypedQuery<Cliente> query = entityManager.createQuery(jpql, Cliente.class);
        query.setParameter("nome", "%" + nome + "%");
        return query.getResultList();
    }

    @Transactional(readOnly = true)
    public List<Cliente> obterTodos(){
        return entityManager.createQuery("from Cliente", Cliente.class).getResultList();
    }

    @Transactional
    public void excluir (Cliente cliente){
        entityManager.remove(cliente);
    }

    @Transactional
    public void excluir(Integer id){
        Cliente cliente = entityManager.find(Cliente.class, id);
        excluir(cliente);
    }
}
