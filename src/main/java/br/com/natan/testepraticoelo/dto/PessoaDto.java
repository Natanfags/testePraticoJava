package br.com.natan.testepraticoelo.dto;

import br.com.natan.testepraticoelo.domain.Pessoa;

import java.io.Serializable;

public class PessoaDto implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;
    private String nome;

    public PessoaDto() {

    }

    public PessoaDto(Pessoa obj) {
        id = obj.getId();
        nome = obj.getNome();
    }

    public Integer getCodigo() {
        return id;
    }

    public void setCodigo(Integer codigo) {
        this.id = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}