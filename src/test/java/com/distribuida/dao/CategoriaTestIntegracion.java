package com.distribuida.dao;

import com.distribuida.model.Categoria;
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
public class CategoriaTestIntegracion {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Test
    public void testCategoriaCrear() {
        Categoria categoria = new Categoria();
        categoria.setCategoria("Novela");
        categoria.setDescripcion("Libros de narrativa y ficción");

        categoriaRepository.save(categoria);
        System.out.println("Categoría creada: " + categoria);
    }

    @Test
    public void testCategoriaActualizar() {
        Optional<Categoria> categoriaOpt = categoriaRepository.findById(1);

        if (categoriaOpt.isPresent()) {
            Categoria categoria = categoriaOpt.get();
            categoria.setCategoria("Ciencia ficción");
            categoria.setDescripcion("Libros de ciencia ficción y fantasía");

            categoriaRepository.save(categoria);
            System.out.println("Categoría actualizada: " + categoria);
        }
    }

    @Test
    public void testCategoriaFindAll() {
        List<Categoria> categorias = categoriaRepository.findAll();
        categorias.forEach(System.out::println);
    }

    @Test
    public void testCategoriaFindOne() {
        Categoria categoria = categoriaRepository.findById(1).orElse(null);
        System.out.println(categoria);
    }

    @Test
    public void testCategoriaBorrar() {
        categoriaRepository.deleteById(1);
    }
}
