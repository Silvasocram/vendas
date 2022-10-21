package br.com.silvasocram.vendas.rest.controller;

import br.com.silvasocram.vendas.domain.entities.Cliente;
import br.com.silvasocram.vendas.domain.repository.ClienteRepository;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

    private ClienteRepository clienteRepository;

    public ClienteController(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @GetMapping("/{id}")
    public Cliente getClienteById(@PathVariable Long id){
        return clienteRepository.findById(id)
                        .orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                                "Cliente não encontrado"));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente save(@RequestBody Cliente cliente){
        return clienteRepository.save(cliente);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id){
        clienteRepository.findById(id)
                .map(cliente -> {
                    clienteRepository.delete(cliente);
                    return cliente;
                })
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado."));
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@PathVariable Long id,
                          @RequestBody Cliente cliente){
        clienteRepository.findById(id)
                .map(clienteExistente -> {
                    cliente.setId(clienteExistente.getId());
                    clienteRepository.save(cliente);
                    return cliente;
                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado."));
    }

    @GetMapping
    public List<Cliente> getClientesFiltrando(Cliente filtro){

        ExampleMatcher exampleMatcher = ExampleMatcher
                .matching()
                .withIgnoreCase()
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);

        Example example = Example.of(filtro, exampleMatcher);

        return clienteRepository.findAll(example);
    }
}
