package br.com.silvasocram.vendas;

import br.com.silvasocram.vendas.domain.entities.Cliente;
import br.com.silvasocram.vendas.domain.entities.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class VendasApplication implements CommandLineRunner{

	@Value("${application.message}")
	private String message;

	@Autowired
	private ClienteRepository clienteRepository;

	public static void main(String[] args) {
		SpringApplication.run(VendasApplication.class, args);
	}

/*	public CommandLineRunner executar(){
		System.out.println("PASSEI AQUI");
		return args->{

			Cliente cliente = new Cliente();
			cliente.setNome("MARCOS");
			clienteRepository.save(cliente);

		};
	}*/

	@GetMapping("/hellow")
	public String hellow(){
		return message;
	}

	@Override
	public void run(String... args) throws Exception {

		Cliente cliente = new Cliente();
		cliente.setNome("MARCOS");
		clienteRepository.save(cliente);

	}
}
