package doismjtecnologia.com.app;

import doismjtecnologia.com.app.domain.entity.Cliente;
import doismjtecnologia.com.app.domain.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication
@RestController
public class VendasApplication {

    public static void main(String[] args) {
        SpringApplication.run(VendasApplication.class, args);
    }

    @Bean
    public CommandLineRunner init (@Autowired ClienteRepository clienteRepository){
        return args -> {

            System.out.println("## Inserindo clientes ##");
            clienteRepository.save(new Cliente("Marcos Silva"));
            clienteRepository.save(new Cliente("Janaíra Capistrano"));
            clienteRepository.save(new Cliente("Mayara Capistrano"));

            List<Cliente> clientes = clienteRepository.findAll();
            clientes.forEach(System.out::println);

            System.out.println(("## Atualizando clientes ##"));
            clientes.forEach(c -> {
                c.setNome(c.getNome().concat(" - Atualizado"));
                clienteRepository.save(c);
            });
            List<Cliente> clientesAtualizados = clienteRepository.findAll();
            clientesAtualizados.forEach(System.out::println);

            System.out.println(("## Buscar por nome Caps ##"));
            List<Cliente> buscarPorNome = clienteRepository.findByNomeLike("%Capis%");
            buscarPorNome.forEach(System.out::println);

            System.out.println(("## Buscar por nome Ma ##"));
            List<Cliente> buscarPorNomeMa = clienteRepository.findByNomeLike("%Ma%");
            buscarPorNomeMa.forEach(System.out::println);


            System.out.println("Verifica se existe um cliente com nome Marcos Silva - Atualizado");
            boolean existe = clienteRepository.existsByNome("Marcos Silva - Atualizado");
            System.out.println("Existe um cliente com nome Marcos Silva - Atualizado? " + existe);

            System.out.println(("## Buscar por nome Caps com @Query ##"));
            List<Cliente> buscarPorNomeArrobaQuery = clienteRepository.buscarPorNome("%Capis%");
            buscarPorNomeArrobaQuery.forEach(System.out::println);

            System.out.println(("## Buscar por nome Ma com SQL Nativo ##"));
            List<Cliente> buscarPorNomeSQlNativo = clienteRepository.buscarPorNomeSQLNativo("Ma");
            buscarPorNomeSQlNativo.forEach(System.out::println);

            System.out.println("Excluir cliente com ID = 1");
            clienteRepository.deleteById(1);
            System.out.println("Listar todos os clientes para ver se realmente foi excluído o ID = 1");
            List<Cliente> clientesNaoExcluidos = clienteRepository.findAll();
            clientesNaoExcluidos.forEach(System.out::println);



        };
    }
}
