package com.example.PC2_BACKEND.service;

import com.example.PC2_BACKEND.entity.Incidencia;
import com.example.PC2_BACKEND.repository.IncidenciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class IncidenciaService {

    @Autowired
    private IncidenciaRepository repository;

    public List<Incidencia> listarIncidencias() {
        return repository.findAll();
    }

    public Incidencia guardarIncidencia(Incidencia incidencia) {
        return repository.save(incidencia);
    }

    public Incidencia actualizarEstado(Long id, String estado) {
        Optional<Incidencia> opt = repository.findById(id);
        if (opt.isPresent()) {
            Incidencia inc = opt.get();
            inc.setEstado(estado);
            return repository.save(inc);
        }
        return null;
    }

    public boolean eliminarIncidencia(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }
}
