package com.soft.Appsoft.controller;

import com.soft.Appsoft.servicio.*;
import com.soft.Appsoft.modelos.Usuario;
import org.slf4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/appSoft") //raiz de la url
@ResponseBody
public class UsuarioController {
    @Autowired
    private UsuarioServicio serviceImple; /*estionar las peticiones que se hagan a nuestra API*/

    @Autowired
    private PrestamoServicio prestamoServicio;

    private static Logger logger = LoggerFactory.getLogger(UsuarioController.class);

   /* @RequestMapping("/hola")
    public String helloWorld() {
     logger.info("hi!");
        return "Hello World!";
    }*/

    @GetMapping()
    public ArrayList<Usuario>obtenerUsuarios(){
        return serviceImple.obtenerUsuarios();
    }

    @PostMapping()
    public Usuario guardarUsuario(@RequestBody Usuario user){
        return serviceImple.guardarUsuario(user);
    }

    @GetMapping(path ="/{id}")
    public Optional<Usuario> obtenerUsuarioPorId(@PathVariable ("id")Long id){
    return serviceImple.obtenerUserporId(id);
    }

    @DeleteMapping(path ="/{id}")
    public String eliminarUsuario(@PathVariable ("id")Long id){
        boolean seElimino= serviceImple.eliminarUsuario(id);
        if(seElimino){
            return "se elimino correctamente con id "+ id ;
        }
        return "no se encontro el usuario con id " + id;
    }

/*
ejemplos
@ApiResponse (código = 400, mensaje = "Excepción del sistema", respuesta = RedisService.class),
 @ApiResponse (código = 401, mensaje = "Excepción de prueba", respuesta = AreaMapper.class)
 @ApiOperation (value = "Obtener área por areaId", notas = "Obtener área por id de url")
 */

}

