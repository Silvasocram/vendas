package doismjtecnologia.com.app.domain.repository;

import doismjtecnologia.com.app.domain.entity.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class ClienteRepository {

    private final String INSERT = "INSERT INTO CLIENTE (nome) VALUES (?)";
    private final String SELECT_ALL = "SELECT * FROM CLIENTE";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Cliente salvar(Cliente cliente){
        jdbcTemplate.update(INSERT, new Object[]{
                cliente.getNome()});
        return cliente;
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
}
