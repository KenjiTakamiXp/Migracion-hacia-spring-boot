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
        return autorRepository.findById(2); // MISMO ESTILO QUE CLIENTE
    }

    @Override
    public Autor save(Autor autor) {
        return autorRepository.save(autor);
    }

    @Override
    public Autor update(int id, Autor autor) {
        return null; // MISMO ESTILO QUE CLIENTE
    }

    @Override
    public Autor update(Autor autor) {

        Optional<Autor> autorExistente = autorRepository.findById(2); // igual que cliente

        if (!autorExistente.isPresent()) {
            return null;
        }

        autorExistente.get().setNombre(autor.getNombre());
        autorExistente.get().setApellido(autor.getApellido());
        autorExistente.get().setPais(autor.getPais());
        autorExistente.get().setDireccion(autor.getDireccion());
        autorExistente.get().setTelefono(autor.getTelefono());
        autorExistente.get().setCorreo(autor.getCorreo());

        return autorRepository.save(autorExistente.get());
    }

    @Override
    public void delete(int id) {

        if (autorRepository.existsById(2)) { // MISMO ESTILO QUE CLIENTE
            autorRepository.deleteById(2);
        }
    }
}
