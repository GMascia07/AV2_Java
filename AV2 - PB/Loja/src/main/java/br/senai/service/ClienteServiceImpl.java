package br.senai.service;

import br.senai.model.Cliente;
import br.senai.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteServiceImpl implements ClienteService{
    @Autowired
    ClienteRepository clienteRepository;

    @Override
    public List<Cliente> findAll() {
        return clienteRepository.findAll();
    }

    @Override
    public Optional<Cliente> findById(long id) {
        return clienteRepository.findById(id);
    }

    @Override
    public Cliente create(Cliente newCliente) {
        return clienteRepository.save(newCliente);
    }

    @Override
    public Cliente update(Cliente updatedCliente, long id) {
        return clienteRepository.findById(id)
                .map(u -> {
                    u.setNome(updatedCliente.getNome());
                    u.setEmail(updatedCliente.getEmail());
                    u.setSenha(updatedCliente.getSenha());
                    return clienteRepository.save(u);
                })
                .orElseGet(() ->{
                    updatedCliente.setId(id);
                    return  clienteRepository.save(updatedCliente);
                });
    }

    @Override
    public void delete(long id) {
        clienteRepository.deleteById(id);
    }
}