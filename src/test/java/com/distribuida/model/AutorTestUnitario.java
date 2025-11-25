package com.distribuida.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AutorTestUnitario {

    private Autor autor;

    @BeforeEach
    public void setUp() {
        autor = new Autor(1, "Diego", "Go", "Ecuador", "Antonia Leon", "0999040636", "correo@correo.com");


}
    @Test
    public void testAutorConstructor(){
    assertAll("Validar Datos Autor - Constructor",
                () -> assertEquals(1, autor.getIdAutor()),
                () -> assertEquals("Diego", autor.getNombre()),
                () -> assertEquals("Go", autor.getApellido()),
                () -> assertEquals("Ecuador", autor.getPais()),
                () -> assertEquals("Antonia Leon", autor.getDireccion()),
                () -> assertEquals("0999040636", autor.getTelefono()),
                () -> assertEquals("correo@correo.com", autor.getCorreo())
        );
    }

    @Test
    public void testAutorSetter(){

        autor = new Autor(2, "Arturo", "El Duro", "Albania", "En su casa", "1234567890","Correo2@correo.com");

        autor.setIdAutor(2);
        autor.setNombre("Arturo");
        autor.setApellido("El Duro");
        autor.setPais("Albania");
        autor.setDireccion("En su casa");
        autor.setTelefono("1234567890");
        autor.setCorreo("Correo2@correo.com");

        assertAll("Validar Setters - Autor",
                () -> assertEquals(2, autor.getIdAutor()),
                () -> assertEquals("Arturo", autor.getNombre()),
                () -> assertEquals("El Duro", autor.getApellido()),
                () -> assertEquals("Albania", autor.getPais()),
                () -> assertEquals("En su casa", autor.getDireccion()),
                () -> assertEquals("1234567890", autor.getTelefono()),
                () -> assertEquals("Correo2@correo.com", autor.getCorreo())

                );
    }

    @Test
    public void testAutorToString(){
        String str = autor.toString();
        assertAll("Validar to string - Autor",
                () -> assertTrue(str.contains("1")),
                () -> assertTrue(str.contains("Diego")),
                () -> assertTrue(str.contains("Go")),
                () -> assertTrue(str.contains("Ecuador")),
                () -> assertTrue(str.contains("Antonia Leon")),
                () -> assertTrue(str.contains("0999040636")),
                () -> assertTrue(str.contains("correo@correo.com"))
                );
    }

    @Test
    public void testClienteInyector(){
        assertAll("Validar metodo inyector - autor",
                () -> assertNotNull(autor.getNombre()),
                () -> assertEquals("Diego", autor.getNombre())
        );
    }


}