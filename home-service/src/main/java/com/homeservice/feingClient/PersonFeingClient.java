package com.homeservice.feingClient;

import com.homeservice.dto.PersonDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "person-service", url = "http://localhost:8000")
public interface PersonFeingClient {

    @GetMapping()
    List<PersonDto> getPersonsInHose();
}
