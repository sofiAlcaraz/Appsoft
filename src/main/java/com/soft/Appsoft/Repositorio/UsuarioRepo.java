package com.soft.Appsoft.Repositorio;

import com.soft.Appsoft.modelos.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.Optional;


@Repository
public interface UsuarioRepo extends PagingAndSortingRepository<Usuario,Long> {
    public abstract Optional<Usuario> findById(Integer id);


}
