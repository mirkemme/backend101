package org.example.backend101.dao;

import org.example.backend101.model.Person;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PersonDao {
    int insertPerson(UUID id, Person person);

    /*default int addPerson(Person person) {
        int id = UUID.randomUUID();
        return insertPerson(id, person);
    }*/

    List<Person> selectAllPeople();

    Optional<Person> selectPersonById(UUID id);
    int deletePersonById(UUID id);
    int updatePersonById(UUID id, Person person);
}