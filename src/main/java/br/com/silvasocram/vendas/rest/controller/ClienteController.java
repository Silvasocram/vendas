package br.com.silvasocram.vendas.rest.controller;

import br.com.silvasocram.vendas.domain.entities.Cliente;
import br.com.silvasocram.vendas.domain.entities.repository.ClienteRepository;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

    private ClienteRepository clienteRepository;

    public ClienteController(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @GetMapping("/{id}")
    public Cliente getClienteById(@PathVariable Long id){
        Optional<Cliente> cliente = clienteRepository.findById(id);

        if(cliente.isPresent()){
            return cliente.get();
        }

        return null;
    }

    @PostMapping
    public Cliente save(@RequestBody Cliente cliente){
        return clienteRepository.save(cliente);
    }
}
