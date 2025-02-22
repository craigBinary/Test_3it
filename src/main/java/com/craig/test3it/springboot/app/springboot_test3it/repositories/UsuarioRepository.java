package com.craig.test3it.springboot.app.springboot_test3it.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.craig.test3it.springboot.app.springboot_test3it.entities.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario, Long>{
    boolean existsByCorreo(String correo);
    Optional<Usuario> findByNombre(String nombre);
}
