package com.notificacao.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.notificacao.model.Notificacao;

@Repository
public interface NotificacaoRepository extends MongoRepository<Notificacao, String>{

}
