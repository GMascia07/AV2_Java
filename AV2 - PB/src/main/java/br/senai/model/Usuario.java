package br.senai.model;
import javax.persistence.*;
import javax.validation.constraints.Size;
@Entity(name = "usuario")
    public class Usuario {
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
        @JoinColumn(name = "loja_id")
        private Loja loja;

        public Loja getLoja() {
            return loja;
        }

        public void setLoja(Loja loja) {
            this.loja = loja;
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

