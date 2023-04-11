package com.homeservice.service;

import com.homeservice.dto.HomeDto;
import com.homeservice.dto.PersonDto;
import com.homeservice.entity.Home;
import com.homeservice.feingClient.PersonFeingClient;
import com.homeservice.repository.HomeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HomeService {

    @Autowired
    HomeRepository homeRepository;

    @Autowired
    PersonFeingClient personFeingClient;

    public List<Home> getAll(){
        return homeRepository.findAll();
    }

    public Home getHomeById(int id){
        return homeRepository.findById(id).orElse(null);
    }

    public Home save(HomeDto homeDto){
        Home home = new Home(null, homeDto.getDescription(), homeDto.getDirection());
        return homeRepository.save(home);
    }

    public Home update(int id, HomeDto homeDto) throws Exception {
        if(homeRepository.findById(id).isEmpty())
            throw  new Exception();
        Home home = homeRepository.findById(id).get();
        home.setDescription(homeDto.getDescription());
        home.setDirection(homeDto.getDirection());

        return homeRepository.save(home);
    }

    public Home delete(int id) throws Exception {
        if(homeRepository.findById(id).isEmpty())
            throw  new Exception();
        Home home = homeRepository.findById(id).get();
        homeRepository.delete(home);
        return home;
    }

    /*
    *
    * PERSON SERVICE
    *
    * */

    public List<PersonDto> getAllPersons(int id){
        return (personFeingClient.getPersonsInHose(id));
    }
}
