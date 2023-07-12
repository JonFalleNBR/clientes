package io.github.jonfallenbr.apiclientes;


import io.github.jonfallenbr.apiclientes.model.entity.Cliente;
import io.github.jonfallenbr.apiclientes.model.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ClientesApplication {

    @Bean
    public CommandLineRunner run(@Autowired ClienteRepository repository){
        return args -> {
            Cliente cliente = Cliente.builder().cpf("00000000000").nome("Fulano").build();
            repository.save(cliente); // Comando para Salvar o cliente no Banco de Dados
        };
    }

    public static void main(String[] args) {

        SpringApplication.run(ClientesApplication.class, args);
    }
}
