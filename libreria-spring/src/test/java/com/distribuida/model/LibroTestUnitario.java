package com.distribuida.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import static org.junit.jupiter.api.Assertions.*;

public class LibroTestUnitario {

    private Libro libro;
    private Autor autor;
    private Categoria categoria;
    private Date fechaPublicacion;

    @BeforeEach
    public void setUp() {
        // Autor relacionado
        autor = new Autor(
                1,
                "Arthur",
                "Conan Doyle",
                "Reino Unido",
                "Baker Street 221B",
                "0999999999",
                "arthur@doyle.com"
        );

        // Categoria relacionada
        categoria = new Categoria(
                1,
                "Novela",
                "Narrativa de misterio y detectives"
        );

        // Fecha de publicación
        fechaPublicacion = new GregorianCalendar(1892, Calendar.JANUARY, 1).getTime();

        // Libro con todos los datos y relaciones
        libro = new Libro(
                1,
                "Sherlock Holmes",
                350,
                "Primera edición",
                "Inglés",
                fechaPublicacion,
                "Colección de historias de detectives",
                "Pasta dura",
                "123-456-789",
                3,
                "portada_sherlock.jpg",
                "Presentación de lujo",
                25.50,
                categoria,
                autor
        );
    }

    @Test
    public void testLibroConstructor() {
        assertAll("Validar datos de Libro - Constructor",
                () -> assertEquals(1, libro.getIdLibro()),
                () -> assertEquals("Sherlock Holmes", libro.getTitulo()),
                () -> assertEquals(350, libro.getNumPaginas()),
                () -> assertEquals("Primera edición", libro.getEdicion()),
                () -> assertEquals("Inglés", libro.getIdioma()),
                () -> assertEquals(fechaPublicacion, libro.getFechaPublicacion()),
                () -> assertEquals("Colección de historias de detectives", libro.getDescripcion()),
                () -> assertEquals("Pasta dura", libro.getTipoPasta()),
                () -> assertEquals("123-456-789", libro.getiSBN()),
                () -> assertEquals(3, libro.getNumEjemplares()),
                () -> assertEquals("portada_sherlock.jpg", libro.getPortada()),
                () -> assertEquals("Presentación de lujo", libro.getPresentacion()),
                () -> assertEquals(25.50, libro.getPrecio()),
                // Relaciones
                () -> assertNotNull(libro.getCategoria()),
                () -> assertEquals("Novela", libro.getCategoria().getCategoria()),
                () -> assertNotNull(libro.getAutor()),
                () -> assertEquals("Arthur", libro.getAutor().getNombre())
        );
    }

    @Test
    public void testLibroSetters() {
        Date nuevaFecha = new GregorianCalendar(1900, Calendar.JUNE, 15).getTime();

        Categoria nuevaCategoria = new Categoria(2, "Clásicos", "Obras clásicas de la literatura");
        Autor nuevoAutor = new Autor(2, "Diego", "Go", "Ecuador", "Antonia León", "0999040636", "correo@correo.com");

        libro.setIdLibro(2);
        libro.setTitulo("Nuevo título");
        libro.setNumPaginas(400);
        libro.setEdicion("Segunda edición");
        libro.setIdioma("Español");
        libro.setFechaPublicacion(nuevaFecha);
        libro.setDescripcion("Nueva descripción");
        libro.setTipoPasta("Pasta blanda");
        libro.setiSBN("987-654-321");
        libro.setNumEjemplares(10);
        libro.setPortada("nueva_portada.jpg");
        libro.setPresentacion("Edición económica");
        libro.setPrecio(15.99);
        libro.setCategoria(nuevaCategoria);
        libro.setAutor(nuevoAutor);

        assertAll("Validar datos de Libro - Setters",
                () -> assertEquals(2, libro.getIdLibro()),
                () -> assertEquals("Nuevo título", libro.getTitulo()),
                () -> assertEquals(400, libro.getNumPaginas()),
                () -> assertEquals("Segunda edición", libro.getEdicion()),
                () -> assertEquals("Español", libro.getIdioma()),
                () -> assertEquals(nuevaFecha, libro.getFechaPublicacion()),
                () -> assertEquals("Nueva descripción", libro.getDescripcion()),
                () -> assertEquals("Pasta blanda", libro.getTipoPasta()),
                () -> assertEquals("987-654-321", libro.getiSBN()),
                () -> assertEquals(10, libro.getNumEjemplares()),
                () -> assertEquals("nueva_portada.jpg", libro.getPortada()),
                () -> assertEquals("Edición económica", libro.getPresentacion()),
                () -> assertEquals(15.99, libro.getPrecio()),
                () -> assertEquals("Clásicos", libro.getCategoria().getCategoria()),
                () -> assertEquals("Diego", libro.getAutor().getNombre())
        );
    }

    @Test
    public void testLibroToString() {
        String str = libro.toString();

        assertAll("Validar toString - Libro",
                () -> assertTrue(str.contains("Sherlock Holmes")),
                () -> assertTrue(str.contains("Novela")),
                () -> assertTrue(str.contains("Arthur")),
                () -> assertTrue(str.contains("123-456-789"))
        );
    }
}
