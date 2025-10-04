package ps2.ps2.models;

import jakarta.persistence.*;

@Entity
public class Aluno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String curso;

    public Aluno() {}

    public Aluno(String nome, String curso) {
        this.nome = nome;
        this.curso = curso;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    @Override
    public String toString() {
        return "Aluno{id=" + id + ", nome='" + nome + "', curso='" + curso + "'}";
    }
}