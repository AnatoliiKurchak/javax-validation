package com.levi.demo.config;

import javax.validation.Validation;
import javax.validation.Validator;
import org.hibernate.validator.HibernateValidator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ValidatorConfig {

    @Bean
    public Validator validator() {
        return Validation.byProvider(HibernateValidator.class)
            .configure()
            .allowOverridingMethodAlterParameterConstraint(true)
            .buildValidatorFactory()
            .getValidator();
    }
}
