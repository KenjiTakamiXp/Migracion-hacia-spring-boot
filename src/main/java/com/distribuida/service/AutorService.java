package com.distribuida.service;

import com.distribuida.model.Autor;
import java.util.List;
import java.util.Optional;

public interface AutorService {

    List<Autor> findAll();

    Optional<Autor> findOne(int id);

    Autor save(Autor autor);

    Autor update(int id, Autor autor);

    Autor update(Autor autor);

    void delete(int id);
}
