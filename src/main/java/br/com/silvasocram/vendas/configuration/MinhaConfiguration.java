package br.com.silvasocram.vendas.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("development")
public class MinhaConfiguration implements CommandLineRunner {

    @Value("${application.outra.message}")
    private String message;

    @Override
    public void run(String... args) throws Exception {
        System.out.println(message);
    }
}
