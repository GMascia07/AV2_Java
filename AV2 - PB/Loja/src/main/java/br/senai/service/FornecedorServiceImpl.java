package br.senai.service;

import br.senai.model.Fornecedor;
import br.senai.repository.FornecedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

    @Service
    public class FornecedorServiceImpl implements FornecedorService {

        @Autowired
        private FornecedorRepository fornecedorRepository;


        @Override
        public List<Fornecedor> findAll() {
            return null;
        }

        @Override
        public Optional<Fornecedor> findById(long id) {return fornecedorRepository.findById(id);}

        @Override
        public Fornecedor create(Fornecedor newFornecedor) {return fornecedorRepository.save((newFornecedor));}

        @Override
        public Fornecedor update(Fornecedor updatedFornecedor, long id){

            return fornecedorRepository.findById(id)
                    .map(u -> {
                        u.setNome(updatedFornecedor.getNome());
                        u.setEndereco(updatedFornecedor.getEndereco());
                        u.setEmail(updatedFornecedor.getEmail());
                        u.setTelefone(updatedFornecedor.getTelefone());
                        return fornecedorRepository.save(u);
                    })
                    .orElseGet(
                            () -> {
                                updatedFornecedor.setId(id);
                                return  fornecedorRepository.save(updatedFornecedor);

                            }
                    );

        }

        @Override
        public void delete(long id) {

        }
    }

