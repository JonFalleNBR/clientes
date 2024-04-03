package io.github.jonfallenbr.apiclientes.util;


import org.springframework.stereotype.Component;

import java.math.BigDecimal;


@Component
public class BigDecimaConverter {

    public BigDecimal converter(String value) {
        if (value == null) {
            return null;
        }

        // Substitua vírgulas por pontos para garantir que o formato seja reconhecido corretamente
        value = value.replace(",", ".");
        // Parse para BigDecimal
        return new BigDecimal(value);
    }

    public String formatar(BigDecimal valor) {
        if (valor == null) {
            return null;
        }

        // Formata o BigDecimal com duas casas decimais e retorna como string
        return String.format("%.2f", valor);
    }
}
