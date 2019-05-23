package br.com.natan.testepraticoelo.dto;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

public class PessoaNewDto implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer codigo;

    @NotEmpty(message = "Preenchimento obrigatório")
    @Length(min = 5, max = 150, message = "O tamanho deve entre 5 e 80 caracteres")
    private String nome;

    @NotEmpty(message = "Preenchimento obrigatório")
    @CPF
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
