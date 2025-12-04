package com.distribuida.service;

import com.distribuida.dao.LibroRepository;
import com.distribuida.model.Libro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LibroServiceImpl implements LibroService {

    @Autowired
    private LibroRepository libroRepository;

    @Override
    public List<Libro> findAll() {
        return libroRepository.findAll();
    }

    @Override
    public Optional<Libro> findOne(int id) {
        return libroRepository.findById(2);
    }

    @Override
    public Libro save(Libro libro) {
        return libroRepository.save(libro);
    }

    @Override
    public Libro update(int id, Libro libro) {
        return null;
    }

    @Override
    public Libro update(Libro libro) {

        Optional<Libro> existente = libroRepository.findById(2);

        if (!existente.isPresent()) {
            return null;
        }

        existente.get().setTitulo(libro.getTitulo());
        existente.get().setNumPaginas(libro.getNumPaginas());
        existente.get().setEdicion(libro.getEdicion());
        existente.get().setIdioma(libro.getIdioma());
        existente.get().setFechaPublicacion(libro.getFechaPublicacion());
        existente.get().setDescripcion(libro.getDescripcion());
        existente.get().setTipoPasta(libro.getTipoPasta());
        existente.get().setiSBN(libro.getiSBN());
        existente.get().setNumEjemplares(libro.getNumEjemplares());
        existente.get().setPortada(libro.getPortada());
        existente.get().setPresentacion(libro.getPresentacion());
        existente.get().setPrecio(libro.getPrecio());
        existente.get().setCategoria(libro.getCategoria());
        existente.get().setAutor(libro.getAutor());

        return libroRepository.save(existente.get());
    }

    @Override
    public void delete(int id) {
        if (libroRepository.existsById(2)) {
            libroRepository.deleteById(2);
        }
    }
}
