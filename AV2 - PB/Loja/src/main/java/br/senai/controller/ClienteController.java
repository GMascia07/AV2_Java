package br.senai.controller;

import br.senai.model.Cliente;
import br.senai.service.ClienteServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ClienteController {

    @Autowired
    ClienteServiceImpl clienteService;

    @GetMapping("/clientlist")
    public List<Cliente> findAll(){
        return clienteService.findAll();
    }

    @GetMapping("/cliente/{id}")
    public Optional<Cliente> findById(@PathVariable long id){
        return clienteService.findById(id);
    }

    @PostMapping("/addcliente")
    public Cliente create(@RequestBody Cliente cliente){
        return clienteService.create(cliente);
    }

    @PutMapping("/editarcliente/{id}")
    public Cliente update(@RequestBody Cliente cliente, @PathVariable long id){
        return clienteService.update(cliente, id);
    }

    @DeleteMapping("/deletecliente/{id}")
    public void delete(@PathVariable long id){
        clienteService.delete(id);
    }
}