package com.distribuida.service;

import com.distribuida.dao.ClienteRepository;
import com.distribuida.model.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public List<Cliente> findAll() {
        return clienteRepository.findAll();
    }

    @Override
    public Optional<Cliente> findOne(int id) {
        return clienteRepository.findById(id);
    }

    @Override
    public Cliente save(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    @Override
    public Cliente update(int id, Cliente cliente) {
        Optional<Cliente> existente = clienteRepository.findById(id);
        if (existente.isEmpty()) return null;

        Cliente c = existente.get();
        c.setCedula(cliente.getCedula());
        c.setNombre(cliente.getNombre());
        c.setApellido(cliente.getApellido());
        c.setDireccion(cliente.getDireccion());
        c.setTelefono(cliente.getTelefono());
        c.setCorreo(cliente.getCorreo());

        return clienteRepository.save(c);
    }

    @Override
    public Cliente update(Cliente cliente) {
        return update(cliente.getIdCliente(), cliente);
    }

    @Override
    public void delete(int id) {
        if (clienteRepository.existsById(id)) {
            clienteRepository.deleteById(id);
        }
    }
}
