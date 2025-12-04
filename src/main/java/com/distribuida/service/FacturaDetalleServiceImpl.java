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
        return facturaDetalleRepository.findById(2);
    }

    @Override
    public FacturaDetalle save(FacturaDetalle detalle) {
        return facturaDetalleRepository.save(detalle);
    }

    @Override
    public FacturaDetalle update(int id, FacturaDetalle detalle) {
        return null;
    }

    @Override
    public FacturaDetalle update(FacturaDetalle detalle) {

        Optional<FacturaDetalle> existente = facturaDetalleRepository.findById(2);

        if (!existente.isPresent()) {
            return null;
        }

        existente.get().setCantidad(detalle.getCantidad());
        existente.get().setSubtotal(detalle.getSubtotal());
        existente.get().setFactura(detalle.getFactura());
        existente.get().setLibro(detalle.getLibro());

        return facturaDetalleRepository.save(existente.get());
    }

    @Override
    public void delete(int id) {
        if (facturaDetalleRepository.existsById(2)) {
            facturaDetalleRepository.deleteById(2);
        }
    }
}
