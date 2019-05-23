package br.com.natan.testepraticoelo.services;
import br.com.natan.testepraticoelo.domain.Pessoa;
import br.com.natan.testepraticoelo.controller.PessoaController;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;
import java.util.List;

import static br.com.natan.testepraticoelo.domain.enums.CodigoPessoa.PESSOAFISICA;
import static br.com.natan.testepraticoelo.domain.enums.CodigoPessoa.PESSOAJURIDICA;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.*;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class PessoaServiceTest {

    private static final int UNKNOWN_ID = Integer.MAX_VALUE;

    private MockMvc mockMvc;

    @Mock
    private PessoaService pessoaService;

    @InjectMocks
    private PessoaController pessoaController;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders
                .standaloneSetup(pessoaController)
                .build();
    }

    @Test
    public void findAllShouldFindAllPessoas() throws Exception {
        List<Pessoa> pessoas = Arrays.asList(
                new Pessoa(1, "Maria Silva"),
                new Pessoa(2, "Jose Cunha"));
        when(pessoaService.findAll()).thenReturn(pessoas);
        mockMvc.perform(get("/pessoas"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(APPLICATION_JSON_UTF8_VALUE))
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].id", is(1)))
                .andExpect(jsonPath("$[0].nome", is("Maria Silva")))
                .andExpect(jsonPath("$[1].id", is(2)))
                .andExpect(jsonPath("$[1].nome", is("Jose Cunha")));
        verify(pessoaService, times(1)).findAll();
        verifyNoMoreInteractions(pessoaService);
    }

    @Test
    public void findShouldFindPessoaById() throws Exception {
        Pessoa pessoa = new Pessoa(1, "Jose Cunha");

        when(pessoaService.find(1)).thenReturn(pessoa);

        mockMvc.perform(get("/pessoas/{id}", 1))
                .andExpect(status().isOk())
                .andExpect(content().contentType(APPLICATION_JSON_UTF8_VALUE))
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.nome", is("Jose Cunha")));

        verify(pessoaService, times(1)).find(1);
        verifyNoMoreInteractions(pessoaService);
    }

    @Test
    public void insertShouldInsertNewPessoa() throws Exception {
        Pessoa pessoa = new Pessoa(1, PESSOAFISICA, "Fernanda Aparecida", "85618702061");

        when(pessoaService.existe(pessoa.getId())).thenReturn(false);
        when(pessoaService.insert(pessoa)).thenReturn(pessoa);

        mockMvc.perform(
                post("/pessoas")
                        .contentType(APPLICATION_JSON)
                        .content(asJsonString(pessoa)))
                .andExpect(status().isCreated())
                .andExpect(header().string("pessoas", containsString("http://localhost:8080/pessoas")));

        verify(pessoaService, times(1)).insert(pessoa);
        verify(pessoaService, times(1)).insert(pessoa);
        verifyNoMoreInteractions(pessoaService);
    }

    @Test
    public void updateShouldUpdatePessoa() throws Exception {
        Pessoa pessoa = new Pessoa(1, "Fernanda Aparecida","85618702061");

        when(pessoaService.find(pessoa.getId())).thenReturn(pessoa);
        when(pessoaService.update(pessoa)).thenReturn(pessoa);

        mockMvc.perform(
                put("/pessoas/{id}", pessoa.getId())
                        .contentType(APPLICATION_JSON_UTF8_VALUE)
                        .content(asJsonString(pessoa)))
                .andExpect(status().isOk());

        verify(pessoaService, times(1)).find(pessoa.getId());
        verify(pessoaService, times(1)).update(pessoa);
        verifyNoMoreInteractions(pessoaService);
    }

    @Test
    public void deleteShouldDeletePessoa() throws Exception {
        Pessoa pessoa = new Pessoa(1, PESSOAFISICA, "Fernanda Aparecida", "85618702061");

        when(pessoaService.find(pessoa.getId())).thenReturn(pessoa);
        doNothing().when(pessoaService).delete(pessoa.getId());

        mockMvc.perform(
                delete("/pessoas/{id}", pessoa.getId()))
                .andExpect(status().isNoContent());

        verify(pessoaService, times(1)).delete(pessoa.getId());
        verifyNoMoreInteractions(pessoaService);
    }

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}