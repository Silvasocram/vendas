package doismjtecnologia.com.app.service;

import doismjtecnologia.com.app.model.Cliente;
import doismjtecnologia.com.app.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {

    // Criamos a variável para trabalharmos com injeção de dependência
    private final ClienteRepository clienteRepository;

    // No construtor o Spring se encarrega de fazer a injeção.
    @Autowired
    public ClienteService(ClienteRepository clienteRepository){
        this.clienteRepository = clienteRepository;
    }

    public void salvarCliente(Cliente cliente){
        if(validarCliente(cliente)){
            this.clienteRepository.persistir(cliente);
        }
    }

    private boolean validarCliente(Cliente cliente) {
        return true;
    }
}
