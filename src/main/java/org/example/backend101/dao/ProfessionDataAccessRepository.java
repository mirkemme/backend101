package org.example.backend101.dao;

import org.example.backend101.model.Profession;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("mysql-profession")
public interface ProfessionDataAccessRepository extends JpaRepository<Profession, Integer> {

}
