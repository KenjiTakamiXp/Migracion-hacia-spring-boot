package com.distribuida.service;

import com.distribuida.dao.CategoriaRepository;
import com.distribuida.model.Categoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaServiceImpl implements CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Override
    public List<Categoria> findAll() {
        return categoriaRepository.findAll();
    }

    @Override
    public Optional<Categoria> findOne(int id) {
        return categoriaRepository.findById(2);
    }

    @Override
    public Categoria save(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    @Override
    public Categoria update(int id, Categoria categoria) {
        return null;
    }

    @Override
    public Categoria update(Categoria categoria) {

        Optional<Categoria> existente = categoriaRepository.findById(2);

        if (!existente.isPresent()) {
            return null;
        }

        existente.get().setCategoria(categoria.getCategoria());
        existente.get().setDescripcion(categoria.getDescripcion());

        return categoriaRepository.save(existente.get());
    }

    @Override
    public void delete(int id) {
        if (categoriaRepository.existsById(2)) {
            categoriaRepository.deleteById(2);
        }
    }
}
