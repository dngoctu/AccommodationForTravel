/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dnt.travel.controller;

import com.dnt.travel.models.ChiTietDatCho;
import com.dnt.travel.models.TaiKhoan;
import com.dnt.travel.service.ChiTietDatChoService;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
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
@RequestMapping("/api/travel/chitietdatcho")
public class ChiTietDatChoController {
    @Autowired
    private ChiTietDatChoService chiTietDatChoService;
    
    @GetMapping("")
    public ResponseEntity<List<ChiTietDatCho>> getChiTietDatCho(@RequestParam (required = false) String ngayDat
            , @RequestParam (required = false) String email){      
        return new ResponseEntity<>(this.chiTietDatChoService.getChiTietDatCho(ngayDat, email)
                , HttpStatus.OK);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<ChiTietDatCho> getChiTietDatChoById(@PathVariable int id){
        return new ResponseEntity<>(this.chiTietDatChoService.getChiTietDatChoById(id), HttpStatus.OK);
    }
     
    @PostMapping("")
    public ResponseEntity<ChiTietDatCho> postChiTietDatCho(@RequestBody ChiTietDatCho ctdt){
        return new ResponseEntity<>(this.chiTietDatChoService.saveChiTietDatCho(ctdt), HttpStatus.CREATED);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<ChiTietDatCho> updateChiTietDatCho(@PathVariable int id
            , @RequestBody ChiTietDatCho ctdt){
        return new ResponseEntity<>(this.chiTietDatChoService.updateChiTietDatCho(id, ctdt), HttpStatus.OK);
    }
        
    @DeleteMapping("/{id}")
    public ResponseEntity<ChiTietDatCho> deleteChiTietDatCho(@PathVariable int id){
        if (this.chiTietDatChoService.getChiTietDatChoById(id) != null) {
            chiTietDatChoService.deleteChiTietDatCho(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
