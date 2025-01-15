package ru.pet.facade_service.presentation;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import ru.pet.facade_service.application.dto.pet.PetCreateRequest;
import ru.pet.facade_service.application.dto.pet.PetResponse;
import ru.pet.facade_service.application.facade.PetFacade;

import java.util.List;
import java.util.UUID;

@RestController("pets")
@RequiredArgsConstructor
public class PetController {

    private final PetFacade petFacade;

    @GetMapping("/pets/{id}")
    public PetResponse getPetById(@PathVariable("id") UUID id) {
        return petFacade.getPetById(id);
    }

    @GetMapping("/pets/{userId}")
    public List<PetResponse> getPetByUserId(@PathVariable("userId") UUID userId) {
        return petFacade.getPetByUserId(userId);
    }

    @GetMapping("/pets/{userId}")
    public PetResponse createPet(@PathVariable("userId") UUID userId, PetCreateRequest request) {
        return petFacade.createPet(userId, request);
    }
}
