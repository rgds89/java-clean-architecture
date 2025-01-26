package br.com.alura.codechella.model.dto;

import lombok.Builder;

import java.time.LocalDate;

@Builder
public record UserDto(String social_identification, String name, LocalDate birth_date, String mail) {
}
