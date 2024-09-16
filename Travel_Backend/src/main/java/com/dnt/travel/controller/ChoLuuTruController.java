/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dnt.travel.controller;

import com.dnt.travel.models.ChoLuuTru;
import com.dnt.travel.models.KhuVuc;
import com.dnt.travel.service.ChoLuuTruService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author DikamonTu
 */
@RestController
@RequestMapping("/api/travel/choluutru")
public class ChoLuuTruController {
    @Autowired
    private ChoLuuTruService choLuuTruService;
    
    @GetMapping("")
    public ResponseEntity<List<ChoLuuTru>> getChoLuuTru(@RequestParam("idkhuvuc") KhuVuc idKhuVuc
            ,@RequestParam("loai") String loai){
        return new ResponseEntity<>(this.choLuuTruService.getChoLuuTru(idKhuVuc, loai), HttpStatus.OK);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<ChoLuuTru> getChoLuuTruById(@PathVariable("id") int id){
        return new ResponseEntity<>(this.choLuuTruService.getChoLuuTruById(id), HttpStatus.OK);
    }
    
    @PostMapping("")
    public ResponseEntity<ChoLuuTru> postChoLuuTru(@RequestBody ChoLuuTru clt){
        return new ResponseEntity<>(this.choLuuTruService.saveChoLuuTru(clt), HttpStatus.CREATED);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<ChoLuuTru> putChoLuuTru(@PathVariable int id, @RequestBody ChoLuuTru clt) {
        return new ResponseEntity<>(this.choLuuTruService.updateChoLuuTru(id, clt), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ChoLuuTru> deleteChoLuuTru(@PathVariable int id){
        if (this.choLuuTruService.getChoLuuTruById(id) != null) {
            this.choLuuTruService.deleteChoLuuTru(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
