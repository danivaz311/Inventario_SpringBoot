package com.alquileres.demo.project;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.alquileres.demo.project.repository.CatalogoModeloRepository;
import com.alquileres.demo.project.repository.CategoriaRepository;
import com.alquileres.demo.project.repository.ItemFisicoRepository;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
public CommandLineRunner testInventarioCompleto(ItemFisicoRepository itemRepo) {
    return args -> {
        System.out.println("\n*************************************************");
        System.out.println("--- REPORTE DE INVENTARIO FÍSICO DETALLADO ---");
        
        // Consultamos todas las unidades físicas (items)
        itemRepo.findAll().forEach(item -> {
            System.out.println("NÚMERO DE SERIE: " + item.getNumeroSerie());
            System.out.println("Estado: " + item.getEstadoActual());
            
            // Navegamos hacia el Catálogo
            if (item.getCatalogo() != null) {
                System.out.print("Equipo: " + item.getCatalogo().getMarca() + " " + item.getCatalogo().getModelo());
                
                // Navegamos un nivel más arriba hacia la Categoría
                if (item.getCatalogo().getCategoria() != null) {
                    System.out.println(" (" + item.getCatalogo().getCategoria().getNombre() + ")");
                } else {
                    System.out.println(" (Sin Categoría)");
                }
            }
            
            System.out.println("Fecha de Ingreso: " + item.getFechaAdquisicion());
            System.out.println("---------------------------------------------");
        });
        
        System.out.println("*************************************************\n");
    };
}
}