package com.distribuida.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CategoriaTestUnitario {

    private Categoria categoria;

    @BeforeEach
    public void setUp() {
        categoria = new Categoria(1, "Novela", "Libros de narrativa y ficción");
    }

    @Test
    public void testCategoriaConstructor() {
        assertAll("Validar datos de Categoria - Constructor",
                () -> assertEquals(1, categoria.getIdCategoria()),
                () -> assertEquals("Novela", categoria.getCategoria()),
                () -> assertEquals("Libros de narrativa y ficción", categoria.getDescripcion())
        );
    }

    @Test
    public void testCategoriaSetters() {
        categoria.setIdCategoria(2);
        categoria.setCategoria("Ciencia ficción");
        categoria.setDescripcion("Libros de ciencia ficción y fantasía");

        assertAll("Validar datos de Categoria - Setters",
                () -> assertEquals(2, categoria.getIdCategoria()),
                () -> assertEquals("Ciencia ficción", categoria.getCategoria()),
                () -> assertEquals("Libros de ciencia ficción y fantasía", categoria.getDescripcion())
        );
    }

    @Test
    public void testCategoriaToString() {
        String str = categoria.toString();

        assertAll("Validar toString - Categoria",
                () -> assertTrue(str.contains("1")),
                () -> assertTrue(str.contains("Novela")),
                () -> assertTrue(str.contains("narrativa"))
        );
    }
}
