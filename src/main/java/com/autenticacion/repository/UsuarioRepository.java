package com.autenticacion.servicio.repository;

import com.autenticacion.servicio.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    // Busca un usuario por su correo electrónico
    Optional<Usuario> findByCorreo(String correo);

    // Verifica si ya existe un correo registrado
    boolean existsByCorreo(String correo);
}