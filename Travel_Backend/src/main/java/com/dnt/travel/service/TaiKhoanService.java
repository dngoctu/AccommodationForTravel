/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dnt.travel.service;

import com.dnt.travel.models.TaiKhoan;
import com.dnt.travel.repository.TaiKhoanRepository;
import java.lang.reflect.Field;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

/**
 *
 * @author DikamonTu
 */
@Service
public class TaiKhoanService {
    @Autowired
    private TaiKhoanRepository taiKhoanRepo;
    
//    @Autowired
//    private BCryptPasswordEncoder passEncoder;
    
    public List<TaiKhoan> getTaiKhoan(){
        return this.taiKhoanRepo.findAll();
    }
    
    public TaiKhoan getTaiKhoanByUsername(String username){
        return this.taiKhoanRepo.findByUsername(username);
    }
    
    public TaiKhoan getTaiKhoanById(int id){
        return this.taiKhoanRepo.findByTaiKhoanId(id);
    }
    
    public TaiKhoan getTaiKhoanByEmail(String email){
        return this.taiKhoanRepo.findByEmail(email);
    }
    
    public TaiKhoan saveTaiKhoan (TaiKhoan tk){
        return this.taiKhoanRepo.save(tk);
    }
    
    public TaiKhoan updatePartOfTaiKhoan(int id, Map<String, Object> fields) throws Exception {
        TaiKhoan exist = taiKhoanRepo.findByTaiKhoanId(id);
        
        if (exist != null) {
            fields.forEach((key, value) -> {
                Field field = ReflectionUtils.findField(TaiKhoan.class, key);
                
                if (field != null) {
                    field.setAccessible(true);
                ReflectionUtils.setField(field, exist, value);
                }
            });
            return taiKhoanRepo.save(exist);
        } else {
            throw new Exception("TaiKhoan not found with id: " + id);
        }       
    }
    
//    public boolean authTaiKhoan(String username, String password) {
//        TaiKhoan tk = this.getTaiKhoanByUsername(username);
//        
//        return this.passEncoder.matches(password, tk.getPassword());
//    } 
}

