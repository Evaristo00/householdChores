package com.homeservice.controller;

import com.homeservice.dto.HomeDto;
import com.homeservice.dto.PersonDto;
import com.homeservice.entity.Home;
import com.homeservice.service.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/home")
public class HomeController {
    @Autowired
    HomeService homeService;

    @GetMapping
    public ResponseEntity<List<Home>> getAll(){
        List<Home> homes = homeService.getAll();
        if(homes.isEmpty())
            return ResponseEntity.noContent().build();
        return ResponseEntity.ok(homes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Home> getById(@PathVariable int id){
        Home home = homeService.getHomeById(id);
        if(home == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(home)  ;
    }

    @PostMapping
    public ResponseEntity<Home> save(@RequestBody HomeDto homeDto){
        return ResponseEntity.ok(homeService.save(homeDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Home> upload(@PathVariable("id") int id,@RequestBody HomeDto homeDto) throws Exception {
        return ResponseEntity.ok(homeService.update(id,homeDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Home> delete(@PathVariable("id") int id) throws Exception {
        return ResponseEntity.ok(homeService.delete(id));
    }

    /*
     *
     * PERSON CONTROLLER
     *
     * */

    @GetMapping("person/{id}")
    public ResponseEntity<List<PersonDto>> getAllPersons(@PathVariable("id") Integer id){
        List<PersonDto> persons = homeService.getAllPersons(id);
        if(persons == null)
            return ResponseEntity.noContent().build();
        return ResponseEntity.ok(persons);
    }
}
