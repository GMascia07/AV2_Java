package br.senai.controller;

import br.senai.model.Mercado;
import br.senai.service.MercadoServiceImpl;
import br.senai.service.ClienteServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class MercadoController {

    @Autowired
    MercadoServiceImpl mercadoService;

    @GetMapping("/mercado")
    public List<Mercado> findAll(){return mercadoService.findAll();}

    @GetMapping("/mercado/{id}")
    public Optional<Mercado> findById(@PathVariable long id){
        return mercadoService.findById(id);
    }

    @PostMapping("/addmercado")
    public Mercado create(@RequestBody Mercado mercado){
        return mercadoService.create(mercado);
    }

    @PutMapping("/mercado/{id}")
    public Mercado update(@RequestBody Mercado cliente, @PathVariable long id){
        return mercadoService.update(cliente, id);
    }

    @DeleteMapping("/mercado/{id}")
    public void delete(@PathVariable long id){
        mercadoService.delete(id);
    }
}