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

    public Person(@JsonProperty("id") UUID id,
                  @JsonProperty("name") String name) {
        this.id = id;
        this.name = name;
    }

    public Person() {
        id = null;
        name = null;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
