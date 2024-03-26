package io.github.jonfallenbr.apiclientes.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

import java.util.Locale;

@Configuration
public class internacionalizacaoConfig {

    @Bean
    public MessageSource messageSource(){
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setBasename("classpath:messages"); // o arquivo messages.properties
        messageSource.setDefaultEncoding("ISO-8859-1"); // Identifica acentuação da mensagem, no caso esse ISO identifica os Caracteres Brasileiros padrões
        messageSource.setDefaultLocale(Locale.getDefault() ); // detecta a localização da aplicação atraves do Sistema Operacional
        return messageSource;
    }


    @Bean
    public LocalValidatorFactoryBean localValidatorFactoryBean(){
        LocalValidatorFactoryBean bean = new LocalValidatorFactoryBean();
        bean.setValidationMessageSource(messageSource());
        return bean;

    }

}

/*
Classe de implementação onde instancia uma mensagem padrão para o usuario a partir de uma chave criada no arquivo message.properties.
 */