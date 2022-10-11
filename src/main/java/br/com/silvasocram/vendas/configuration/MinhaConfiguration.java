package br.com.silvasocram.vendas.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("homolog")
public class MinhaConfiguration {

    @Value("${application.outra.message}")
    private String message;

    @Bean
    public CommandLineRunner executar(){
        return args -> {
            System.out.println(message);
        };
    }
}
