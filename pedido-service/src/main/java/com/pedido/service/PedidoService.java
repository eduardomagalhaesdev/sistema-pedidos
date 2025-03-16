package com.pedido.service;


import com.pedido.model.Pedido;
import com.pedido.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class PedidoService {
    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public Pedido criarPedido(Pedido pedido) {
        pedido.setStatus("PENDENTE");
        Pedido pedidoSalvo = pedidoRepository.save(pedido);
        kafkaTemplate.send("novo-pedido", pedidoSalvo.getId().toString());
        return pedidoSalvo;
    }

    public Pedido getPedidoStatus(Long id) {
        return pedidoRepository.findById(id).orElseThrow(() -> new RuntimeException("Pedido não encontrado"));
    }
}