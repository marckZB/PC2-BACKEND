package com.example.PC2_BACKEND.controller;

import com.example.PC2_BACKEND.entity.Incidencia;
import com.example.PC2_BACKEND.service.IncidenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/incidencias")
@CrossOrigin(origins = "*")
public class IncidenciaController {

    @Autowired
    private IncidenciaService service;

    @GetMapping
    public ResponseEntity<List<Incidencia>> listar() {
        return ResponseEntity.ok(service.listarIncidencias());
    }

    @PostMapping
    public ResponseEntity<Incidencia> guardar(@RequestBody Incidencia incidencia) {
        return ResponseEntity.ok(service.guardarIncidencia(incidencia));
    }

    @PutMapping("/{id}/estados")
    public ResponseEntity<Incidencia> actualizarEstado(@PathVariable Long id, @RequestBody Map<String, String> body) {
        Incidencia res = service.actualizarEstado(id, body.get("estado"));
        return (res != null) ? ResponseEntity.ok(res) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        return service.eliminarIncidencia(id) ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
