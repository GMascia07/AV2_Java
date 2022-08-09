package br.senai.service;

import br.senai.model.Funcionario;
import br.senai.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FuncionarioServiceImpl implements FuncionarioService {
    @Autowired
    FuncionarioRepository funcionarioRepository;

    @Override
    public List<Funcionario> findAll() {return funcionarioRepository.findAll();}

    @Override
    public Optional<Funcionario> findById(long id) {return funcionarioRepository.findById(id);}

    @Override
    public Funcionario create(Funcionario newFuncionario) {return funcionarioRepository.save(newFuncionario);}

    @Override
    public Funcionario update(Funcionario updatedFuncionario, long id) {
        return funcionarioRepository.findById(id)
                .map(u -> {
                    u.setNome(updatedFuncionario.getNome());
                    u.setSobrenome(updatedFuncionario.getSobrenome());
                    u.setLogin(updatedFuncionario.getLogin());
                    u.setSenha(updatedFuncionario.getSenha());
                    return funcionarioRepository.save(u);
                })
                .orElseGet(() ->{
                    updatedFuncionario.setId(id);
                    return  funcionarioRepository.save(updatedFuncionario);
                });
    }

    @Override
    public void delete(long id) {funcionarioRepository.deleteById(id);}
}
