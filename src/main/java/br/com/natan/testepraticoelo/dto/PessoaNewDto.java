package br.com.natan.testepraticoelo.dto;

import java.io.Serializable;

public class PessoaNewDto implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer codigo;
    private String nome;
    private String cpf;

    public PessoaNewDto(){

    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
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

}
