package com.soft.Appsoft.modelos;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name="usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique=true,nullable = false)
    private Long id;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "apellido")
    private String apellido;
    @Column(name = "email")
    private String email;
    //cascade = CascadeType.ALL propaga a las dfemas(persistir, actualizar, fusionar y eliminar q) ,nunca en manytoone
    // lazy:evitar una carga activa y traer todo
    //rphanRemoval= true especifica que la entidad hijo debe ser eliminada automáticamente por el propio ORM si ha dejado de ser referenciada por una entidad padre.
    //,targetEntity = Prestamo.class
   // @JsonBackReference
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "usuario",orphanRemoval= true)
    private List<Prestamo> prestamos;

    public Usuario(){

    }

    public List<Prestamo> getPrestamos() {
        return prestamos;
    }

    public void setPrestamo(Prestamo p) {
        prestamos.add(p);
    }

    public Long getId() {
        return id;
    }

    public String getApellido() {
        return apellido;
    }

    public String getEmail() {
        return email;
    }

    public String getNombre() {
        return nombre;
    }

    public void setApellido(String apellido) {
       if(this.apellido==null || this.apellido.isBlank()){
           throw new IllegalArgumentException("apellido no debe ser null");
       }
        this.apellido = apellido;
    }

    public void setEmail(String email) {
        if(this.email==null || this.email.isBlank()){
            throw new IllegalArgumentException("email no debe ser null");
        }
        this.email = email;
    }

    public void setNombre(String nombre) {
        if(this.nombre==null || this.nombre.isBlank()){
            throw new IllegalArgumentException("nombre no debe ser null");
        }
        this.nombre = nombre;
    }

    @Override
    public String toString(){
        return "nombre: "+nombre+"apellido: "+apellido+"id: "+id+"email: "+email;
    }
}
