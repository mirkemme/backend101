package org.example.backend101.service;

import org.example.backend101.api.BadRequestException;
import org.example.backend101.api.NoContentException;
import org.example.backend101.dao.PersonDataAccessRepository;
import org.example.backend101.dao.ProfessionDataAccessRepository;
import org.example.backend101.model.Person;
import org.example.backend101.model.Profession;
import org.example.backend101.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.StringJoiner;
import java.util.UUID;

@Service("person-service")
public class PersonService {
    private final PersonDataAccessRepository personDataAccessRepository;
    private final ProfessionDataAccessRepository professionDataAccessRepository;

    @Autowired
    public PersonService(@Qualifier("mysql-person")
                         PersonDataAccessRepository personDataAccessRepository,
                         @Qualifier("mysql-profession")
                         ProfessionDataAccessRepository professionDataAccessRepository) {
        this.personDataAccessRepository = personDataAccessRepository;
        this.professionDataAccessRepository = professionDataAccessRepository;
    }

    public List<Person> getAllPeople() {
        return personDataAccessRepository.findAll();
    }

    public Person getPersonById(UUID id) {
        return personDataAccessRepository.findById(id).orElse(null);
    }

    public Optional<Person> getPersonByName(String name) {
        return personDataAccessRepository.findByName(name);
    }
    public Optional<Person> getPersonByNameAndSurname(String name, String surname) {
        return personDataAccessRepository.findByNameAndSurname(name, surname);
    }

    public String getProfessionByNameAndSurname(String name, String surname) {
        return personDataAccessRepository.findByNameAndSurname(name, surname).get().getProfession().getProfession();
    }

    public Person addPerson(Person person) {
        Integer id = person.getProfession().getId();
        Profession profession = professionDataAccessRepository.findById(id).orElse(null);
        person.setProfession(profession);
        return personDataAccessRepository.save(person);
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
        try {
            if (StringUtils.isAlphanumeric(character)) {
                List<Person> people = personDataAccessRepository.findByNameStartingWith(character);
                StringJoiner stringJoiner = new StringJoiner(", ");
                if (!people.isEmpty())
                    for (Person person : people) {
                        stringJoiner.add(person.getName());
                    }
                else
                    throw new NoContentException();
                String allNames = stringJoiner.toString();

                return allNames;
            } else
                throw new BadRequestException();
        }
        catch (NoContentException exception) {
            throw new ResponseStatusException(
                    HttpStatus.NO_CONTENT, "No content", exception);
        }
        catch (BadRequestException exception) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "Invalid input", exception);
        }
    }

}
