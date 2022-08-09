package br.senai.service;

import br.senai.model.Produto;

import java.util.List;
import java.util.Optional;

public interface ProdutoService {

    public List<Produto> findAll();
    public Optional<Produto> findById(long id);
    public Produto create(Produto newProduto);
    public Produto update(Produto updatedProduto, long id);
    public void delete(long id);
}
