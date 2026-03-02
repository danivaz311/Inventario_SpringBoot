package com.inventario.config;

import com.inventario.model.Producto;
import com.inventario.repository.ProductoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.util.List;

@Configuration
public class DataInitializer {

    @Bean
    CommandLineRunner initDatabase(ProductoRepository repository) {
        return args -> {
            // Producto 1
            Producto p1 = new Producto();
            p1.setNombre("Laptop Pro");
            p1.setCategoria("Tecnologia");
            p1.setPrecio(25000.0);
            p1.setStock(10);

            // Producto 2
            Producto p2 = new Producto();
            p2.setNombre("Mouse");
            p2.setCategoria("Accesorios");
            p2.setPrecio(500.0);
            p2.setStock(50);

            // Producto 3
            Producto p3 = new Producto();
            p3.setNombre("Monitor 4K");
            p3.setCategoria("Tecnologia");
            p3.setPrecio(8500.0);
            p3.setStock(15);

            repository.saveAll(List.of(p1, p2, p3));
            System.out.println(" Datos de prueba cargados correctamente.");
        };
    }
}