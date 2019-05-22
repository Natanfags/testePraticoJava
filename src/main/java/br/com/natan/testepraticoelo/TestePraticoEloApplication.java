package br.com.natan.testepraticoelo;

import br.com.natan.testepraticoelo.domain.Pessoa;
import br.com.natan.testepraticoelo.domain.enums.CodigoPessoa;
import br.com.natan.testepraticoelo.repositories.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class TestePraticoEloApplication implements CommandLineRunner {

    @Autowired
    private PessoaRepository pessoaRepository;

    public static void main(String[] args) {
        SpringApplication.run(TestePraticoEloApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        Pessoa pessoa1 = new Pessoa(null, CodigoPessoa.PESSOAFISICA, "Maria Silva", "11111111111-41");
        Pessoa pessoa2 = new Pessoa(null, CodigoPessoa.PESSOAJURIDICA, "José Luis", "22222222222-41");
        Pessoa pessoa3 = new Pessoa(null, CodigoPessoa.PESSOAFISICA, "João Antonio", "3333333333-41");
        Pessoa pessoa4 = new Pessoa(null, CodigoPessoa.PESSOAFISICA, "Alberto Silva", "4444444444-41");
        Pessoa pessoa5 = new Pessoa(null, CodigoPessoa.PESSOAJURIDICA, "Mario Luis", "55555555555-41");
        Pessoa pessoa6 = new Pessoa(null, CodigoPessoa.PESSOAFISICA, "Sergio Antonio", "66666666666-41");
        Pessoa pessoa7 = new Pessoa(null, CodigoPessoa.PESSOAFISICA, "Fernanda Silva", "77777777777-41");
        Pessoa pessoa8 = new Pessoa(null, CodigoPessoa.PESSOAJURIDICA, "Amauri Luis", "88888888888-41");
        Pessoa pessoa9 = new Pessoa(null, CodigoPessoa.PESSOAFISICA, "Steban Antonio", "99999999999-41");

        pessoaRepository.saveAll(Arrays.asList(pessoa1, pessoa2, pessoa3, pessoa4, pessoa5, pessoa6, pessoa7, pessoa8, pessoa9));

    }
}