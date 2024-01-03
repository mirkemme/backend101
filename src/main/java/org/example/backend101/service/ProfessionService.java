package org.example.backend101.service;

import jakarta.persistence.EntityNotFoundException;
import org.example.backend101.dao.ProfessionRepository;
import org.example.backend101.model.Profession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("profession-service")
public class ProfessionService {
    private final ProfessionRepository professionRepository;

    @Autowired
    public ProfessionService(@Qualifier("mysql-profession")
                             ProfessionRepository professionRepository) {
        this.professionRepository = professionRepository;
    }

    public Profession getProfessionById(Integer id) {
        return professionRepository.findById(id).orElse(null);
    }

    public Profession addProfession(Profession profession) {
        return professionRepository.save(profession);
    }

    public void deleteProfessionById(Integer id) {
        professionRepository.deleteById(id);
    }

    public void updateProfession(Integer id, Profession newProfession) {
        Profession updateProfession = professionRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Profession not exist with id: " + id));
        updateProfession.setProfession(newProfession.getProfession());

        professionRepository.save(updateProfession);
    }
}