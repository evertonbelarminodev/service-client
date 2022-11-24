package com.br.micro.service.client.tools;

import com.br.micro.service.client.configuration.RabbitMQConfiguration;
import com.br.micro.service.client.model.Client;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageBuilder;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQClient {

    @Value("${queue}")
    private String QUEUE;

    private ObjectMapper objectMapper;
    private final RabbitTemplate rabbitTemplate;

    @Autowired
    public RabbitMQClient(RabbitTemplate rabbitTemplate, ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendMessage(Client client) {
        try {
            String orderJson = objectMapper.writeValueAsString(client);
            Message message = MessageBuilder
                    .withBody(orderJson.getBytes())
                    .setContentType(MessageProperties.CONTENT_TYPE_JSON)
                    .build();
            this.rabbitTemplate.convertAndSend(QUEUE, message);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}
