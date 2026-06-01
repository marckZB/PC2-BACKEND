package com.example.PC2_BACKEND.service;


import com.example.PC2_BACKEND.entity.Tarea;
import com.example.PC2_BACKEND.repository.TareaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class TareaService {
    @Autowired
    private TareaRepository repository;

    public List<Tarea> listarTareas() { return repository.findAll(); }

    public Tarea guardarTarea(Tarea tarea) { return repository.save(tarea); }

    public Tarea actualizarTarea(Long id, Tarea datos) {
        Optional<Tarea> opt = repository.findById(id);
        if (opt.isPresent()) {
            Tarea t = opt.get();
            t.setTitulo(datos.getTitulo());
            t.setDescripcion(datos.getDescripcion());
            t.setCurso(datos.getCurso());
            t.setEstado(datos.getEstado());
            t.setPrioridad(datos.getPrioridad());
            t.setFechaVencimiento(datos.getFechaVencimiento());
            return repository.save(t);
        }
        return null;
    }

    public boolean eliminarTarea(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }
}