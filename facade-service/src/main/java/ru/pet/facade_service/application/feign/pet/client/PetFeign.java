package ru.pet.facade_service.application.feign.pet.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.pet.facade_service.application.feign.pet.dto.PetFeignCreateRequest;
import ru.pet.facade_service.application.feign.pet.dto.PetFeignResponse;

import java.util.List;
import java.util.UUID;

@FeignClient(name = "feign")
public interface PetFeign {

    @RequestMapping(method = RequestMethod.GET, value = "/pets/{id}")
    PetFeignResponse getPetById(@PathVariable("id") UUID id);

    @RequestMapping(method = RequestMethod.GET, value = "/pets/{userId}")
    List<PetFeignResponse> getPetByUserId(@PathVariable("userId") UUID userId);

    @RequestMapping(method = RequestMethod.POST, value = "/pets/{userId}", consumes = "application/json")
    PetFeignResponse createPet(@PathVariable("userId") UUID userId, PetFeignCreateRequest request);
}
