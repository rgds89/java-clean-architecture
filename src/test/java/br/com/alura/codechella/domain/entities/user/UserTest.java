package br.com.alura.codechella.domain.entities.user;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class UserTest {
    private UserFactory userFactory;

    @Test
    public void shouldNotCreateUserWithInvalidSocialIdentification() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new User("123456.789-00", "Teste", LocalDate.parse("1989-09-12"), "roger.silva@email.com"));

        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new User(null, "Teste", LocalDate.parse("1989-09-12"), "roger.silva@email.com"));

        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new User("", "Teste", LocalDate.parse("1989-09-12"), "roger.silva@email.com"));
    }

    @Test
    public void createUserWithSocialIdentificationAndNameAndBirthDay() {
        userFactory = new UserFactory();
        User user = userFactory.createUserWithSocialIdentificationAndNameAndBirthDay("123.456.789-00", "Teste", LocalDate.parse("1989-09-12"));
        Assertions.assertEquals("123.456.789-00", user.getSocial_identification());
        Assertions.assertEquals("Teste", user.getName());
        Assertions.assertEquals(LocalDate.parse("1989-09-12"), user.getBirth_date());
    }

    @Test
    public void addUserAddress() {
        userFactory = new UserFactory();
        User user = userFactory.createUserWithSocialIdentificationAndNameAndBirthDay("123.456.789-00", "Teste", LocalDate.parse("1989-09-12"));
        user = userFactory.addUserAddress("Rua Teste", 123, "Complemento", "Bairro Teste", "12345-678", "Cidade Teste");
        Assertions.assertEquals("Rua Teste", user.getAddress().getStreet());
        Assertions.assertEquals(123, user.getAddress().getNumber());
        Assertions.assertEquals("Complemento", user.getAddress().getComplement());
        Assertions.assertEquals("Bairro Teste", user.getAddress().getNeighborhood());
        Assertions.assertEquals("12345-678", user.getAddress().getZipCode());
        Assertions.assertEquals("Cidade Teste", user.getAddress().getCity());
    }
}
