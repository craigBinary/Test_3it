package com.craig.test3it.springboot.app.springboot_test3it.validation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.craig.test3it.springboot.app.springboot_test3it.services.UsuarioService;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

@Component
public class ExistsByCorreoValidation implements ConstraintValidator<ExistsByCorreo, String>{

@Autowired
private UsuarioService usuarioService;

    @Override
    public boolean isValid(String correo, ConstraintValidatorContext context) {
       if(usuarioService == null){
        return true;
       }
        return !usuarioService.existsByCorreo(correo);
    }

}
