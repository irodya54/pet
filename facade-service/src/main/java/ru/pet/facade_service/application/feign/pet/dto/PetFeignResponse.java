package ru.pet.facade_service.application.feign.pet.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

public record PetFeignResponse(

        UUID id,
        String name,
        LocalDateTime dateCreate,
        LocalDate birthDate,
        String breed
) {
}
