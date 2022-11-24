package com.br.micro.service.client.service;

import com.br.micro.service.client.model.Client;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author Everton Luiz Belarmino
 */
@Component
public interface ClientService {

    Client saveClient(Client client) throws JsonProcessingException;
    List<Client> findAllClient();
    Client findClientById(Long id);
    List<Client> findByNameLike(String name);
    void deleteClient(Long id);
}
