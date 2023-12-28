package org.example.backend101.api;

import jakarta.validation.Valid;
import org.example.backend101.model.Profession;
import org.example.backend101.service.ProfessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

@RequestMapping("api/v1/profession")
@RestController
public class ProfessionController {
    private final ProfessionService professionService;

    @Autowired
    public ProfessionController(ProfessionService professionService) {
        this.professionService = professionService;
    }

    @PostMapping(value = "/new-profession", consumes = "application/json", produces = "application/json")
    public Profession addProfession(@Valid @NonNull @RequestBody Profession profession) {
        return professionService.addProfession(profession);
    }

    @DeleteMapping(path = "{id}")
    public void deleteProfessionById(@PathVariable("id") Integer id) {
        professionService.deleteProfessionById(id);
    }

    @PutMapping(path = "{id}")
    public void updateProfession(@PathVariable("id") Integer id,
                                 @Valid @NonNull @RequestBody Profession professionToUpdate) {
        professionService.updateProfession(id, professionToUpdate);
    }
}
