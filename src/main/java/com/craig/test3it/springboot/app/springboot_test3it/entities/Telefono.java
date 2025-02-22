package com.craig.test3it.springboot.app.springboot_test3it.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="telefonos")
public class Telefono {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    
    private Long numero;
    private Long codigoarea;
    private Long codigopais;
   
    public Telefono() {
    }

    public Telefono(Long numero, Long codigoarea, Long codigopais) {
        this.numero = numero;
        this.codigoarea = codigoarea;
        this.codigopais = codigopais;
       
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getNumero() {
        return numero;
    }

    public void setNumero(Long numero) {
        this.numero = numero;
    }

    public Long getCodigoarea() {
        return codigoarea;
    }

    public void setCodigoarea(Long codigoarea) {
        this.codigoarea = codigoarea;
    }

    public Long getCodigopais() {
        return codigopais;
    }

    public void setCodigopais(Long codigopais) {
        this.codigopais = codigopais;
    }

   
    @Override
    public String toString() {
        return "{id=" + id + ", numero=" + numero + ", codigoarea=" + codigoarea + ", codigopais="
                + codigopais + "}";
    }

}
