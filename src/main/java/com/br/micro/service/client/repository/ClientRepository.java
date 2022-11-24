package com.br.micro.service.client.repository;

import com.br.micro.service.client.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Everton Luiz Belarmino
 */
@Repository
public interface ClientRepository extends JpaRepository<Client,Long> {
    List<Client> findByClientNameContaining(String name);
}
