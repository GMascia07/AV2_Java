package br.senai.service;

import br.senai.model.Fornecedor;
import java.util.List;
import java.util.Optional;

public interface FornecedorService {

        public List<Fornecedor> findAll();
        public Optional<Fornecedor> findById(long id);
        public Fornecedor create(Fornecedor newFornecedor);
        public Fornecedor update(Fornecedor updatedFornecedor, long id);
        public void delete(long id);
    }


