package br.com.alura.codechella.domain.entities.user;

import br.com.alura.codechella.domain.Address;

import java.time.LocalDate;

public class UserFactory {
    private User user;

    User createUserWithSocialIdentificationAndNameAndBirthDay(String socialIdentification, String name, LocalDate birthDay) {
        this.user = new User(socialIdentification, name, birthDay, null);
        return this.user;
    }

    User addUserAddress(String street, Integer number, String complement, String neighborhood, String zipCode, String city) {
        Address address = new Address(street, number, complement, neighborhood, zipCode, city);
        this.user.setAddress(address);
        return this.user;
    }
}
