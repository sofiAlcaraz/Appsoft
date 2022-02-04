package com.soft.Appsoft.servicio;

import com.soft.Appsoft.Repositorio.PrestamoRepo;
import com.soft.Appsoft.Repositorio.UsuarioRepo;
import com.soft.Appsoft.dao.Devolver;
import com.soft.Appsoft.dao.PrestamoRequest;
import com.soft.Appsoft.modelos.Prestamo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
public class PrestamoServicio {
    @Autowired
    protected PrestamoRepo prestamoRepo;
    @Autowired
    protected UsuarioRepo usuarioRepositorio;

    public  Devolver<Prestamo> obtenerPrestamos(int page, int size) {
        PageRequest pageRequest=PageRequest.of(page,size);
        Page<Prestamo>prestamoPagina=prestamoRepo.findAll(pageRequest);
        return new Devolver<Prestamo>(prestamoPagina);
    }

    public Optional<Prestamo> obtenerPrestamo(Long id) {
        return prestamoRepo.findById(id);
    }

    public Prestamo guardarPrestamo(PrestamoRequest p) {  //patron DTO
        Prestamo pres = new Prestamo();
        pres.setTotal(p.total);
        pres.setUsuario(usuarioRepositorio.findById(p.userId).get());
        return prestamoRepo.save(pres);
    }

    public boolean existePrestamoId(Long id) {
        return prestamoRepo.existsById(id);
    }

    public boolean eliminarPrestamo(Long id) {
      try {
          prestamoRepo.deleteById(id);
          return true;
      }catch (Exception ex){
        return false;
    }
    }

    public Devolver<Prestamo> obtenerPrestamnosDelUser(Long id, int page, int size) {
        PageRequest pageRequest=PageRequest.of(page,size);
        Page<Prestamo>prestamoPagina=
                prestamoRepo.findByUsuario(usuarioRepositorio.findById(id),pageRequest);
        return new Devolver<Prestamo>(prestamoPagina);
    }
}