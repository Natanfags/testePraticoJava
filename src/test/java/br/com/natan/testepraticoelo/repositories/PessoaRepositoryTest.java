package br.com.natan.testepraticoelo.repositories;

import br.com.natan.testepraticoelo.domain.Pessoa;
import br.com.natan.testepraticoelo.domain.enums.CodigoPessoa;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class PessoaRepositoryTest {

    @Autowired
    private PessoaRepository pessoaRepository;

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void createShouldPersistData() {
        Pessoa pessoa = new Pessoa(CodigoPessoa.PESSOAFISICA.getCod(), "Maria", "34787666053");
        this.pessoaRepository.save(pessoa);

        assertThat(pessoa.getId()).isNotNull();
        assertThat(pessoa.getNome()).isEqualTo("Maria");
        assertThat(pessoa.getCpf()).isEqualTo("34787666053");
    }

    @Test
    public void deleteShouldRemoveData() {
        Pessoa pessoa = new Pessoa(CodigoPessoa.PESSOAFISICA.getCod(), "Maria", "34787666053");
        this.pessoaRepository.save(pessoa);
        pessoaRepository.delete(pessoa);

        assertThat(pessoaRepository.findById(pessoa.getId())).isEmpty();
    }

    @Test
    public void updateShouldChangeAndPersistData() {
        Pessoa pessoa = new Pessoa(CodigoPessoa.PESSOAFISICA.getCod(), "Maria", "34787666053");
        this.pessoaRepository.save(pessoa);
        pessoa.setNome("Jose");
        pessoa.setCpf("75893370058");
        pessoa = this.pessoaRepository.save(pessoa);

        assertThat(pessoa.getNome()).isEqualTo("Jose");
        assertThat(pessoa.getCpf()).isEqualTo("75893370058");
    }

}