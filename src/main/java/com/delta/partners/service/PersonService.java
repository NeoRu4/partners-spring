package com.delta.partners.service;

import com.delta.partners.domain.entity.Person;
import com.delta.partners.domain.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;


@Service
public class PersonService {

    private final PersonRepository personRepository;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Transactional(readOnly = true)
    public Iterable<Person> findAll() {
        return personRepository.findAll();
    }

    @Transactional
    public Person addPerson(Person person) {

        var newPerson = Person.builder()
                .firstName(person.getFirstName())
                .surName(person.getSurName())
                .middleName(person.getMiddleName())
                .displayName(person.getDisplayName())
                .birthDate(person.getBirthDate())
                .tin(person.getTin())
                .passportNumber(person.getPassportNumber())
                .passportDate(person.getPassportDate())
                .passportIssuer(person.getPassportIssuer())
                .refFiasAoguid(person.getRefFiasAoguid())
                .gender(person.getGender())
                .comments(person.getComments())
                .entryDate(LocalDate.now())
                .deleted(person.getDeleted())
                .dateDelete(person.getDateDelete())
                .lastUpdate(LocalDate.now()).build();

        personRepository.save(newPerson);

        return newPerson;
    }

}
