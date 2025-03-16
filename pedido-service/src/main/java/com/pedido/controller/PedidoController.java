package com.pedido.controller;


import com.pedido.model.Pedido;
import com.pedido.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {
    @Autowired
    private PedidoService pedidoService;

    @PostMapping
    public Pedido criarPedido(@RequestBody Pedido pedido) {
        return pedidoService.criarPedido(pedido);
    }

    @GetMapping("/{id}")
    public Pedido getPedidoStatus(@PathVariable Long id) {
        return pedidoService.getPedidoStatus(id);
    }
}