package com.example.PC2_BACKEND.service;

import com.example.PC2_BACKEND.entity.Curso;
import com.example.PC2_BACKEND.entity.Matricula;
import com.example.PC2_BACKEND.repository.CursoRepository;
import com.example.PC2_BACKEND.repository.MatriculaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class MatriculaService {

    @Autowired
    private CursoRepository cursoRepository;

    @Autowired
    private MatriculaRepository matriculaRepository;

    public List<Curso> listarCursos() {
        return cursoRepository.findAll();
    }

    public Matricula registrarMatricula(Matricula matricula) {
        return matriculaRepository.save(matricula);
    }
}
