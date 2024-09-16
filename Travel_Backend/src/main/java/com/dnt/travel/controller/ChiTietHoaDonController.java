/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dnt.travel.controller;

import com.dnt.travel.models.ChiTietHoaDon;
import com.dnt.travel.service.ChiTietHoaDonService;
import java.util.List;
import java.util.Map;
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
@RequestMapping("/api/travel/chitiethoadon")
public class ChiTietHoaDonController {
    @Autowired
    private ChiTietHoaDonService chiTietHoaDonService;
    
    @GetMapping("")
    public ResponseEntity<List<ChiTietHoaDon>> getChiTietHoaDon(@RequestParam (required = false) String thoiGianThanhToan){      
        return new ResponseEntity<>(this.chiTietHoaDonService.getChiTietHoaDon(thoiGianThanhToan), HttpStatus.OK);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<ChiTietHoaDon> getChiTietHoaDonById(@PathVariable int id){
        return new ResponseEntity<>(this.chiTietHoaDonService.getChiTietHoaDonById(id), HttpStatus.OK);
    }
     
    @PostMapping("")
    public ResponseEntity<ChiTietHoaDon> postChiTietDatCho(@RequestBody ChiTietHoaDon cthd){
        return new ResponseEntity<>(this.chiTietHoaDonService.saveChiTietHoaDon(cthd), HttpStatus.CREATED);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<ChiTietHoaDon> putChiTietHoaDon(@PathVariable int id, @RequestBody ChiTietHoaDon cthd) {
        return new ResponseEntity<>(this.chiTietHoaDonService.updateChiTietHoaDon(id, cthd), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ChiTietHoaDon> deleteChiTietHoaDon(@PathVariable int id){
        if (this.chiTietHoaDonService.getChiTietHoaDonById(id) != null) {
            chiTietHoaDonService.deleteChiTietHoaDon(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
