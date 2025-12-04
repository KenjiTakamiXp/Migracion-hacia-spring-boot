package com.distribuida.service;

import com.distribuida.model.Libro;
import java.util.List;
import java.util.Optional;

public interface LibroService {

    List<Libro> findAll();

    Optional<Libro> findOne(int id);

    Libro save(Libro libro);

    Libro update(int id, Libro libro);

    Libro update(Libro libro);

    void delete(int id);
}
