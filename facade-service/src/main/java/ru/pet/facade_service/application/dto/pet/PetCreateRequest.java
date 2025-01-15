package ru.pet.facade_service.application.dto.pet;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record PetCreateRequest(
        String name,
        LocalDateTime dateCreate,
        LocalDate birthDate,
        String breed
) {
}
