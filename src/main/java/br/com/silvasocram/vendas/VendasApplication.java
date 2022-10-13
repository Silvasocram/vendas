package br.com.silvasocram.vendas;

import br.com.silvasocram.vendas.domain.entities.Cliente;
import br.com.silvasocram.vendas.domain.entities.Pedido;
import br.com.silvasocram.vendas.domain.entities.repository.ClienteRepository;
import br.com.silvasocram.vendas.domain.entities.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@SpringBootApplication
@RestController
public class VendasApplication implements CommandLineRunner{

	@Value("${application.message}")
	private String message;

	@Autowired
	private ClienteRepository clienteRepository;

	@Autowired
	private PedidoRepository pedidoRepository;

	public static void main(String[] args) {
		SpringApplication.run(VendasApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		var  marcos = Cliente.builder()
				.nome("Marcos M. Silva")
				.build();

		clienteRepository.save(marcos);

		Set<Pedido> pedidos = new HashSet<>();

		var videoGame = Pedido.builder()
				.cliente(marcos)
				.data(LocalDate.now())
				.total(BigDecimal.valueOf(5000))
				.build();

		var jogos = Pedido.builder()
				.cliente(marcos)
				.data(LocalDate.now())
				.total(BigDecimal.valueOf(590))
				.build();

		pedidos.add(videoGame);
		pedidos.add(jogos);

		pedidoRepository.saveAll(pedidos);

		//var pedidoCliente = clienteRepository.findById(1L);

		/*if(pedidoCliente.isPresent()){
			var orders = pedidoCliente.get();
			for (Pedido order:orders.getPedidos()
				 ) {
				System.out.println(order.getCliente().getNome());
				System.out.println(order.getData());
				System.out.println(order.getTotal());
			}

		}*/

		Cliente cli = clienteRepository.findClienteFetchPedidos(marcos.getId());
		System.out.println(cli);
		System.out.println("Detalhes do pedido ");
		cli.getPedidos().forEach(System.out::println);
	}
}
