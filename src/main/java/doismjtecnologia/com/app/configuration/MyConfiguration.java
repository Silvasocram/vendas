package doismjtecnologia.com.app.configuration;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class MyConfiguration {
    @Bean(name = "applicationName")
    public String applicationName(){
        return "Sistema de Vendas";
    }

    @Bean(name = "outraString")
    public String complementoDeTexto(){
        return "Estou chamando com o nome outraString, mas meu método se chama complementoDeTexto";
    }

    @Profile("development")
    @Bean
    public CommandLineRunner executar(){
        return args -> {
            System.out.println("RODANDO A CONFIGURAÇÃO DE DESENVOLVIMENTO!");
        };
    }

}
