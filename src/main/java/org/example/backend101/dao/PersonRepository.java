package org.example.backend101.dao;

import org.example.backend101.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("mysql-person")
public interface PersonRepository extends JpaRepository<Person, UUID> {
    Optional<Person> findByName(String name);
    Optional<Person> findByNameAndSurname(String name, String surname);
    List<Person> findByNameStartingWith(Character character);
}
