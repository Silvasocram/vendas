package br.com.silvasocram.vendas;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class VendasApplication {

	@Value("${application.message}")
	private String message;

	public static void main(String[] args) {
		SpringApplication.run(VendasApplication.class, args);
	}

	@GetMapping("/hellow")
	public String hellow(){
		return message;
	}

}
