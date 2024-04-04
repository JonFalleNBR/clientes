package io.github.jonfallenbr.apiclientes.rest;


import io.github.jonfallenbr.apiclientes.model.entity.Cliente;
import io.github.jonfallenbr.apiclientes.model.entity.ServicoPrestado;
import io.github.jonfallenbr.apiclientes.model.repository.ClienteRepository;
import io.github.jonfallenbr.apiclientes.model.repository.ServicoPrestadoRepository;
import io.github.jonfallenbr.apiclientes.rest.dto.ServicoPrestadoDTO;
import io.github.jonfallenbr.apiclientes.util.BigDecimaConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@RequestMapping("/api/servicos-prestados")
@RequiredArgsConstructor
public class ServicoPrestadoController {


    private final ClienteRepository clienteRepository;
    private final ServicoPrestadoRepository servicoPrestadoRepository;
    private final BigDecimaConverter bigDecimaConverter;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ServicoPrestado salvar(@RequestBody ServicoPrestadoDTO dto){

        LocalDate data = LocalDate.parse(dto.getData(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));

        Integer idCliente = dto.getIdCliente();

        Cliente cliente = clienteRepository.findById(idCliente)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Cliente inexistente"));

        ServicoPrestado servicoPrestado = new ServicoPrestado();
        servicoPrestado.setDescricao(dto.getDescricao());
        servicoPrestado.setData(data);
        servicoPrestado.setCliente(cliente);

        BigDecimal preco = bigDecimaConverter.converter(dto.getPreco());
        servicoPrestado.setValor(preco);

        return servicoPrestadoRepository.save(servicoPrestado);
    }


    @GetMapping
    public List<ServicoPrestado> pesquisar(
            @RequestParam(value = "nome", required = false, defaultValue = "") String nome,
            @RequestParam(value = "mes", required = false) Integer mes
    ) {
        return servicoPrestadoRepository.findByNomeClienteAndMes(nome, mes);
    }

}








/*
 Anotação do RequiredArgsConstructor serve para realizar a injeção de dependencia dos dois Repositorys obrigatorios que estão como final, é uma alternativa de
 Clean code para não ter que inserir um constructor instanciando ambos com this., como é de costume.


 Optional verifica se existe ou não a entidadeCliente dentro do repository. Para essa verificação, pode ser feito atraves de uma condicional if, ou a seguinte abordagem da linha 40, onde
 ele pede um cliente dentro do Repository atraves de um parametro, caso ele não exista, lança uma expection ElseThrow.



 Outra Versão desse codigo anterior, criado com logs para identificar cada campo da Entidade sendo populado corretamente

@PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ServicoPrestado salvar(@RequestBody ServicoPrestadoDTO dto) {
        System.out.println("DTO Recebido: " + dto);

        // Verifica se a data recebida no DTO não é nula
        if (dto.getData() != null) {
            // Convertendo preço para BigDecimal
            BigDecimal preco = bigDecimaConverter.converter(dto.getPreco());
            // Convertendo data para LocalDate
            LocalDate data = LocalDate.parse(dto.getData(), DateTimeFormatter.ofPattern("dd-MM-yyyy"));
            System.out.println("Data recebida: " + data);
            // Convertendo LocalDate para LocalDateTime
            LocalDateTime dataCompleta = data.atStartOfDay();
            System.out.println("Data completa: " + dataCompleta);

            Integer idCliente = dto.getIdCliente();
            System.out.println("ID Cliente recebido: " + idCliente);

            // Verifica se o ID do cliente não é nulo
            if (idCliente != null) {
                Cliente cliente = clienteRepository.findById(idCliente)
                        .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Cliente inexistente"));
                System.out.println("Cliente recebido: " + cliente);

                ServicoPrestado servicoPrestado = new ServicoPrestado();
                servicoPrestado.setDescricao(dto.getDescricao());
                servicoPrestado.setData(data);
                servicoPrestado.setCliente(cliente);
                servicoPrestado.setValor(preco);

                return servicoPrestadoRepository.save(servicoPrestado);
            } else {
                throw new IllegalArgumentException("O ID do cliente não pode ser nulo");
            }
        } else {
            throw new IllegalArgumentException("A data não pode ser nula");
        }
    }
 */