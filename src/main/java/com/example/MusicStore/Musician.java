package com.example.MusicStore;

import javax.persistence.*;

@Entity
public class Musician {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String lastName;
    private String mainInstrument;

    public Musician(Long id, String firstName, String lastName, String mainInstrument) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.mainInstrument = mainInstrument;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMainInstrument() {
        return mainInstrument;
    }

    public void setMainInstrument(String mainInstrument) {
        this.mainInstrument = mainInstrument;
    }
}
