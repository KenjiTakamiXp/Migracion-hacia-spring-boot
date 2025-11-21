package com.distribuida.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FacturaTestUnitaria {

    private Cliente cliente;
    private Factura factura;

    @BeforeEach
    public void setUp() {
        cliente = new Cliente(1, "1722702790", "Juan", "Sanchez", "Casa de alguien", "0999040636", "correo@correo.com");;
        factura = new Factura();
        factura.setIdFactura(1);
        factura.setNumFactura("01");
        factura.setFecha(new Date());
        factura.setTotalNeto(100.00);
        factura.setIva(15.00);
        factura.setTotal(115.00);
        //inyeccion de dependencias
        factura.setCliente(cliente);
    }

    @Test
    public void facturaTestConstructor() {
        assertAll("Validar Constructor - Factura",
                () -> assertEquals(1, factura.getIdFactura()),
                () -> assertEquals("01", factura.getNumFactura()),
                //() -> assertEquals(new Date(), factura.getFecha()),
                () -> assertEquals(100.00, factura.getTotalNeto()),
                () -> assertEquals(15.00, factura.getIva()),
                () -> assertEquals(115.00, factura.getTotal()),
                () -> assertEquals("Juan", factura.getCliente().getNombre())
                );
    }

    @Test
    public void facturaTestSetters(){

        cliente = new Cliente(2, "1722702792", "Juan2", "Sanchez2", "Casa de alguien2", "09990406362", "correo@correo.com2");



        factura.setIdFactura(2);
        factura.setNumFactura("02");
        factura.setFecha(new Date());
        factura.setTotalNeto(110.00);
        factura.setIva(16.00);
        factura.setTotal(126.00);

        factura.setCliente(cliente);

        assertAll("Validar Setters - Factura",
                () -> assertEquals(2, factura.getIdFactura()),
                () -> assertEquals("02", factura.getNumFactura()),
                //() -> assertEquals(new Date(), factura.getFecha()),
                () -> assertEquals(110.00, factura.getTotalNeto()),
                () -> assertEquals(16.00, factura.getIva()),
                () -> assertEquals(126.00, factura.getTotal()),
                () -> assertEquals("Juan2", factura.getCliente().getNombre())
        );

    }

    @Test
    public void facturaTesttoString(){

        String str = factura.toString();
        assertAll("Validar to String - Factura",
                () -> assertTrue(str.contains("1")),
                () -> assertTrue(str.contains("01")),
                () -> assertTrue(str.contains("100")),
                () -> assertTrue(str.contains("15")),
                () -> assertTrue(str.contains("115")),
                () -> assertTrue(str.contains("Juan"))
                );
    }

    @Test
    public void facturaTestInyector(){
        assertAll("Validar metodo inyector - Factura",
                () -> assertNotNull(factura.getCliente()),
                () -> assertEquals("Sanchez", factura.getCliente().getApellido())
                );
    }

    @Test
    public void facturaTestValoresNegativos(){
        factura.setTotal(-100.00);
        assertAll("Validar datos negativos - Factura",
                () -> assertEquals(-100.00, factura.getTotal())
                );
        // Validar los campos negativos, solo deberia existir valores positivos

    }

}
