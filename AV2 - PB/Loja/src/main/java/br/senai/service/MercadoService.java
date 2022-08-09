package br.senai.service;

import br.senai.model.Mercado;

import java.util.List;
import java.util.Optional;

public interface MercadoService {

    public List<Mercado> findAll();
    public Optional<Mercado> findById(long id);
    public Mercado create(Mercado newMercado);
    public Mercado update(Mercado updatedMercado, long id);
    public void delete(long id);
}