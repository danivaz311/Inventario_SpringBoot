package com.alquileres.demo.project.repository;

import com.alquileres.demo.project.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {


    List<Categoria> findByNombre(String nombre);
    
}