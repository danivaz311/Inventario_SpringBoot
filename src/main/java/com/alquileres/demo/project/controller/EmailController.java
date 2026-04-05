package com.alquileres.demo.project.controller;

import com.alquileres.demo.project.service.EmailService;
import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmailController {

    @Autowired
    private EmailService emailService;

    @GetMapping("/api/enviar-test")
    public String enviarPrueba(@RequestParam String destino, @RequestParam String usuario) {
        try {
            // Definimos la plantilla HTML directamente en una variable String
            String plantillaHtml = "<html>" +
                    "<body style='font-family: sans-serif; color: #333;'>" +
                    "  <div style='max-width: 600px; margin: auto; border: 1px solid #eee; padding: 20px;'>" +
                    "    <h1 style='color: #2c3e50;'>¡Bienvenido, " + usuario + "!</h1>" +
                    "    <p>Gracias por registrarte en nuestro <strong>Sistema de Alquileres</strong>.</p>" +
                    "    <p style='background: #f9f9f9; padding: 10px; border-left: 5px solid #3498db;'>" +
                    "      Este es un correo de prueba enviado con una <strong>plantilla HTML</strong> desde Spring Boot." +
                    "    </p>" +
                    "    <footer style='font-size: 12px; color: #7f8c8d; margin-top: 20px;'>" +
                    "      © 2026 Alquileres Pro - Todos los derechos reservados." +
                    "    </footer>" +
                    "  </div>" +
                    "</body>" +
                    "</html>";

            emailService.enviarCorreoHtml(destino, "Confirmación de Registro - Plantilla HTML", plantillaHtml);
            
            return "¡Correo enviado con éxito a: " + destino + "!";
        } catch (MessagingException e) {
            return "Hubo un error al enviar el correo: " + e.getMessage();
        }
    }
}