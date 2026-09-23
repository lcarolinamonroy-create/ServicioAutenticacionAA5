package com.autenticacion.servicio.service;

import com.autenticacion.servicio.model.Usuario;
import com.autenticacion.servicio.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final UsuarioRepository usuarioRepository;

    public AuthService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    // Registra un usuario nuevo en la base de datos
    public Usuario registrar(Usuario usuario) {

        if (usuarioRepository.existsByCorreo(usuario.getCorreo())) {
            throw new IllegalArgumentException("El correo ya está registrado");
        }

        return usuarioRepository.save(usuario);
    }

    // Valida el correo y la contraseña del usuario
    public boolean autenticar(String correo, String contrasena) {

        return usuarioRepository.findByCorreo(correo)
                .map(usuario -> usuario.getContrasena().equals(contrasena))
                .orElse(false);
    }
}