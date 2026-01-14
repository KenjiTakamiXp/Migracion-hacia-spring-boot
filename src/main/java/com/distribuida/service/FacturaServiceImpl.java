package com.distribuida.service;

import com.distribuida.dao.FacturaRepository;
import com.distribuida.model.Factura;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FacturaServiceImpl implements FacturaService {

    @Autowired
    private FacturaRepository facturaRepository;

    @Override
    public List<Factura> findAll() {
        return facturaRepository.findAll();
    }

    @Override
    public Optional<Factura> findOne(int id) {
        return facturaRepository.findById(id);
    }

    @Override
    public Factura save(Factura factura) {
        return facturaRepository.save(factura);
    }

    @Override
    public Factura update(int id, Factura factura) {
        Optional<Factura> existente = facturaRepository.findById(id);
        if (existente.isEmpty()) return null;

        Factura f = existente.get();
        f.setNumFactura(factura.getNumFactura());
        f.setFecha(factura.getFecha());
        f.setTotalNeto(factura.getTotalNeto());
        f.setIva(factura.getIva());
        f.setTotal(factura.getTotal());
        f.setCliente(factura.getCliente());

        return facturaRepository.save(f);
    }

    @Override
    public Factura update(Factura factura) {
        return update(factura.getIdFactura(), factura);
    }

    @Override
    public void delete(int id) {
        if (facturaRepository.existsById(id)) {
            facturaRepository.deleteById(id);
        }
    }
}
