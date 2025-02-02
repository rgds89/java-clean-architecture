package br.com.alura.codechella.domain.entities.user;

import br.com.alura.codechella.domain.Address;

import java.time.LocalDate;

public class User {
    private Long id;
    private String social_identification;
    private String name;
    private LocalDate birth_date;
    private String mail;
    private Address address;

    public User(String social_identification, String name, LocalDate birth_date, String mail) {
        if (social_identification == null || social_identification.isBlank() || !social_identification.matches("\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}") || social_identification.isEmpty()) {
            throw new IllegalArgumentException("Identificação social inválida");
        }
        this.social_identification = social_identification;
        this.name = name;
        this.birth_date = birth_date;
        this.mail = mail;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSocial_identification() {
        return social_identification;
    }

    public void setSocial_identification(String social_identification) {
        this.social_identification = social_identification;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirth_date() {
        return birth_date;
    }

    public void setBirth_date(LocalDate birth_date) {
        this.birth_date = birth_date;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
