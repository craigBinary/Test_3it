package com.craig.test3it.springboot.app.springboot_test3it.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.craig.test3it.springboot.app.springboot_test3it.entities.Usuario;
import com.craig.test3it.springboot.app.springboot_test3it.services.UsuarioService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/list")
    public List<Usuario> list(){

        return usuarioService.findAll();
    }

    @PostMapping
    public ResponseEntity<?> create(@Valid @RequestBody Usuario usuario,BindingResult result){
       if (result.hasFieldErrors()){
        return validation(result);
       }

       
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioService.save(usuario));
    }

     private ResponseEntity<?> validation(BindingResult result) {
        Map<String, String> errors = new HashMap<>();

        result.getFieldErrors().forEach(err -> {
            errors.put(err.getField(), "El campo " + err.getField() + " " + err.getDefaultMessage());
        });
        return ResponseEntity.badRequest().body(errors);
    }

}
