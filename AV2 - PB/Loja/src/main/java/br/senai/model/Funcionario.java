package br.senai.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity(name = "funcionario")
public class Funcionario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(max=100)
    private String nome;

    @Size(max = 100)
    private String sobrenome;

    @Size(max = 100)
    private String login;

    @Size(max = 150)
    @NotNull
    private String senha;

    @ManyToMany
    @JoinColumn(name = "mercado_id")
    private Mercado mercado;

    public Long getId() {return id;}
    public void setId(Long id) {this.id = id;}
    public String getNome() {return nome;}
    public void setNome(String nome) {this.nome = nome;}
    public String getSobrenome() {return sobrenome;}
    public void setSobrenome(String sobrenome) {this.sobrenome = sobrenome;}
    public String getLogin() {return login;}
    public void setLogin(String login) {this.login = login;}
    public String getSenha() {return senha;}
    public void setSenha(String senha) {this.senha = senha;}

    @Override
    public String toString() {
        return "Funcionario{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", sobrenome='" + sobrenome + '\'' +
                ", login='" + login + '\'' +
                ", senha='" + senha + '\'' +
                ", mercado=" + mercado +
                '}';
    }
}