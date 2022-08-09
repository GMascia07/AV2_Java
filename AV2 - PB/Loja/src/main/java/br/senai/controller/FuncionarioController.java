package br.senai.controller;

import br.senai.model.Cliente;
import br.senai.model.Funcionario;
import br.senai.service.ClienteServiceImpl;
import br.senai.service.FuncionarioServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class FuncionarioController {
    @Autowired
FuncionarioServiceImpl funcionarioService;

    @GetMapping("/funcionariolist")
    public List<Funcionario> findAll(){
        return funcionarioService.findAll();
    }

    @GetMapping("/funcionario/{id}")
    public Optional<Funcionario> findById(@PathVariable long id){
        return funcionarioService.findById(id);
    }

    @PostMapping("/addfuncionario")
    public Funcionario create(@RequestBody Funcionario funcionario){
        return funcionarioService.create(funcionario);
    }

    @PutMapping("/editarfuncionario/{id}")
    public Funcionario update(@RequestBody Funcionario funcionario, @PathVariable long id){
        return funcionarioService.update(funcionario, id);
    }

    @DeleteMapping("/deletefuncionario/{id}")
    public void delete(@PathVariable long id){
        funcionarioService.delete(id);
    }
}