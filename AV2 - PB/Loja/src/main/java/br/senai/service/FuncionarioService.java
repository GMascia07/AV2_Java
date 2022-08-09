package br.senai.service;

import br.senai.model.Funcionario;

import java.util.List;
import java.util.Optional;

public interface FuncionarioService {
    public List<Funcionario> findAll();
    public Optional<Funcionario> findById(long id);
    public Funcionario create(Funcionario newFuncionario);
    public Funcionario update(Funcionario updatedFuncionario, long id);
    public void delete(long id);
}
