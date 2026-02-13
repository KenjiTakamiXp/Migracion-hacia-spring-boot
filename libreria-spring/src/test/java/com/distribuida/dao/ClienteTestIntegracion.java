package com.distribuida.dao;

import com.distribuida.model.Cliente;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import javax.swing.text.html.Option;
import java.sql.SQLOutput;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Transactional
@Rollback(value = false)
public class ClienteTestIntegracion {

    @Autowired
    private ClienteRepository clienteRepository;

    @Test
    public void testClienteFindAll(){
        List<Cliente> clientes = clienteRepository.findAll();
        assertNotNull(clientes);
        assertTrue(clientes.size() > 0);
        for (Cliente item: clientes){
            System.out.println(item.toString());
        }
    }

    @Test
    public void testClienteFindOne(){
        Optional<Cliente> cliente = clienteRepository.findById(1);
        assertTrue(cliente.isPresent());
        assertEquals("Isaac", cliente.orElse(null).getNombre());
        assertEquals("Sanchez", cliente.orElse(null).getApellido());
        System.out.println(cliente);

    }

    @Test
    public void testClienteSave(){
        Cliente cliente = new Cliente(0,"1722702790", "Isaac", "Sanchez", "Antonia Leon", "0999040636", "correo@correo.com");
        Cliente clienteGuardado = clienteRepository.save(cliente);

        assertNotNull(clienteGuardado);
        assertEquals("1722702790", clienteGuardado.getCedula());
        assertEquals("Isaac", clienteGuardado.getNombre());
    }

    @Test
    public void testClienteActualizar(){
        Optional<Cliente> cliente = clienteRepository.findById(2);
        assertTrue(cliente.isPresent());

        cliente.orElse(null).setCedula("1722702790");
        cliente.orElse(null).setNombre("Isaac");
        cliente.orElse(null).setApellido("Sanchez");
        cliente.orElse(null).setDireccion("Antonia Leon");
        cliente.orElse(null).setTelefono("099040636");
        cliente.orElse(null).setCorreo("coreoo@correo.com");

        Cliente clienteActualizado = clienteRepository.save(cliente.orElse(null));

        assertNotNull(clienteActualizado);
        assertEquals("1722702790", clienteActualizado.getCedula());
        assertEquals("Isaac", clienteActualizado.getNombre());

    }

    @Test
    public void testClienteBorrar(){
        if(clienteRepository.existsById(1)){
            clienteRepository.deleteById(1);
        }
        assertFalse(clienteRepository.existsById(1));
    }
}
