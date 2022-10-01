package com.example.Magaz.controller;

import com.example.Magaz.entities.Magazine;
import com.example.Magaz.reposotories.MagazineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.rmi.ServerException;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("magazine")
public class MagazineController {
    @Autowired
    private MagazineRepository magazineRepository;

    @GetMapping
    public List<Magazine> getMagazine() {
        return magazineRepository.findAll();
    }

    @GetMapping("{id}")
    public ResponseEntity<Magazine> getById(@PathVariable UUID id) {
        try {
            Magazine magazine = magazineRepository.findById(id).get();
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(magazineRepository.findById(id).get(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Magazine> postMagazine(@RequestBody Magazine jsonMagazine) {
        return new ResponseEntity<>(magazineRepository.save(jsonMagazine), HttpStatus.CREATED);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Magazine> deleteMagazine(@PathVariable UUID id) {
        Magazine deleteMagazine;
        try {
            deleteMagazine = magazineRepository.findById(id).get();
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        magazineRepository.delete(deleteMagazine);
        return new ResponseEntity<>(deleteMagazine, HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<Magazine> putMagazine(@PathVariable UUID id, @RequestBody Magazine putJson){
        try {
            magazineRepository.findById(id).get();
        }
        catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

        putJson.setId(id);
        return new ResponseEntity<>(magazineRepository.save(putJson), HttpStatus.OK);

    }

    @PatchMapping("{id}")
    public ResponseEntity<Magazine> patchNameMagazine(@PathVariable UUID id, @RequestBody Magazine putJson){
        Magazine patchMagazine;
        try {
            patchMagazine = magazineRepository.findById(id).get();
        }
        catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

        patchMagazine.setNameMagazine(putJson.getNameMagazine());
        return new ResponseEntity<>(magazineRepository.save(putJson), HttpStatus.OK);

    }

}
