package com.distribuida.service;

import com.distribuida.dao.AutorRepository;
import com.distribuida.model.Autor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AutorServiceImpl implements AutorService {

    @Autowired
    private AutorRepository autorRepository;

    @Override
    public List<Autor> findAll() {
        return autorRepository.findAll();
    }

    @Override
    public Optional<Autor> findOne(int id) {
        return autorRepository.findById(id);
    }

    @Override
    public Autor save(Autor autor) {
        return autorRepository.save(autor);
    }

    @Override
    public Autor update(int id, Autor autor) {
        Optional<Autor> existente = autorRepository.findById(id);
        if (existente.isEmpty()) return null;

        Autor a = existente.get();
        a.setNombre(autor.getNombre());
        a.setApellido(autor.getApellido());
        a.setPais(autor.getPais());
        a.setDireccion(autor.getDireccion());
        a.setTelefono(autor.getTelefono());
        a.setCorreo(autor.getCorreo());

        return autorRepository.save(a);
    }

    @Override
    public Autor update(Autor autor) {
        return update(autor.getIdAutor(), autor);
    }

    @Override
    public void delete(int id) {
        if (autorRepository.existsById(id)) {
            autorRepository.deleteById(id);
        }
    }
}
