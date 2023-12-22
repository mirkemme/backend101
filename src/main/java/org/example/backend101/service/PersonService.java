package org.example.backend101.service;

import org.example.backend101.dao.PersonDataAccessRepository;
import org.example.backend101.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PersonService {
    private final PersonDataAccessRepository personDataAccessRepository;

    @Autowired
    public PersonService(@Qualifier("mysql") PersonDataAccessRepository personDataAccessRepository) {
        this.personDataAccessRepository = personDataAccessRepository;
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

    /*public int addPerson(Person person) {
        return personDao.addPerson(person);
    }

    public int  deletePerson(UUID id) {
        return personDao.deletePersonById(id);
    }

    public int updatePerson(UUID id, Person newPerson) {
        return personDao.updatePersonById(id, newPerson);
    }*/
}
