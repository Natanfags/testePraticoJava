package br.com.natan.testepraticoelo.resources;

import br.com.natan.testepraticoelo.domain.Pessoa;
import br.com.natan.testepraticoelo.domain.enums.CodigoPessoa;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/pessoas")
public class PessoaResource {

    @RequestMapping(method = RequestMethod.GET)
    public List<Pessoa> listar(){

        Pessoa p1 = new Pessoa(1, CodigoPessoa.toEnum(1),"Maria","1111111-12");
        Pessoa p2 = new Pessoa(2, CodigoPessoa.toEnum(2),"Jose","2222222-12");
        Pessoa p3 = new Pessoa(3, CodigoPessoa.toEnum(1),"João","3333333-12");

        List<Pessoa> listaPessoas = new ArrayList<>();
        listaPessoas.add(p1);
        listaPessoas.add(p2);
        listaPessoas.add(p3);

        return listaPessoas;
    }

}