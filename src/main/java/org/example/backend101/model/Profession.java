package org.example.backend101.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.util.List;

@Entity
@Table (name = "professions")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Profession {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column (name = "id")
    private final Integer id;
    @Column (name = "profession")
    @NotBlank
    private final String profession;
    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "profession")
    private List<Person> people;

    public Profession(@JsonProperty("id") Integer id,
                      @JsonProperty("profession") String profession) {
        this.id = id;
        this.profession = profession;
    }

    public Profession() {
        this.id = null;
        this.profession = null;
    }

    public Integer getId() {
        return id;
    }

    public String getProfession() {
        return profession;
    }

    public List<Person> getPeople() {
        return people;
    }
}
