package com.soft.Appsoft.servicio;

import com.soft.Appsoft.Repositorio.UsuarioRepo;
import com.soft.Appsoft.modelos.Usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class UsuarioServicio {
    @Autowired//inyectar,se encerga de bd, no tengo que instanciar
    protected UsuarioRepo usuarioRepositorio;



    public ArrayList<Usuario> obtenerUsuarios(){
        return(ArrayList<Usuario>) usuarioRepositorio.findAll();
    }

    public Usuario guardarUsuario(Usuario user){
        return usuarioRepositorio.save(user);
    }

    public Optional<Usuario> obtenerUserporId(Long id){//opcional ,si no encuentra el id no se rompe :)
        return usuarioRepositorio.findById(id);
    }

    public boolean eliminarUsuario(Long id){
        try{
           usuarioRepositorio.deleteById(id);///elimina usuario sus prestamos :)
            return true;
        }catch (Exception ex){
            return false;
        }

    }


}
