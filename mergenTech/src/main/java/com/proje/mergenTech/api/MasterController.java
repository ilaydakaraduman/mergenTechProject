package com.proje.mergenTech.api;
import com.proje.mergenTech.entity.Filtre;
import com.proje.mergenTech.entity.Master;

import com.proje.mergenTech.service.MasterService;
import lombok.RequiredArgsConstructor;

import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;
@RestController
@RequiredArgsConstructor
@RequestMapping("/Master")
public class MasterController {

    private final MasterService masterService;

//    @Bean
//    public WebMvcConfigurer configure(){
//        return new WebMvcConfigurer(){
//            //            @Override
//            public void addCorsMappings(CorsRegistry registry){
//                registry.addMapping("/*").allowedOrigins("http://localhost:4200");
//            }
//        };
//    }

    @PostMapping("/create") //ekleme
    // @RequestMapping( method = RequestMethod.POST)
    public ResponseEntity<Master> createMaster(@RequestBody Master master){
        Master resultMaster=masterService.createMaster(master);

        return ResponseEntity.ok(resultMaster);
    }
    @GetMapping("/getAll") //hepsini çekme
    @CrossOrigin(origins ="http://localhost:4200")
    public ResponseEntity<List<Master>> getMasters(){
        List<Master> resultMasters= masterService.getMasters();
        return ResponseEntity.ok(resultMasters);
    }
    @GetMapping("/getById/{id}") //aramaıd ye göre
    public  ResponseEntity<Master> getMaster(@PathVariable("id") Long id){
        Master master =masterService.getMaster(id);
        return  ResponseEntity.ok(master);
    }
    @PostMapping("/getAllF") //hepsini çekme
    @CrossOrigin(origins ="http://localhost:4200")
    public ResponseEntity<List<Master>> getMastersf(@RequestBody Filtre filtre){
        List<Master> resultMasters= masterService.getMastersf(filtre);
        return ResponseEntity.ok(resultMasters);
    }
//    @GetMapping("/exceptionOrnek")
//    @CrossOrigin(origins ="http://localhost:4200")
//    public Master exceptionOrnek(@RequestParam Filtre filtre) {
//        return masterService.exceptionOrnek( filtre);
//    }


}
