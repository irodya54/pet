package ru.pet.facade_service.application.dto.pet;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

public record PetResponse (
        UUID id,
        String name,
        LocalDateTime dateCreate,
        LocalDate birthDate,
        String breed
){
}
