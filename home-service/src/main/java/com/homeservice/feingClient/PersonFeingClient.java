package com.homeservice.feingClient;

import com.homeservice.dto.PersonDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "person-service", url = "http://localhost:8000/person")
public interface PersonFeingClient {

    @GetMapping("house/{id}")
    List<PersonDto> getPersonsInHose(@PathVariable("id") Integer id);
}