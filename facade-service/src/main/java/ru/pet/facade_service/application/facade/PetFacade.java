package ru.pet.facade_service.application.facade;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.pet.facade_service.application.dto.pet.PetCreateRequest;
import ru.pet.facade_service.application.dto.pet.PetResponse;
import ru.pet.facade_service.application.feign.pet.client.PetFeign;
import ru.pet.facade_service.application.feign.pet.dto.PetFeignCreateRequest;
import ru.pet.facade_service.application.feign.pet.dto.PetFeignResponse;
import ru.pet.facade_service.application.mapper.PetMapper;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PetFacade {

    private final PetFeign petFeign;

    public PetResponse getPetById(UUID id) {
        PetFeignResponse petById = petFeign.getPetById(id);

        return PetMapper.INSTANCE.toPetResponse(petById);
    }

    public List<PetResponse> getPetByUserId(UUID userId) {
        List<PetFeignResponse> pets = petFeign.getPetByUserId(userId);
        return pets.stream()
                .map(PetMapper.INSTANCE::toPetResponse)
                .collect(Collectors.toList());
    }

    public PetResponse createPet(UUID userId, PetCreateRequest request) {

        PetFeignCreateRequest feignCreateRequest = PetMapper.INSTANCE.toCreatePetRequest(request);
        PetFeignResponse feignResponse = petFeign.createPet(userId, feignCreateRequest);

        return PetMapper.INSTANCE.toPetResponse(feignResponse);
    }
}
