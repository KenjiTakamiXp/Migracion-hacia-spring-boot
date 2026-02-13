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
        return libroRepository.findById(id);
    }

    @Override
    public Libro save(Libro libro) {
        return libroRepository.save(libro);
    }

    @Override
    public Libro update(int id, Libro libro) {
        Optional<Libro> existente = libroRepository.findById(id);
        if (existente.isEmpty()) return null;

        Libro l = existente.get();
        l.setTitulo(libro.getTitulo());
        l.setNumPaginas(libro.getNumPaginas());
        l.setEdicion(libro.getEdicion());
        l.setIdioma(libro.getIdioma());
        l.setFechaPublicacion(libro.getFechaPublicacion());
        l.setDescripcion(libro.getDescripcion());
        l.setTipoPasta(libro.getTipoPasta());
        l.setiSBN(libro.getiSBN());
        l.setNumEjemplares(libro.getNumEjemplares());
        l.setPortada(libro.getPortada());
        l.setPresentacion(libro.getPresentacion());
        l.setPrecio(libro.getPrecio());
        l.setCategoria(libro.getCategoria());
        l.setAutor(libro.getAutor());

        return libroRepository.save(l);
    }

    @Override
    public Libro update(Libro libro) {
        return update(libro.getIdLibro(), libro);
    }

    @Override
    public void delete(int id) {
        if (libroRepository.existsById(id)) {
            libroRepository.deleteById(id);
        }
    }
}
