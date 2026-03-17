package com.alquileres.demo.project.model; 
import jakarta.persistence.*;
import lombok.Data;
import java.math.BigDecimal;

@Entity
@Table(name = "catalogo_modelos")
@Data
public class CatalogoModelo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_catalogo")
    private Integer idCatalogo;

    private String marca;
    private String modelo;

    @Column(name = "precio_renta_sugerido")
    private BigDecimal precioRentaSugerido;

    private String especificaciones;

    // RELACIÓN: Muchos modelos pertenecen a UNA categoría
    @ManyToOne
    @JoinColumn(name = "id_categoria") // Nombre de la FK en tu tabla MySQL
    private Categoria categoria;
}