package doismjtecnologia.com.app.domain.repository;

import doismjtecnologia.com.app.domain.entity.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class ClienteRepository{

    //private static String INSERT = "INSERT INTO CLIENTE (nome) VALUES (?)";
    private static String UPDATE = "UPDATE CLIENTE SET nome = (?) WHERE id = (?)";
    private static String SELECT_ALL = "SELECT * FROM CLIENTE";

    private static String DELETAR = "DELETE FROM CLIENTE WHERE id = ?";

    @Autowired
    private EntityManager entityManager;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Transactional
    public Cliente salvar(Cliente cliente){
        entityManager.persist(cliente);
        return cliente;
    }

    public void alterar(Cliente cliente){
        jdbcTemplate.update(UPDATE, new Object[]{
               cliente.getNome(),
               cliente.getId()
        });
    }

    public List<Cliente> obterPorNome(String nome){
        return jdbcTemplate.query( SELECT_ALL.concat(" WHERE nome LIKE '%" + nome + "%'"), new RowMapper<Cliente>() {
            @Override
            public Cliente mapRow(ResultSet resultSet, int i) throws SQLException {
                return new Cliente(
                        resultSet.getInt("id"),
                        resultSet.getString("nome")
                );
            }
        });
    }

    public List<Cliente> obterTodos(){
        return jdbcTemplate.query(SELECT_ALL, new RowMapper<Cliente>() {
            @Override
            public Cliente mapRow(ResultSet resultSet, int i) throws SQLException {

                return new Cliente(
                        resultSet.getInt("id"),
                        resultSet.getString("nome")
                );
            }
        });
    }

    public void excluir (Cliente cliente){
        excluir(cliente.getId());
    }

    public void excluir(Integer id){
        jdbcTemplate.update(DELETAR, new Object[]{
                id
        });
    }
}
