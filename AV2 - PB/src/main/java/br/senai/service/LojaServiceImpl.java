package br.senai.service;

import br.senai.model.Loja;
import br.senai.repository.LojaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LojaServiceImpl implements LojaService {

    @Autowired
    private LojaRepository lojaRepository;

    @Override
    public List<Loja> findAll() {return lojaRepository.findAll();}

    @Override
    public Optional<Loja> findById(long id) {return lojaRepository.findById(id);}

    @Override
    public Loja create(Loja newLoja) {return lojaRepository.save(newLoja);}

    @Override
    public Loja update(Loja updatedLoja, long id) {
        return lojaRepository.findById(id)
                .map(loja -> {
                    loja.setNome(updatedLoja.getNome());
                    loja.setEndereco(updatedLoja.getEndereco());
                    return lojaRepository.save(loja);
                })
                .orElseGet(() ->{
                    updatedLoja.setId(id);
                    return  lojaRepository.save(updatedLoja);
                });
    }

    @Override
    public void delete(long id) {

    }
}