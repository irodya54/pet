package ru.pet.facade_service.application.feign.pet.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record PetFeignCreateRequest(
        String name,
        LocalDateTime dateCreate,
        LocalDate birthDate,
        String breed
) {
}
