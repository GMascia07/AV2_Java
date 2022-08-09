package br.senai.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
public class Fornecedor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(max=100)
    private String nome;

    @NotNull
    @Size(max = 100)
    private String endereco;

    @NotNull
    @Size(max = 100)
    private String email;

    @NotNull
    @Size(max = 50)
    private String telefone;

    public Long getId() {return id;}
    public void setId(Long id) {this.id = id;}
    public String getNome() {return nome;}
    public void setNome(String nome) {this.nome = nome;}
    public String getEndereco() {return endereco;}
    public void setEndereco(String endereco) {this.endereco = endereco;}
    public String getEmail() {return email;}
    public void setEmail(String email) {this.email = email;}

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public List<Fornecedor> getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(List<Fornecedor> fornecedor) {
        this.fornecedor = fornecedor;
    }

    @ManyToMany
    @JoinTable (
    joinColumns = @JoinColumn(name = "fornecedor_id"),
    inverseJoinColumns = @JoinColumn(name = "fornecedor_id", referencedColumnName = "id"))
    private List<Fornecedor> fornecedor;


}
