package br.com.natan.testepraticoelo.repositories;

import br.com.natan.testepraticoelo.domain.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Integer> {

}