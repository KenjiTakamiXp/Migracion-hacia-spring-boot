package com.distribuida.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public class FacturaDetalleTestUnitario {

    private FacturaDetalle facturaDetalle;
    private Factura factura;
    private Cliente cliente;
    private Libro libro;
    private Autor autor;
    private Categoria categoria;

    @BeforeEach
    public void setUp() {
        // Cliente para la factura
        cliente = new Cliente(
                1,
                "1722702790",
                "Juan",
                "Sánchez",
                "Casa de alguien",
                "0999040636",
                "correo@correo.com"
        );

        // Factura relacionada
        factura = new Factura(
                1,
                "F001-0001",
                new Date(),
                100.00,
                12.00,
                112.00,
                cliente
        );

        // Autor y categoría para el libro
        autor = new Autor(
                1,
                "Arthur",
                "Conan Doyle",
                "Reino Unido",
                "Baker Street 221B",
                "0999999999",
                "arthur@doyle.com"
        );

        categoria = new Categoria(
                1,
                "Novela",
                "Narrativa de misterio y detectives"
        );

        // Libro relacionado
        libro = new Libro(
                1,
                "Sherlock Holmes",
                350,
                "Primera edición",
                "Inglés",
                new Date(),
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

        // FacturaDetalle con relaciones
        facturaDetalle = new FacturaDetalle(
                1,
                2,
                51.00,
                factura,
                libro
        );
    }

    @Test
    public void testFacturaDetalleConstructor() {
        assertAll("Validar datos de FacturaDetalle - Constructor",
                () -> assertEquals(1, facturaDetalle.getIdFacturaDetalle()),
                () -> assertEquals(2, facturaDetalle.getCantidad()),
                () -> assertEquals(51.00, facturaDetalle.getSubtotal()),
                () -> assertNotNull(facturaDetalle.getFactura()),
                () -> assertEquals("F001-0001", facturaDetalle.getFactura().getNumFactura()),
                () -> assertNotNull(facturaDetalle.getLibro()),
                () -> assertEquals("Sherlock Holmes", facturaDetalle.getLibro().getTitulo())
        );
    }

    @Test
    public void testFacturaDetalleSetters() {
        Factura nuevaFactura = new Factura(
                2,
                "F001-0002",
                new Date(),
                200.00,
                24.00,
                224.00,
                cliente
        );

        Categoria nuevaCategoria = new Categoria(2, "Clásicos", "Obras clásicas");
        Autor nuevoAutor = new Autor(2, "Diego", "Go", "Ecuador", "Antonia León", "0999040636", "correo@correo.com");

        Libro nuevoLibro = new Libro(
                2,
                "Nuevo libro",
                150,
                "Segunda edición",
                "Español",
                new Date(),
                "Descripción nueva",
                "Pasta blanda",
                "987-654-321",
                5,
                "nueva_portada.jpg",
                "Edición económica",
                15.99,
                nuevaCategoria,
                nuevoAutor
        );

        facturaDetalle.setIdFacturaDetalle(10);
        facturaDetalle.setCantidad(5);
        facturaDetalle.setSubtotal(79.95);
        facturaDetalle.setFactura(nuevaFactura);
        facturaDetalle.setLibro(nuevoLibro);

        assertAll("Validar datos de FacturaDetalle - Setters",
                () -> assertEquals(10, facturaDetalle.getIdFacturaDetalle()),
                () -> assertEquals(5, facturaDetalle.getCantidad()),
                () -> assertEquals(79.95, facturaDetalle.getSubtotal()),
                () -> assertEquals("F001-0002", facturaDetalle.getFactura().getNumFactura()),
                () -> assertEquals("Nuevo libro", facturaDetalle.getLibro().getTitulo())
        );
    }

    @Test
    public void testFacturaDetalleToString() {
        String str = facturaDetalle.toString();

        assertAll("Validar toString - FacturaDetalle",
                () -> assertTrue(str.contains("FacturaDetalle")),
                () -> assertTrue(str.contains("1")),
                () -> assertTrue(str.contains("Sherlock Holmes")),
                () -> assertTrue(str.contains("F001-0001"))
        );
    }
}
