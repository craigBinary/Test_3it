package com.craig.test3it.springboot.app.springboot_test3it.services;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.craig.test3it.springboot.app.springboot_test3it.entities.Usuario;
import com.craig.test3it.springboot.app.springboot_test3it.repositories.UsuarioRepository;

@Service
public class UsuarioServiceImpl implements UsuarioService{

    @Autowired
    private UsuarioRepository repository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Transactional(readOnly = true)
    @Override
    public List<Usuario> findAll() {
       
        return (List<Usuario>) repository.findAll();
    }

    @Override
    @Transactional    
    public Usuario save(Usuario usuario) {
       
       // Optional<Usuario> validaCorreo = repository.findByCorreo(usuario.getCorreo());
        LocalDateTime fechaHoraActual = LocalDateTime.now();
        usuario.setCreated_at(fechaHoraActual);
        usuario.setClave(passwordEncoder.encode(usuario.getClave()));
        return repository.save(usuario);
    }

    @Override
    @Transactional(readOnly = true)
    public boolean existsByCorreo(String correo) {
       return repository.existsByCorreo(correo);
    }

   

}
