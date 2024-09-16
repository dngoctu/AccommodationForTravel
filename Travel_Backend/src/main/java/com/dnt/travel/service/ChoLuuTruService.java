/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dnt.travel.service;

import com.dnt.travel.models.ChoLuuTru;
import com.dnt.travel.models.KhuVuc;
import com.dnt.travel.models.TaiKhoan;
import com.dnt.travel.repository.ChoLuuTruRepository;
import com.dnt.travel.repository.TaiKhoanRepository;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author DikamonTu
 */
@Service
public class ChoLuuTruService {
    @Autowired
    private ChoLuuTruRepository choLuuTruRepo;
    @Autowired
    private TaiKhoanRepository taiKhoanRepo;
    
    public List<ChoLuuTru> getChoLuuTru(KhuVuc khuVuc, String loai){       
        return this.choLuuTruRepo.findByIdKhuVucAndLoaiContainingAndSort(khuVuc, loai);
    }
    
    public ChoLuuTru getChoLuuTruById(int id){       
        return this.choLuuTruRepo.findByChoLuuTruId(id);
    }
    
    public List<ChoLuuTru> getChoLuuTruByIdTaiKhoan(TaiKhoan idTaiKhoan){
        return this.choLuuTruRepo.findByIdTaiKhoan(idTaiKhoan);
    }
    
    public ChoLuuTru saveChoLuuTru(ChoLuuTru choLuuTru){
        return this.choLuuTruRepo.save(choLuuTru);
    }
    
    public ChoLuuTru updateChoLuuTru(int id, ChoLuuTru newChoLuuTru){
        return this.choLuuTruRepo.findById(id)
                .map(existingChoLuuTru -> {
                    // Cập nhật toàn bộ các trường
                    existingChoLuuTru.setDanhGiaList(newChoLuuTru.getDanhGiaList());
                    existingChoLuuTru.setDiaChi(newChoLuuTru.getDiaChi());
                    existingChoLuuTru.setHinhAnhChoLuuTruList(newChoLuuTru.getHinhAnhChoLuuTruList());
                    existingChoLuuTru.setIdKhuVuc(newChoLuuTru.getIdKhuVuc());
                    existingChoLuuTru.setIdTaiKhoan(newChoLuuTru.getIdTaiKhoan());
                    existingChoLuuTru.setKinhDo(newChoLuuTru.getKinhDo());
                    existingChoLuuTru.setViDo(newChoLuuTru.getViDo());
                    existingChoLuuTru.setLoai(newChoLuuTru.getLoai());
                    existingChoLuuTru.setMoTa(newChoLuuTru.getMoTa());
                    existingChoLuuTru.setPhongList(newChoLuuTru.getPhongList());
                    existingChoLuuTru.setTen(newChoLuuTru.getTen());
                    existingChoLuuTru.setThoiGianCapNhat(newChoLuuTru.getThoiGianTao());
                    existingChoLuuTru.setThoiGianTao(newChoLuuTru.getThoiGianTao());
                    existingChoLuuTru.setActive(newChoLuuTru.getActive());
                    
                    return this.choLuuTruRepo.save(existingChoLuuTru);
                })
                .orElseGet(() -> {
                    // Nếu không tìm thấy, tạo mới
                    newChoLuuTru.setChoLuuTruId(id);
                    return this.choLuuTruRepo.save(newChoLuuTru);
                });
    }
    
    public void deleteChoLuuTru(int id){
        Optional<ChoLuuTru> exist = this.choLuuTruRepo.findById(id);
        if (exist.isPresent()) {
            this.choLuuTruRepo.deleteById(id);
        } else {
            throw new RuntimeException("ChoLuuTru not found with id: " + id);  // Ném ra ngoại lệ 
        }
    }
    
}
