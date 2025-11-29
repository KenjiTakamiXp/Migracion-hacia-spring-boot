package com.distribuida.dao;

import com.distribuida.model.Cliente;
import com.distribuida.model.Factura;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Transactional
@Rollback(value = false)
public class FacturaTestIntegracion {


    @Autowired
    private FacturaRepository facturaRepository;

    @Autowired
    private ClienteRepository clienteRepository;


    @Test
    public void testFacturaFindAll() {
        List<Factura> facturas = facturaRepository.findAll();
        assertNotNull(facturas);
        assertTrue(facturas.size() > 0);
        facturas.forEach(System.out::println);
    }

    @Test
    public void testFacturaFindOne() {
        Factura factura = facturaRepository.findById(1).orElse(null);
        System.out.println(factura);
    }

    @Test
    public void testFacturaSave() {
        Optional<Cliente> cliente = clienteRepository.findById(2);
        assertTrue(cliente.isPresent());

        Factura factura = new Factura();
        factura.setIdFactura(0);
        factura.setNumFactura("FAC-00066");
        factura.setFecha(new Date());
        factura.setTotalNeto(100.00);
        factura.setIva(15.00);
        factura.setTotal(115.00);
        factura.setCliente(cliente.orElse(null));
        Factura facturaGuardada = facturaRepository.save(factura);
        assertNotNull(facturaGuardada);
        assertEquals("FAC-00066", facturaGuardada.getNumFactura());
        assertEquals(100.00, facturaGuardada.getTotalNeto());
    }

    @Test
    public void testFacturaUpdate() {
        Optional<Cliente> cliente = clienteRepository.findById(2);
        assertTrue(cliente.isPresent());
        Optional<Factura> factura = facturaRepository.findById(3);
        assertTrue(factura.isPresent());
        factura.orElse(null).setNumFactura("FAC-00067");
        factura.orElse(null).setFecha(new Date());
        factura.orElse(null).setTotalNeto(110.00);
        factura.orElse(null).setIva(16.00);
        factura.orElse(null).setTotal(126.00);
        factura.orElse(null).setCliente(cliente.orElse(null));

        Factura facturaActualizada =facturaRepository.save((factura).orElse(null));
        assertNotNull(facturaActualizada);
        assertEquals("FAC-00067", facturaActualizada.getNumFactura());
        assertEquals(110.00, facturaActualizada.getTotalNeto());
    }

    @Test
    public void testFacturaDelete() {
        if(facturaRepository.existsById(2)) {
            facturaRepository.deleteById(2);
        }
        assertFalse(facturaRepository.existsById(2));
    }
}
