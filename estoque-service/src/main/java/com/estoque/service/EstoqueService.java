package com.estoque.service;

import com.estoque.model.Estoque;
import com.estoque.repository.EstoqueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class EstoqueService {
    @Autowired
    private EstoqueRepository estoqueRepository;

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @KafkaListener(topics = "novo-pedido", groupId = "estoque-group")
    public void processarPedido(String pedidoId) {
        // Lógica para verificar o estoque
        // Se houver estoque, publica no tópico "pedido-processado"
        // Se não houver, publica no tópico "pedido-rejeitado"
    }
}