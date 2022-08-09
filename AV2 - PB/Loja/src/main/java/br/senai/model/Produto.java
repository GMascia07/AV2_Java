package br.senai.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.validation.constraints.Size;
import java.util.List;

public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(max = 100)
    private String nomeDoProduto;

    @Size(max = 50)
    private double preco;

    @ManyToMany(mappedBy = "fornecedor")
    private List<Fornecedor> fornecedor;

    public Long getId() {return id;}
    public void setId(Long id) {this.id = id;}
    public String getNomeDoProduto() {return nomeDoProduto;}
    public void setNomeDoProduto(String nomeDoProduto) {this.nomeDoProduto = nomeDoProduto;}
    public double getPreco() {return preco;}
    public void setPreco(double preco) {
        this.preco = preco;
    }

    @Override
    public String toString() {
        return "Produto{" +
                "id=" + id +
                ", nomeDoProduto='" + nomeDoProduto + '\'' +
                ", preco=" + preco +
                '}';
    }
}
