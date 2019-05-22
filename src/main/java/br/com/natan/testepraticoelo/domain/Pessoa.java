package br.com.natan.testepraticoelo.domain;

import br.com.natan.testepraticoelo.domain.enums.CodigoPessoa;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class Pessoa implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer codigo;
    private String nome;
    private String cpf;

    public Pessoa() {

    }

    public Pessoa(Integer id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Pessoa(Integer id, CodigoPessoa codigo, String nome, String cpf) {
        this.id = id;
        this.codigo = codigo.getCod();
        this.nome = nome;
        this.cpf = cpf;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public CodigoPessoa getCodigo() {
        return CodigoPessoa.toEnum(codigo);
    }

    public void setCodigo(CodigoPessoa codigo) {
        this.codigo = codigo.getCod();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pessoa pessoa = (Pessoa) o;
        return id.equals(pessoa.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}