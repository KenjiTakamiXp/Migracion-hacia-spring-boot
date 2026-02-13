package com.distribuida.service;

import com.distribuida.model.FacturaDetalle;
import java.util.List;
import java.util.Optional;

public interface FacturaDetalleService {

    List<FacturaDetalle> findAll();

    Optional<FacturaDetalle> findOne(int id);

    FacturaDetalle save(FacturaDetalle detalle);

    FacturaDetalle update(int id, FacturaDetalle detalle);

    FacturaDetalle update(FacturaDetalle detalle);

    void delete(int id);
}
