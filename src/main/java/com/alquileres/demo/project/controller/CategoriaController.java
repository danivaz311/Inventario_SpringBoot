package com.alquileres.demo.project.controller;

import com.alquileres.demo.project.model.Categoria;
import com.alquileres.demo.project.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaService service;

    // Esto responde a: GET http://localhost:8080/api/categorias
    @GetMapping
    public List<Categoria> listar() {
        return service.obtenerTodas();
    }

    // Esto responde a: POST http://localhost:8080/api/categorias
    @PostMapping
    public Categoria crear(@RequestBody Categoria categoria) {
        return service.registrar(categoria);
    }
}