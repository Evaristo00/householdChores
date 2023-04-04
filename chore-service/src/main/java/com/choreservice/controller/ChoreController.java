package com.choreservice.controller;

import com.choreservice.dto.ChoreDto;
import com.choreservice.entity.Chore;
import com.choreservice.service.ChoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*
* TODO:
*   -agregar comprobacion de que houseId exista y lo mismo para user
* */


@RestController
@RequestMapping("/chore")
public class ChoreController {
    @Autowired
    ChoreService choreService;

    @GetMapping
    public ResponseEntity<List<Chore>> getAll(){
        List<Chore> chores = choreService.getAll();
        if(chores.isEmpty())
            return ResponseEntity.noContent().build();
        return ResponseEntity.ok(chores);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Chore> getById(@PathVariable int id){
        Chore chore = choreService.getChoreById(id);
        if(chore == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(chore)  ;
    }

    @PostMapping
    public ResponseEntity<Chore> save(@RequestBody ChoreDto choreDto){
        return ResponseEntity.ok(choreService.save(choreDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Chore> upload(@PathVariable("id") int id,@RequestBody ChoreDto choreDto) throws Exception {
        return ResponseEntity.ok(choreService.update(id,choreDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Chore> delete(@PathVariable("id") int id) throws Exception {
        return ResponseEntity.ok(choreService.delete(id));
    }
}
