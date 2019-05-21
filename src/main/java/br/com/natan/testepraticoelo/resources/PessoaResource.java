package br.com.natan.testepraticoelo.resources;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/pessoas")
public class PessoaResource {

    @RequestMapping(method = RequestMethod.GET)
    public String listar(){
        return "Rest esta funcionando";
    }

}