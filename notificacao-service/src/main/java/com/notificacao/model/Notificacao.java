package com.notificacao.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Document
@Data
public class Notificacao {
    @Id
    private String id;
    private String mensagem;
    private String destinatario;

}