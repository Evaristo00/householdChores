package com.project.userservice.service;


import com.project.userservice.dto.UserDto;
import com.project.userservice.entity.User;
import com.project.userservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

/*
    TODO:
     -corregir excepcion del metodo update y del delete
*/

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public List<User> getAll(){
        return userRepository.findAll();
    }

    public User getUserById(int id){
        return userRepository.findById(id).orElse(null);
    }

    public User save(UserDto userDto){
        User user = new User(null,userDto.getName(),userDto.getMail(),userDto.getPhone());
        return userRepository.save(user);
    }

    public User update(int id, UserDto userDto) throws Exception {
        if(userRepository.findById(id).isEmpty())
            throw  new Exception();
        User user = userRepository.findById(id).get();
        user.setName(userDto.getName());
        user.setMail(userDto.getMail());
        user.setPhone(userDto.getPhone());

        return userRepository.save(user);
    }

    public User delete(int id) throws Exception {
        if(userRepository.findById(id).isEmpty())
            throw  new Exception();
        User user = userRepository.findById(id).get();
        userRepository.delete(user);
        return user;
    }

}
