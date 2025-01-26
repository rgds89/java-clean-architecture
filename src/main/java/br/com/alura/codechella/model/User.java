package br.com.alura.codechella.model;


import br.com.alura.codechella.model.dto.UserDto;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;

@Entity
@Table(name = "users")
@Data
@ToString
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String social_identification;
    private String name;
    private LocalDate birth_date;
    private String mail;

    public User(UserDto user) {
        this.social_identification = user.social_identification();
        this.name = user.name();
        this.birth_date = user.birth_date();
        this.mail = user.mail();
    }

}
