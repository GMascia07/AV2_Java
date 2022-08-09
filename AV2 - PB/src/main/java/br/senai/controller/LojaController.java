package br.senai.controller;

import br.senai.model.Loja;
import br.senai.service.LojaServiceImpl;
import br.senai.service.UsuarioServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class LojaController {

    @Autowired
    LojaServiceImpl lojaService;

    @GetMapping("/lojalist")
    public List<Loja> findAll(){return lojaService.findAll();}

    @GetMapping("/loja/{id}")
    public Optional<Loja> findById(@PathVariable long id){
        return lojaService.findById(id);
    }

    @PostMapping("/criarloja")
    public Loja create(@RequestBody Loja loja){
        return lojaService.create(loja);
    }

    @PutMapping("/editarloja/{id}")
    public Loja update(@RequestBody Loja usuario, @PathVariable long id){
        return lojaService.update(usuario, id);
    }

    @DeleteMapping("/deleteloja/{id}")
    public void delete(@PathVariable long id){
        lojaService.delete(id);
    }
}