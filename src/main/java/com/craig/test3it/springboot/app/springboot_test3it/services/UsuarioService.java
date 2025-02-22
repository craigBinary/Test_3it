package com.craig.test3it.springboot.app.springboot_test3it.services;

import java.util.List;

import com.craig.test3it.springboot.app.springboot_test3it.entities.Usuario;

public interface UsuarioService {

    List<Usuario> findAll();
    Usuario save(Usuario usuario);
    boolean existsByCorreo(String correo);
    

} 
