package org.example.backend101.service;

import jakarta.persistence.EntityNotFoundException;
import org.example.backend101.dao.ProfessionDataAccessRepository;
import org.example.backend101.model.Profession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("profession-service")
public class ProfessionService {
    private final ProfessionDataAccessRepository professionDataAccessRepository;

    @Autowired
    public ProfessionService(@Qualifier("mysql-profession")
                             ProfessionDataAccessRepository professionDataAccessRepository) {
        this.professionDataAccessRepository = professionDataAccessRepository;
    }

    public Profession getProfessionById(Integer id) {
        return professionDataAccessRepository.findById(id).orElse(null);
    }

    public Profession addProfession(Profession profession) {
        return professionDataAccessRepository.save(profession);
    }

    public void deleteProfessionById(Integer id) {
        professionDataAccessRepository.deleteById(id);
    }

    public void updateProfession(Integer id, Profession newProfession) {
        Profession updateProfession = professionDataAccessRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Profession not exist with id: " + id));
        updateProfession.setProfession(newProfession.getProfession());

        professionDataAccessRepository.save(updateProfession);
    }
}