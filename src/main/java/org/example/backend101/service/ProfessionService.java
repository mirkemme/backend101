package org.example.backend101.service;

import org.example.backend101.dao.ProfessionDataAccessRepository;
import org.example.backend101.model.Profession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
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
}
