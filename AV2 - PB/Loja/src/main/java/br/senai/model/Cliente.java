package br.senai.model;
import javax.persistence.*;
import javax.validation.constraints.Size;
@Entity(name = "cliente")
    public class Cliente {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Size(max=100)
        private String nome;

        @Size(max = 100)
        private String email;

        @Size(max = 50)
        private String senha;

        @ManyToOne
        @JoinColumn(name = "mercado_id")
        private Mercado mercado;

        public Mercado getMercado() {
            return mercado;
        }
        public void setMercado(Mercado mercado) {
            this.mercado = mercado;
        }
        public Long getId() {
            return id;
        }
        public void setId(Long id) {
            this.id = id;
        }
        public String getNome() {
            return nome;
        }
        public void setNome(String nome) {
            this.nome = nome;
        }
        public String getEmail() {
            return email;
        }
        public void setEmail(String email) {
            this.email = email;
        }
        public String getSenha() {
            return senha;
        }
        public void setSenha(String senha) {
            this.senha = senha;
        }

         @Override
        public String toString() {
            return "Usuario{" +
                    "id=" + id +
                    ", nome='" + nome + '\'' +
                    ", email='" + email + '\'' +
                    ", senha='" + senha + '\'' +
                    '}';
       }


    }

