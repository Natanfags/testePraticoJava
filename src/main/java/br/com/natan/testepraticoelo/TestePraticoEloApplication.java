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

        pessoaRepository.saveAll(Arrays.asList(pessoa1));
        pessoaRepository.saveAll(Arrays.asList(pessoa2));
        pessoaRepository.saveAll(Arrays.asList(pessoa3));

    }
}