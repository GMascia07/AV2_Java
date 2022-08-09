package br.senai.controller;

import br.senai.model.Produto;
import br.senai.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ProdutoController {
    @Autowired
    ProdutoService produtoService;

    @GetMapping("/produto")
    public List<Produto> findAll(){return produtoService.findAll();}

    @GetMapping("/produto/{id}")
    public Optional<Produto> findById(@PathVariable long id){
        return produtoService.findById(id);
    }

    @PostMapping("/addproduto")
    public Produto create(@RequestBody Produto produto){
        return produtoService.create(produto);
    }

    @PutMapping("/produto/{id}")
    public Produto update(@RequestBody Produto fornecedor, @PathVariable long id){
        return produtoService.update(fornecedor, id);
    }

    @DeleteMapping("/produto/{id}")
    public void delete(@PathVariable long id){
        produtoService.delete(id);
    }
}

