package org.example.backend101.dao;

import org.example.backend101.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository("mysql")
public interface PersonDataAccessRepository extends JpaRepository<Person, UUID> {

}
