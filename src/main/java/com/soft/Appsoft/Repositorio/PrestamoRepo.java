package com.soft.Appsoft.Repositorio;

import com.soft.Appsoft.modelos.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
import java.util.ArrayList;
import java.util.Optional;

@Repository
public interface PrestamoRepo extends PagingAndSortingRepository<Prestamo,Long> {
    public abstract Optional<Prestamo> findById(Integer id);
    public abstract ArrayList<Prestamo> findByTotal(float total);
    public abstract Page<Prestamo> findByUsuario(Optional<Usuario> user, PageRequest page);

}
