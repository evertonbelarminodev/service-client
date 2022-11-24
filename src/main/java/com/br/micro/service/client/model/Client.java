package com.br.micro.service.client.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @author Everton Luiz Belarmino
 */
@Entity
@Table(name = "CLIENT")
public class Client implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "CODCLIENT", nullable = false)
    private Long clientCode;

    @Column(name = "NAMECLIENT", nullable = false)
    private String clientName;

    @Column(name = "CPF", nullable = false)
    private String cpf;

    @Column(name = "BIRTHDATE", nullable = true)
    private Date birthDate;

    @Column(name = "EMAIL", nullable = true)
    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getClientCode() {
        return clientCode;
    }

    public void setClientCode(Long clientCode) {
        this.clientCode = clientCode;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }
}