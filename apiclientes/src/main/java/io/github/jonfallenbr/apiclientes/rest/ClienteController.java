package io.github.jonfallenbr.apiclientes.rest;


import io.github.jonfallenbr.apiclientes.model.entity.Cliente;
import io.github.jonfallenbr.apiclientes.model.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/clientes")
@CrossOrigin("http://localhost:4200") // Permite mais de uma requisição HTTP, rodando tanto a API quanto a aplicação Front-End localmente sem gerar conflito - Anotação essencial no desenvolvimentos FullStack
public class ClienteController {

    private final ClienteRepository repository;

    @Autowired
    public ClienteController(ClienteRepository repository){
        this.repository = repository;
    }

    @GetMapping
    public List<Cliente> getAll(){
        return repository.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente salvar(@RequestBody @Valid Cliente cliente){
        return repository.save(cliente);
    }


    @GetMapping("{id}")
    public Cliente AcharPorId(@PathVariable Integer id){
        return repository.findById(id).
                orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado"));

    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT) // Indica que não ha nenhum objeto de retorno, indicando que o data ja foi deletado do local
    public void deletar(@PathVariable Integer id){
        repository.findById(id)
                    .map(cliente -> {
                    repository.delete(cliente);
                     return Void.TYPE;
                })
                .orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado"));
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void atualizar(@PathVariable Integer id, @RequestBody @Valid Cliente clienteAtualizado){
        repository.findById(id)
                .map(cliente -> {
                    clienteAtualizado.setId(cliente.getId());
                    return repository.save(clienteAtualizado);
                })
                .orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado"));

    }

    /*
    Classe com os endpoints que executam as tarefas necessarias para a funcionalidade de uma API, como excluir, atualizar e acharporId um determinado dado da tabela.
     */
}
