package com.alquileres.demo.project.repository;

import com.alquileres.demo.project.model.CatalogoModelo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CatalogoModeloRepository extends JpaRepository<CatalogoModelo, Integer> {
}