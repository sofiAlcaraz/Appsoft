package com.soft.Appsoft.controller;

import com.soft.Appsoft.dao.PrestamoRequest;
import com.soft.Appsoft.modelos.Prestamo;
import com.soft.Appsoft.servicio.PrestamoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/appSoft/prestamo")
public class PrestamoController {
    @Autowired
    PrestamoServicio prestamoServicio;


    @PostMapping()
    public Prestamo guardarPrestamo(@RequestBody PrestamoRequest p) {
        return prestamoServicio.guardarPrestamo(p);
    }

    @GetMapping(path = "/{id}")
    public Optional<Prestamo> obtenerPrestamo(@PathVariable("id") Long id) {
        return prestamoServicio.obtenerPrestamo(id);
    }

    @GetMapping()
    @ResponseBody
    public ResponseEntity obtenerPrestamos(@RequestParam(required = false) Long userid,
                                           @RequestParam(defaultValue = "0") int page,
                                           @RequestParam(defaultValue = "1") int size) {
        try {
            if (userid == null) {
                return new ResponseEntity(prestamoServicio.obtenerPrestamos(page, size), HttpStatus.OK);
            }
            return new ResponseEntity(prestamoServicio.obtenerPrestamnosDelUser(userid, page, size), HttpStatus.OK);
        } catch (Exception e) {
            throw e;
            //return new ResponseEntity(null, HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping(path = "/{id}")
    public String eliminarPrestamo(@PathVariable("id") Long id) {
        Boolean seElimino = prestamoServicio.eliminarPrestamo(id);
        if (seElimino) {
            return "se elimino correctamente con id " + id;
        }
        return "no se encontro el usuario con id " + id;
    }

}
