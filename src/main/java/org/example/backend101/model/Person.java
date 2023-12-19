package org.example.backend101.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.util.UUID;

@Entity
@Table (name = "clients")
public class Person {
    @Id
    @GeneratedValue
    @Column (name = "id", columnDefinition = "BINARY(16)")
    private final UUID id;

    @Column (name = "name")
    @NotBlank
    private final String name;
    @Column (name = "surname")
    @NotBlank
    private final String surname;

    @Column (name = "profession_id")
    @NotBlank
    private final Integer profession_id;

    public Person(@JsonProperty("id") UUID id,
                  @JsonProperty("name") String name,
                  @JsonProperty("surname") String surname,
                  @JsonProperty("profession") Integer profession_id) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.profession_id = profession_id;
    }

    public Person() {
        this.id = null;
        this.name = null;
        this.surname = null;
        this.profession_id = null;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public Integer getProfession_id() {
        return profession_id;
    }
}
