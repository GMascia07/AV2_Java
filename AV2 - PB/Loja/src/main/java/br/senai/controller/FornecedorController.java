package br.senai.controller;

import br.senai.model.Fornecedor;
import br.senai.model.Produto;
import br.senai.service.FornecedorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class FornecedorController {
    @Autowired
    FornecedorServiceImpl fornecedorService;

    @GetMapping("/fornecedor")
    public List<Fornecedor> findAll(){
        return fornecedorService.findAll();}

    @GetMapping("/fornecedor/{id}")
    public Optional<Fornecedor> findById(@PathVariable long id){
        return fornecedorService.findById(id);
    }

    @PostMapping("/addfornecedor")
    public Fornecedor create(@RequestBody Fornecedor fornecedor){
        return fornecedorService.create(fornecedor);
    }

    @PutMapping("/fornecedor/{id}")
    public Fornecedor update(@RequestBody Fornecedor fornecedor, @PathVariable long id){
        return fornecedorService.update(fornecedor, id);
    }

    @DeleteMapping("/produto/{id}")
    public void delete(@PathVariable long id){
        fornecedorService.delete(id);
    }
}

