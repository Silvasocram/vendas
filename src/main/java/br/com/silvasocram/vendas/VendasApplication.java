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
public class VendasApplication {
	public static void main(String[] args) {
		SpringApplication.run(VendasApplication.class, args);
	}
}
