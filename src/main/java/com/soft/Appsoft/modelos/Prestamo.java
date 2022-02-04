package com.soft.Appsoft.modelos;

import javax.persistence.*;
import java.util.Optional;

@Entity
@Table(name="prestamo")
public class Prestamo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

/*targetEntity RECONOCE LA OTRA CLASE*/
    //FetchType. EAGER  carga todasd las relaciones
    //targetEntity = Usuario.class,fetch = FetchType.EAGER

    //@JsonManagedReference
    @ManyToOne(targetEntity = Usuario.class,fetch = FetchType.EAGER)
    @JoinColumn(name="iduser")
    private Usuario usuario;

    @Column(name = "total")
    private float total;


    public Prestamo(){

    }
    public Prestamo(Long id){
        this.id=id;
    }

    public Prestamo(long id, float total) {
        this.id=id;
        this.total=total;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        if(usuario==null){
            throw new IllegalArgumentException("el usuario en prestamo no debe ser nulo");
        }
        this.usuario = usuario;
    }

    public float getTotal() {
        return total;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        if(id<0){
            throw new IllegalArgumentException("id no debe ser negativo");
        }
        this.id = id;
    }

    public void setTotal(float total) {
        if(total<0){
            throw new IllegalArgumentException("total no debe ser negativo");
        }
        this.total = total;
    }
    @Override
    public String toString(){
        return "id:"+id+"total"+total;
    }
}
