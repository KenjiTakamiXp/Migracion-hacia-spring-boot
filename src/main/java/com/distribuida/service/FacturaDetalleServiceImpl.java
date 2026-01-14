package com.distribuida.service;

import com.distribuida.dao.FacturaDetalleRepository;
import com.distribuida.model.FacturaDetalle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FacturaDetalleServiceImpl implements FacturaDetalleService {

    @Autowired
    private FacturaDetalleRepository facturaDetalleRepository;

    @Override
    public List<FacturaDetalle> findAll() {
        return facturaDetalleRepository.findAll();
    }

    @Override
    public Optional<FacturaDetalle> findOne(int id) {
        return facturaDetalleRepository.findById(id);
    }

    @Override
    public FacturaDetalle save(FacturaDetalle detalle) {
        return facturaDetalleRepository.save(detalle);
    }

    @Override
    public FacturaDetalle update(int id, FacturaDetalle detalle) {
        Optional<FacturaDetalle> existente = facturaDetalleRepository.findById(id);
        if (existente.isEmpty()) return null;

        FacturaDetalle d = existente.get();
        d.setCantidad(detalle.getCantidad());
        d.setSubtotal(detalle.getSubtotal());
        d.setFactura(detalle.getFactura());
        d.setLibro(detalle.getLibro());

        return facturaDetalleRepository.save(d);
    }

    @Override
    public FacturaDetalle update(FacturaDetalle detalle) {
        return update(detalle.getIdFacturaDetalle(), detalle);
    }

    @Override
    public void delete(int id) {
        if (facturaDetalleRepository.existsById(id)) {
            facturaDetalleRepository.deleteById(id);
        }
    }
}
