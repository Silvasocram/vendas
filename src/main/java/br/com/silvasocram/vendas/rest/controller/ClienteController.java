package br.com.silvasocram.vendas.rest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

    @GetMapping("/hello/{nome}")
    public String helloCliente(@PathVariable("nome") String nomeCliente){
        return String.format("Hellow %s", nomeCliente);
    }
}
