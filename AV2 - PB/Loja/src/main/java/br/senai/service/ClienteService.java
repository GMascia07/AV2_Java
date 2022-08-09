package br.senai.service;

import br.senai.model.Cliente;

import java.util.List;
import java.util.Optional;

public interface ClienteService {

    public List<Cliente> findAll();
    public Optional<Cliente> findById(long id);
    public Cliente create(Cliente newCliente);
    public Cliente update(Cliente updatedCliente, long id);
    public void delete(long id);
}