package com.autenticacion.servicio.controller;

import com.autenticacion.servicio.model.Usuario;
import com.autenticacion.servicio.service.AuthService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    // Endpoint para registrar un usuario
    @PostMapping("/registro")
    public ResponseEntity<?> registrar(@RequestBody Usuario usuario) {
        try {
            Usuario usuarioGuardado = authService.registrar(usuario);

            return ResponseEntity.status(HttpStatus.CREATED).body(
                    Map.of(
                            "mensaje", "Usuario registrado correctamente",
                            "id", usuarioGuardado.getId()
                    )
            );

        } catch (IllegalArgumentException excepcion) {
            return ResponseEntity.badRequest().body(
                    Map.of("error", excepcion.getMessage())
            );
        }
    }

    // Endpoint para validar las credenciales del usuario
    @PostMapping("/login")
    public ResponseEntity<?> iniciarSesion(
            @RequestBody Map<String, String> datos) {

        String correo = datos.get("correo");
        String contrasena = datos.get("contrasena");

        boolean autenticado = authService.autenticar(correo, contrasena);

        if (autenticado) {
            return ResponseEntity.ok(
                    Map.of("mensaje", "Autenticación satisfactoria")
            );
        }

        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(
                Map.of("error", "Error en la autenticación")
        );
    }
}