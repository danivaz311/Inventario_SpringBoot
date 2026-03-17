package com.alquileres.demo.project.repository;

import com.alquileres.demo.project.model.ItemFisico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemFisicoRepository extends JpaRepository<ItemFisico, Integer> {
    
}