package com.distribuida.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ClienteTestUnitaria {

    private Cliente cliente;

    @BeforeEach
    public void setUp() {
        cliente = new Cliente(1, "1722702790", "Juan", "Sanchez", "Casa de alguien", "0999040636", "correo@correo.com");
    }


    @Test
    public void testClienteConstructor(){
        assertAll("Validar datos Cliente - Constructor",
                () -> assertEquals(1, cliente.getIdCliente()),
                () -> assertEquals("1722702790", cliente.getCedula()),
                () -> assertEquals("Juan", cliente.getNombre()),
                () -> assertEquals("Sanchez", cliente.getApellido()),
                () -> assertEquals("Casa de alguien", cliente.getDireccion()),
                () -> assertEquals("0999040636", cliente.getTelefono()),
                () -> assertEquals("correo@correo.com", cliente.getCorreo())
                );
    }



    @Test
    public void testClienteSetters(){
        cliente.setIdCliente(2);
        cliente.setCedula("1722702792");
        cliente.setNombre("Isaac");
        cliente.setApellido("Valencia");
        cliente.setDireccion("Casa de nadie");
        cliente.setTelefono("0999040635");
        cliente.setCorreo("correo2@correo.com");

        assertAll("Validar datos Cliente - Constructor",
                () -> assertEquals(2, cliente.getIdCliente()),
                () -> assertEquals("1722702792", cliente.getCedula()),
                () -> assertEquals("Isaac", cliente.getNombre()),
                () -> assertEquals("Valencia", cliente.getApellido()),
                () -> assertEquals("Casa de nadie", cliente.getDireccion()),
                () -> assertEquals("0999040635", cliente.getTelefono()),
                () -> assertEquals("correo2@correo.com", cliente.getCorreo())
        );
    }


    @Test
    public void testClientetoString(){
        String str = cliente.toString();
        assertAll("Validar datos cliente - to String",
                () -> assertTrue(str.contains("1")),
                () -> assertTrue(str.contains("1722702790")),
                () -> assertTrue(str.contains("Juan")),
                () -> assertTrue(str.contains("Sanchez")),
                () -> assertTrue(str.contains("Casa de alguien")),
                () -> assertTrue(str.contains("0999040636")),
                () -> assertTrue(str.contains("correo@correo.com"))
        );
    }


}
