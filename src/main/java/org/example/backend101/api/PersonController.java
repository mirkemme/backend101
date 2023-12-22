package org.example.backend101.api;

import org.example.backend101.model.Person;
import org.example.backend101.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequestMapping("api/v1/person")
@RestController
public class PersonController {
    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping(path = "/all")
    public @ResponseBody List<Person> getAllPeople() {
        return personService.getAllPeople();
    }

    @GetMapping(path = "{id}")
    public @ResponseBody Person getPersonById(@PathVariable("id") UUID id) {
        return personService.getPersonById(id);
    }
    @GetMapping("/search/name")
    public @ResponseBody Optional<Person> getPersonByName(@RequestParam String name) {
        return personService.getPersonByName(name);
    }

    @GetMapping("/search/name-and-surname")
    public @ResponseBody Optional<Person> getPersonByNameAndSurname(@RequestParam String name, @RequestParam String surname) {
        return personService.getPersonByNameAndSurname(name, surname);
    }

    @GetMapping("/search/profession-by-name-and-surname")
    public String getProfessionByNameAndSurname(@RequestParam String name, @RequestParam String surname) {
        return personService.getProfessionByNameAndSurname(name, surname);
    }

    /*@PostMapping
    public void addPerson(@Valid @NonNull @RequestBody Person person) {
        personService.addPerson(person);
    }

    @DeleteMapping(path = "{id}")
    public void deletePersonById(@PathVariable("id") UUID id){
        personService.deletePerson(id);
    }

    @PutMapping(path = "{id}")
    public void updatePerson(@PathVariable("id") UUID id, @Valid @NonNull @RequestBody Person personToUpdate) {
        personService.updatePerson(id, personToUpdate);
    }*/
}
