package com.craig.test3it.springboot.app.springboot_test3it.entities;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.craig.test3it.springboot.app.springboot_test3it.validation.ExistsByCorreo;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String nombre;

    @NotBlank
    @Size(min = 6)
    @Pattern(regexp = "^(?=.*[A-Z])(?=.*[a-z])(?=(?:.*\\d.*\\d)).+$", 
             message = "La cadena debe contener al menos una letra mayúscula, al menos una letra minúscula y al menos dos números")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String clave;

    @ExistsByCorreo
    @NotBlank
    @Column(unique = true)
   @Email(message = "electrónico es inválido",regexp = "[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,5}")
    private String correo;

    private LocalDateTime created_at;

    
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinTable(name="usuario_telefonos",joinColumns = @JoinColumn(name="usuario_id"),
    inverseJoinColumns = @JoinColumn(name="telefono_id"),
    uniqueConstraints = @UniqueConstraint(columnNames = {"telefono_id"}))
    private List<Telefono> telefonos;
    

    public Usuario() {
        telefonos = new ArrayList<>();
    }

    public Usuario(String nombre, String clave, String correo) {
        this();
        this.nombre = nombre;
        this.clave = clave;
        this.correo = correo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public LocalDateTime getCreated_at() {
        return created_at;
    }

    public void setCreated_at(LocalDateTime created_at) {
        this.created_at = created_at;
    }

    public List<Telefono> getTelefonos() {
        return telefonos;
    }

    public void setTelefonos(List<Telefono> telefonos) {
        this.telefonos = telefonos;
    }

    @Override
    public String toString() {
        return "{id=" + id + ", nombre=" + nombre + ", clave=" + clave + ", correo=" + correo + ", created_at=" + created_at +", telefonos="
                + telefonos + "}";
    }

    
    
}
