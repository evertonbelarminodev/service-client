package com.br.micro.service.client.controller;

import com.br.micro.service.client.model.Client;
import com.br.micro.service.client.service.ClientService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Everton Luiz Belarmino
 */
@RestController
@RequestMapping("/client/")
public class ClientController {

    private ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    public ClientService getClientService() {
        return clientService;
    }

    @PostMapping()
    public Client saveCliente(@RequestBody Client client) throws JsonProcessingException {
        return getClientService().saveClient(client);
    }

    @GetMapping()
    public List<Client> findAllClient() {
        return getClientService().findAllClient();
    }

    @GetMapping("{id}")
    public Client findClientById(@PathVariable Long id){
        return getClientService().findClientById(id);
    }

    @GetMapping("consulta/{nome}")
    public List<Client> findByNameLike(@PathVariable String name){
        return getClientService().findByNameLike(name);
    }

    @DeleteMapping("{id}")
    public void deleteClient(@PathVariable Long id) {
        getClientService().deleteClient(id);
    }
}
