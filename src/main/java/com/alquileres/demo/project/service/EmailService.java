package com.alquileres.demo.project.service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    // Esta herramienta la trae la dependencia que pusimos en el pom.xml
    @Autowired
    private JavaMailSender mailSender;

    public void enviarCorreoHtml(String destinatario, String asunto, String cuerpoHtml) throws MessagingException {
        // 1. Creamos el mensaje base
        MimeMessage message = mailSender.createMimeMessage();
        
        // 2. Usamos un "Helper" para poder manejar HTML y UTF-8 (acentos)
        MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");

        helper.setTo(destinatario);
        helper.setSubject(asunto);
        
        // El valor 'true' es vital: le dice a Spring que el texto es HTML y no texto plano
        helper.setText(cuerpoHtml, true);

        // 3. Enviamos el correo
        mailSender.send(message);
    }
}