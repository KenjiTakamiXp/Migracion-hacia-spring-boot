package com.distribuida.dao;

import com.distribuida.model.Autor;
import com.distribuida.model.Categoria;
import com.distribuida.model.Libro;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Transactional
@Rollback(value = false)
public class LibroTestIntegracion {

    @Autowired
    private LibroRepository libroRepository;

    @Autowired
    private AutorRepository autorRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Test
    public void testLibroCrear() {
        // Se asume que ya existen Autor y Categoria con id = 1
        Autor autor = autorRepository.findById(1).orElse(null);
        Categoria categoria = categoriaRepository.findById(1).orElse(null);

        Libro libro = new Libro();
        libro.setTitulo("Sherlock Holmes");
        libro.setNumPaginas(350);
        libro.setEdicion("Primera edición");
        libro.setIdioma("Inglés");
        libro.setFechaPublicacion(new Date());
        libro.setDescripcion("Colección de historias de detectives");
        libro.setTipoPasta("Pasta dura");
        libro.setiSBN("123-456-789");
        libro.setNumEjemplares(5);
        libro.setPortada("portada_sherlock.jpg");
        libro.setPresentacion("Edición de lujo");
        libro.setPrecio(25.50);
        libro.setAutor(autor);
        libro.setCategoria(categoria);

        libroRepository.save(libro);
        System.out.println("Libro creado: " + libro);
    }

    @Test
    public void testLibroActualizar() {
        Optional<Libro> libroOpt = libroRepository.findById(1);

        if (libroOpt.isPresent()) {
            Libro libro = libroOpt.get();
            libro.setTitulo("Sherlock Holmes - Edición revisada");
            libro.setNumPaginas(400);
            libro.setPrecio(29.99);

            libroRepository.save(libro);
            System.out.println("Libro actualizado: " + libro);
        }
    }

    @Test
    public void testLibroFindAll() {
        List<Libro> libros = libroRepository.findAll();
        libros.forEach(System.out::println);
    }

    @Test
    public void testLibroFindOne() {
        Libro libro = libroRepository.findById(1).orElse(null);
        System.out.println(libro);
    }

    @Test
    public void testLibroBorrar() {
        libroRepository.deleteById(1);
    }
}
