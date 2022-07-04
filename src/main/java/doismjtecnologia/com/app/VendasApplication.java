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

            clienteRepository.salvar(new Cliente("Marcos Silva"));
            clienteRepository.salvar(new Cliente("Janaíra Capistrano"));

            List<Cliente> clientes = clienteRepository.obterTodos();
            clientes.forEach(System.out::println);
        };
    }
}
