package br.senai.service;

import br.senai.model.Produto;
import br.senai.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoServiceImpl implements ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;


    @Override
    public List<Produto> findAll() {
        return produtoRepository.findAll();
    }

    @Override
    public Optional<Produto> findById(long id) {
        return produtoRepository.findById(id);
    }

    @Override
    public Produto create(Produto newProduto) {
        return produtoRepository.save(newProduto);
    }

    @Override
    public Produto update(Produto updatedProduto, long id) {

        return produtoRepository.findById(id)
                .map(u -> {
                    u.setNomeDoProduto(updatedProduto.getNomeDoProduto());
                    u.setPreco(updatedProduto.getPreco());
                    return produtoRepository.save(u);
                })
                .orElseGet(() ->{
                    updatedProduto.setId(id);
                    return  produtoRepository.save(updatedProduto);
                });
    }

    @Override
    public void delete(long id) {produtoRepository.deleteById(id);}
}
