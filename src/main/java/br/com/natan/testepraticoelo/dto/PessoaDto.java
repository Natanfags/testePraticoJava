package br.com.natan.testepraticoelo.dto;

import br.com.natan.testepraticoelo.domain.Pessoa;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

public class PessoaDto implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;

    @NotEmpty(message = "Preenchimento obrigatório")
    @Length(min = 5, max = 150, message = "O tamanho deve entre 5 e 80 caracteres")
    private String nome;

    public PessoaDto() {

    }

    public PessoaDto(Pessoa obj) {
        id = obj.getId();
        nome = obj.getNome();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer codigo) {
        this.id = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}