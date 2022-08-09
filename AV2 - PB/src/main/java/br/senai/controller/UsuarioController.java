package br.senai.controller;

import br.senai.model.Usuario;
import br.senai.service.UsuarioServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UsuarioController {

    @Autowired
    UsuarioServiceImpl usuarioService;

    @GetMapping("/userlist")
    public List<Usuario> findAll(){
        return usuarioService.findAll();
    }

    @GetMapping("/usuario/{id}")
    public Optional<Usuario> findById(@PathVariable long id){
        return usuarioService.findById(id);
    }

    @PostMapping("/criarusuario")
    public Usuario create(@RequestBody Usuario usuario){
        return usuarioService.create(usuario);
    }

    @PutMapping("/editarusuario/{id}")
    public Usuario update(@RequestBody Usuario usuario, @PathVariable long id){
        return usuarioService.update(usuario, id);
    }

    @DeleteMapping("/deleteusuario/{id}")
    public void delete(@PathVariable long id){
        usuarioService.delete(id);
    }
}