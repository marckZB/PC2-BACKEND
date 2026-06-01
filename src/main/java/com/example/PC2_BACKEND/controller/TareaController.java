package com.example.PC2_BACKEND.controller;

import com.example.PC2_BACKEND.entity.Tarea;
import com.example.PC2_BACKEND.service.TareaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/tareas")
@CrossOrigin(origins = "*")
public class TareaController {
    @Autowired
    private TareaService service;

    @GetMapping
    public ResponseEntity<List<Tarea>> listar() { return ResponseEntity.ok(service.listarTareas()); }

    @PostMapping
    public ResponseEntity<Tarea> guardar(@RequestBody Tarea t) { return ResponseEntity.ok(service.guardarTarea(t)); }

    @PutMapping("/{id}")
    public ResponseEntity<Tarea> actualizar(@PathVariable Long id, @RequestBody Tarea t) {
        Tarea res = service.actualizarTarea(id, t);
        return (res != null) ? ResponseEntity.ok(res) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        return service.eliminarTarea(id) ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
} 

