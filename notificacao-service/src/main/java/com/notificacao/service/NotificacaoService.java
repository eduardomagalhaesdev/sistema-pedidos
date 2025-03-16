package com.notificacao.service;

import com.notificacao.model.Notificacao;
import com.notificacao.repository.NotificacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class NotificacaoService {
    @Autowired
    private NotificacaoRepository notificacaoRepository;

    @KafkaListener(topics = "pedido-processado", groupId = "notificacao-group")
    public void notificarPedidoProcessado(String pedidoId) {
        Notificacao notificacao = new Notificacao();
        notificacao.setMensagem("Seu pedido foi processado com sucesso.");
        notificacao.setDestinatario("eduardomagalhaes.dev@gmail.com");
        notificacaoRepository.save(notificacao);
    }

    @KafkaListener(topics = "pedido-rejeitado", groupId = "notificacao-group")
    public void notificarPedidoRejeitado(String pedidoId) {
        Notificacao notificacao = new Notificacao();
        notificacao.setMensagem("Seu pedido foi rejeitado devido a falta de estoque.");
        notificacao.setDestinatario("eduardomagalhaes.dev@gmail.com");
        notificacaoRepository.save(notificacao);
    }
}