package com.alquileres.demo.project.service;

import com.alquileres.demo.project.model.Categoria;
import com.alquileres.demo.project.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository repository;

    // Consulta 1: Obtener todas
    public List<Categoria> obtenerTodas() {
        return repository.findAll();
    }

    // Consulta 2: Buscar por nombre exacto
    public List<Categoria> obtenerPorNombre(String nombre) {
        return repository.findByNombre(nombre);
    }

    // Insert: Guardar una nueva categoría
    public Categoria registrar(Categoria categoria) {
        return repository.save(categoria);
    }
}