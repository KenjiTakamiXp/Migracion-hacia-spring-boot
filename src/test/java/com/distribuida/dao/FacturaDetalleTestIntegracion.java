package com.distribuida.dao;

import com.distribuida.model.FacturaDetalle;
import com.distribuida.model.Factura;
import com.distribuida.model.Libro;
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
public class FacturaDetalleTestIntegracion {

    @Autowired
    private FacturaDetalleRepository facturaDetalleRepository;

    @Autowired
    private FacturaRepository facturaRepository;

    @Autowired
    private LibroRepository libroRepository;

    @Test
    public void testFacturaDetalleCrear() {
        // Se asume que ya existe una factura y un libro con id = 1
        Factura factura = facturaRepository.findById(1).orElse(null);
        Libro libro = libroRepository.findById(1).orElse(null);

        FacturaDetalle detalle = new FacturaDetalle();
        detalle.setCantidad(2);
        detalle.setSubtotal(51.00);
        detalle.setFactura(factura);
        detalle.setLibro(libro);

        facturaDetalleRepository.save(detalle);
        System.out.println("FacturaDetalle creado: " + detalle);
    }

    @Test
    public void testFacturaDetalleActualizar() {
        Optional<FacturaDetalle> detalleOpt = facturaDetalleRepository.findById(1);

        if (detalleOpt.isPresent()) {
            FacturaDetalle detalle = detalleOpt.get();
            detalle.setCantidad(3);
            detalle.setSubtotal(75.50);

            facturaDetalleRepository.save(detalle);
            System.out.println("FacturaDetalle actualizado: " + detalle);
        }
    }

    @Test
    public void testFacturaDetalleFindAll() {
        List<FacturaDetalle> detalles = facturaDetalleRepository.findAll();
        detalles.forEach(System.out::println);
    }

    @Test
    public void testFacturaDetalleFindOne() {
        FacturaDetalle detalle = facturaDetalleRepository.findById(1).orElse(null);
        System.out.println(detalle);
    }

    @Test
    public void testFacturaDetalleBorrar() {
        facturaDetalleRepository.deleteById(1);
    }
}
