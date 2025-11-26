package com.distribuida.dao;

import com.distribuida.model.Autor;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.List;
import java.util.Optional;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Transactional
@Rollback(value = false)
public class AutorTestIntegracion {

    @Autowired
    private AutorRepository autorRepository;

    @Test
    public void testAutorCrear() {
        Autor autor = new Autor();
        autor.setNombre("Diego");
        autor.setApellido("Go");
        autor.setPais("Ecuador");
        autor.setDireccion("Antonia León");
        autor.setTelefono("0999040636");
        autor.setCorreo("correo@correo.com");

        autorRepository.save(autor);
        System.out.println("Autor creado: " + autor);
    }

    @Test
    public void testAutorActualizar() {
        Optional<Autor> autorOpt = autorRepository.findById(1);

        if (autorOpt.isPresent()) {
            Autor autor = autorOpt.get();
            autor.setDireccion("Dirección actualizada");
            autor.setTelefono("000000000");
            autor.setCorreo("actualizado@correo.com");

            autorRepository.save(autor);
            System.out.println("Autor actualizado: " + autor);
        }
    }

    @Test
    public void testAutorFindAll() {
        List<Autor> autores = autorRepository.findAll();
        autores.forEach(System.out::println);
    }

    @Test
    public void testAutorFindOne() {
        Autor autor = autorRepository.findById(1).orElse(null);
        System.out.println(autor);
    }

    @Test
    public void testAutorBorrar() {
        autorRepository.deleteById(1);
    }
}
