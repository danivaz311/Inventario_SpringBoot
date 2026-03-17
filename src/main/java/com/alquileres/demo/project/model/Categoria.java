package com.alquileres.demo.project.model;
import jakarta.persistence.*;
import lombok.Data;
@Entity //Declara que la clase es una entidad JPA, es decir, que se mapeará a una tabla en la base de datos.
@Table(name = "categorias") // Permite especificar el nombre de la tabla en la base de datos. Si no se pone, se usa el nombre de la clase.
@Data // Define automaticamente getters y setters
public class Categoria {
    
    @Id //ndica el campo que será la clave primaria de la tabla.
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Define cómo se generará el valor de la clave primaria (ejemplo: auto-incremental).
    @Column(name = "id_categorias") // Debe coincidir exactamente con MySQL
    private Integer idCategorias;

    @Column(nullable = false, unique = true) //define restricciones en las columnas.
    private String nombre;
}
