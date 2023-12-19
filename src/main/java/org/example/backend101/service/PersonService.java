package org.example.backend101.service;

import org.example.backend101.dao.PersonDataAccessRepository;
import org.example.backend101.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

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

    /*public Optional<Person> getPersonById(UUID id) {
        return personDao.selectPersonById(id);
    }

    public int addPerson(Person person) {
        return personDao.addPerson(person);
    }

    public int  deletePerson(UUID id) {
        return personDao.deletePersonById(id);
    }

    public int updatePerson(UUID id, Person newPerson) {
        return personDao.updatePersonById(id, newPerson);
    }*/
}