package com.example.PC2_BACKEND.controller;

import com.example.PC2_BACKEND.entity.Pedido;
import com.example.PC2_BACKEND.entity.Producto;
import com.example.PC2_BACKEND.service.CafeteriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class CafeteriaController {

    @Autowired
    private CafeteriaService service;

    @GetMapping("/api/productos")
    public ResponseEntity<List<Producto>> listarProductos() {
        return ResponseEntity.ok(service.listarProductos());
    }

    @PostMapping("/api/pedidos")
    public ResponseEntity<Pedido> registrarPedido(@RequestBody Pedido pedido) {
        return ResponseEntity.ok(service.registrarPedido(pedido));
    }
}
