package br.com.natan.testepraticoelo.domain.enums;

public enum CodigoPessoa {

    PESSOAFISICA(1, "Pessoa Física"),
    PESSOAJURIDICA(2, "Pessoa Jurídica");

    private int cod;
    private String descricao;

    private CodigoPessoa(int cod, String descricao) {
        this.cod = cod;
        this.descricao = descricao;
    }

    public int getCod() {
        return cod;
    }

    public String getDescricao() {
        return descricao;
    }

    public static CodigoPessoa toEnum(Integer cod) {
        if (cod == null) {
            return null;
        }

        for (CodigoPessoa x : CodigoPessoa.values()) {
            if (cod.equals(x.getCod())) {
                return x;
            }
        }

        throw new IllegalArgumentException("Id inválido: " + cod);
    }

}