package io.github.thiagogcm.javafxstarter.service;

import io.github.thiagogcm.javafxstarter.model.Person;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Service;

@Service
public class PersonService {
    private static final Logger logger = LoggerFactory.getLogger(PersonService.class);

    public PersonService() {
        logger.info("Initializing Person Service");

    }

    public Person getPerson() {
        return new Person("Thiago", 26);
    }
}
