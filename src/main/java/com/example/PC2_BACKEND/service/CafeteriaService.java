package com.example.PC2_BACKEND.service;

import com.example.PC2_BACKEND.entity.Pedido;
import com.example.PC2_BACKEND.entity.Producto;
import com.example.PC2_BACKEND.repository.PedidoRepository;
import com.example.PC2_BACKEND.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CafeteriaService {

    @Autowired
    private ProductoRepository productoRepository;

    @Autowired
    private PedidoRepository pedidoRepository;

    public List<Producto> listarProductos() {
        return productoRepository.findAll();
    }

    public Pedido registrarPedido(Pedido pedido) {
        return pedidoRepository.save(pedido);
    }
}
