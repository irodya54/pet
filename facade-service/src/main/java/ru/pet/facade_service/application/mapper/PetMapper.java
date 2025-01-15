package ru.pet.facade_service.application.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import ru.pet.facade_service.application.dto.pet.PetCreateRequest;
import ru.pet.facade_service.application.dto.pet.PetResponse;
import ru.pet.facade_service.application.feign.pet.dto.PetFeignCreateRequest;
import ru.pet.facade_service.application.feign.pet.dto.PetFeignResponse;

@Mapper
public interface PetMapper {

    PetMapper INSTANCE = Mappers.getMapper(PetMapper.class);

    PetResponse toPetResponse(PetFeignResponse response);

    PetFeignCreateRequest toCreatePetRequest(PetCreateRequest request);

}
