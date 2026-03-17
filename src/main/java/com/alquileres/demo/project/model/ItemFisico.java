package com.alquileres.demo.project.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;

@Entity
@Table(name = "items_fisicos")
@Data
public class ItemFisico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_items")
    private Integer idItems;

    @Column(name = "numero_serie", nullable = false, unique = true)
    private String numeroSerie;

    @Column(name = "estado_actual")
    private String estadoActual;

    @Column(name = "fecha_adquisicion")
    private LocalDate fechaAdquisicion;

    // RELACIÓN: Muchas unidades físicas pertenecen a UN modelo del catálogo
    @ManyToOne
    @JoinColumn(name = "id_catalogo") // Verifica que este nombre sea el que tienes en MySQL
    private CatalogoModelo catalogo;
}