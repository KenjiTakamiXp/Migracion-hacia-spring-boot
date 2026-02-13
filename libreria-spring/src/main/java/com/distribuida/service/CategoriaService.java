package com.distribuida.service;

import com.distribuida.model.Categoria;
import java.util.List;
import java.util.Optional;

public interface CategoriaService {

    List<Categoria> findAll();

    Optional<Categoria> findOne(int id);

    Categoria save(Categoria categoria);

    Categoria update(int id, Categoria categoria);

    Categoria update(Categoria categoria);

    void delete(int id);
}
