package org.example.backend101.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.util.UUID;

@Entity
@Table (name = "clients")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
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
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "profession_id")
    private Profession profession;

    public Person(@JsonProperty("id") UUID id,
                  @JsonProperty("name") String name,
                  @JsonProperty("surname") String surname) {
        this.id = id;
        this.name = name;
        this.surname = surname;
    }

    public Person() {
        this.id = null;
        this.name = null;
        this.surname = null;
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

    public Profession getProfession() {
        return profession;
    }

    public void setProfession(Profession profession) {
        this.profession = profession;
    }
}
