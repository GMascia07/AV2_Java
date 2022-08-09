package br.senai.service;

import br.senai.model.Loja;

import java.util.List;
import java.util.Optional;

public interface LojaService {

    public List<Loja> findAll();
    public Optional<Loja> findById(long id);
    public Loja create(Loja newLoja);
    public Loja update(Loja updatedLoja, long id);
    public void delete(long id);
}