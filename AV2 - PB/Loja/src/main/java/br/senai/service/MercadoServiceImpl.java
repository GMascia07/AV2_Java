package br.senai.service;

import br.senai.model.Mercado;
import br.senai.repository.MercadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MercadoServiceImpl implements MercadoService {

    @Autowired
    private MercadoRepository mercadoRepository;

    @Override
    public List<Mercado> findAll() {return mercadoRepository.findAll();}

    @Override
    public Optional<Mercado> findById(long id) {return mercadoRepository.findById(id);}

    @Override
    public Mercado create(Mercado newMercado) {return mercadoRepository.save(newMercado);}

    @Override
    public Mercado update(Mercado updatedMercado, long id) {
        return mercadoRepository.findById(id)
                .map(mercado -> {
                    mercado.setNome(updatedMercado.getNome());
                    mercado.setEndereco(updatedMercado.getEndereco());
                    return mercadoRepository.save(mercado);
                })
                .orElseGet(() ->{
                    updatedMercado.setId(id);
                    return  mercadoRepository.save(updatedMercado);
                });
    }

    @Override
    public void delete(long id) {

    }
}