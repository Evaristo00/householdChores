package com.choreservice.service;

import com.choreservice.dto.ChoreDto;
import com.choreservice.entity.Chore;
import com.choreservice.repository.ChoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChoreService {

    @Autowired
    ChoreRepository choreRepository;

    public List<Chore> getAll(){
        return choreRepository.findAll();
    }

    public Chore getChoreById(int id){
        return choreRepository.findById(id).orElse(null);
    }

    public Chore save(ChoreDto choreDto){
        Chore chore = new Chore(null, choreDto.getPoint(), choreDto.getDone(),choreDto.getUserId(),choreDto.getHomeId());
        return choreRepository.save(chore);
    }

    public Chore update(int id, ChoreDto choreDto) throws Exception {
        if(choreRepository.findById(id).isEmpty())
            throw  new Exception();
        Chore chore = choreRepository.findById(id).get();
        chore.setPoint(choreDto.getPoint());
        chore.setDone(choreDto.getDone());
        chore.setHomeId(choreDto.getHomeId());
        chore.setUserId(choreDto.getUserId());

        return choreRepository.save(chore);
    }

    public Chore delete(int id) throws Exception {
        if(choreRepository.findById(id).isEmpty())
            throw  new Exception();
        Chore chore = choreRepository.findById(id).get();
        choreRepository.delete(chore);
        return chore;
    }
}
