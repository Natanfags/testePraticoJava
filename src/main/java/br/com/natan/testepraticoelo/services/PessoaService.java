package br.com.natan.testepraticoelo.services;

import br.com.natan.testepraticoelo.domain.Pessoa;
import br.com.natan.testepraticoelo.domain.enums.CodigoPessoa;
import br.com.natan.testepraticoelo.dto.PessoaDto;
import br.com.natan.testepraticoelo.dto.PessoaNewDto;
import br.com.natan.testepraticoelo.repositories.PessoaRepository;
import br.com.natan.testepraticoelo.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository repo;

    public Pessoa find(Integer id) {
        Optional<Pessoa> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado! Id: " + id + ", Tipo: " + Pessoa.class.getName()));
    }

    public Pessoa insert(Pessoa obj) {
        obj.setId(null);
        return repo.save(obj);
    }

    public Pessoa update(Pessoa obj) {
        Pessoa newObj = find(obj.getId());
        updateData(newObj, obj);
        return repo.save(newObj);
    }

    public void delete(Integer id) {
        find(id);
        repo.deleteById(id);
    }

    public List<Pessoa> findAll() {
        return repo.findAll();
    }

    public Page<Pessoa> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
        PageRequest pageRequest = PageRequest.of(page, linesPerPage, Sort.Direction.valueOf(direction), orderBy);
        return repo.findAll(pageRequest);
    }

    public Pessoa fromDto(PessoaDto objDto) {
        return new Pessoa(objDto.getId(), null, objDto.getNome(), null);
    }

    public Pessoa fromDto(PessoaNewDto objDto) {
        return new Pessoa(null, CodigoPessoa.toEnum(objDto.getCodigo()), objDto.getNome(), objDto.getCpf());
    }

    private void updateData(Pessoa newObj, Pessoa obj) {
        newObj.setId(obj.getId());
        newObj.setNome(obj.getNome());
    }

}