package com.inventario.config;

import com.inventario.model.Categoria;
import com.inventario.model.Producto;
import com.inventario.repository.CategoriaRepository;
import com.inventario.repository.ProductoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class DataInitializer {

    @Bean
    CommandLineRunner initDatabase(ProductoRepository productoRepo,
                                   CategoriaRepository categoriaRepo) {

        return args -> {

            Categoria tecnologia = new Categoria();
            tecnologia.setNombre("Tecnologia");

            Categoria accesorios = new Categoria();
            accesorios.setNombre("Accesorios");

            categoriaRepo.save(tecnologia);
            categoriaRepo.save(accesorios);

            Producto p1 = new Producto();
            p1.setNombre("Laptop Pro");
            p1.setPrecio(25000.0);
            p1.setStock(10);
            p1.setCategoria(tecnologia);

            productoRepo.save(p1);
        };
    }
}