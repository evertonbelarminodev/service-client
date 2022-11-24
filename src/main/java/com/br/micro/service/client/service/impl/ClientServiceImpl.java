package com.br.micro.service.client.service.impl;

import com.br.micro.service.client.model.Client;
import com.br.micro.service.client.repository.ClientRepository;
import com.br.micro.service.client.service.ClientService;
import com.br.micro.service.client.tools.RabbitMQClient;
import com.br.micro.service.client.util.DataUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Everton Luiz Belarmino
 */
@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private RabbitMQClient rabbitMQClient;

    @Override
    public Client saveClient(Client client) throws JsonProcessingException {

        DataUtil.isCPF(client.getCpf());
        clientRepository.save(client);
        rabbitMQClient.sendMessage(client);

        return client;
    }

    @Override
    public List<Client> findAllClient() {
        return clientRepository.findAll();
    }

    @Override
    public Client findClientById(Long id) {
        return clientRepository.findById(id).get();
    }

    @Override
    public List<Client> findByNameLike(String clientName) {
        return clientRepository.findByClientNameContaining(clientName);
    }

    @Override
    public void deleteClient(Long id) {
        clientRepository.deleteById(id);
    }
}
