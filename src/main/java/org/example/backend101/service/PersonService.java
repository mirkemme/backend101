package org.example.backend101.service;

import org.example.backend101.exception.InvalidInputException;
import org.example.backend101.exception.NoContentException;
import org.example.backend101.dao.PersonRepository;
import org.example.backend101.dao.ProfessionRepository;
import org.example.backend101.model.Person;
import org.example.backend101.model.Profession;
import org.example.backend101.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.StringJoiner;
import java.util.UUID;

@Service("person-service")
public class PersonService {
    private final PersonRepository personRepository;
    private final ProfessionRepository professionRepository;

    @Autowired
    public PersonService(@Qualifier("mysql-person")
                             PersonRepository personRepository,
                         @Qualifier("mysql-profession")
                         ProfessionRepository professionRepository) {
        this.personRepository = personRepository;
        this.professionRepository = professionRepository;
    }

    public List<Person> getAllPeople() {
        return personRepository.findAll();
    }

    public Person getPersonById(UUID id) {
        return personRepository.findById(id).orElse(null);
    }

    public Optional<Person> getPersonByName(String name) {
        return personRepository.findByName(name);
    }
    public Optional<Person> getPersonByNameAndSurname(String name, String surname) {
        return personRepository.findByNameAndSurname(name, surname);
    }

    public String getProfessionByNameAndSurname(String name, String surname) {
        return personRepository.findByNameAndSurname(name, surname).get().getProfession().getProfession();
    }

    public Person addPerson(Person person) {
        Integer id = person.getProfession().getId();
        Profession profession = professionRepository.findById(id).orElse(null);
        person.setProfession(profession);
        return personRepository.save(person);
    }

    /**/
    /*public String getNamesByChar(Character character) {
            if (StringUtils.isAlphanumeric(character)) {
                List<Person> people = personDataAccessRepository.findByNameStartingWith(character);
                StringJoiner stringJoiner = new StringJoiner(", ");
                if (!people.isEmpty())
                    for (Person person : people) {
                        stringJoiner.add(person.getName());
                    }
                else
                    return "Resource not found";
                String allNames = stringJoiner.toString();

                return allNames;
            } else
                return "Invalid input";
    }*/
    public String getNamesByChar(Character character) {
            if (StringUtils.isAlphanumeric(character)) {
                List<Person> people = personRepository.findByNameStartingWith(character);
                StringJoiner stringJoiner = new StringJoiner(", ");
                if (!people.isEmpty())
                    for (Person person : people) {
                        stringJoiner.add(person.getName());
                    }
                else throw new NoContentException("No Content");
                String allNames = stringJoiner.toString();

                return allNames;
            } else throw new InvalidInputException("Invalid input");
        }
}
