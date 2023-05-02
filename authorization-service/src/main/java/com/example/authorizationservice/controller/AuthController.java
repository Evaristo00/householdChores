package com.example.authorizationservice.controller;

import com.example.authorizationservice.dto.AppUserDto;
import com.example.authorizationservice.dto.MessageDto;
import com.example.authorizationservice.service.AppUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AppUserService appUserService;

    @PostMapping("/create")
    public ResponseEntity<MessageDto> createUser(@RequestBody AppUserDto dto){
        return ResponseEntity.status(HttpStatus.CREATED).body(appUserService.createUser(dto));
    }
}
