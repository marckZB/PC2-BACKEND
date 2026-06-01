package com.example.PC2_BACKEND.controller;

import com.example.PC2_BACKEND.entity.Curso;
import com.example.PC2_BACKEND.entity.Matricula;
import com.example.PC2_BACKEND.service.MatriculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class MatriculaController {

    @Autowired
    private MatriculaService service;

    @GetMapping("/api/cursos")
    public ResponseEntity<List<Curso>> listarCursos() {
        return ResponseEntity.ok(service.listarCursos());
    }

    @PostMapping("/api/matriculas")
    public ResponseEntity<Matricula> registrarMatricula(@RequestBody Matricula matricula) {
        return ResponseEntity.ok(service.registrarMatricula(matricula));
    }
}
