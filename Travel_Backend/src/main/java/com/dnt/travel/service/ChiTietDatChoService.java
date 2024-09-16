/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dnt.travel.service;

import com.dnt.travel.models.ChiTietDatCho;
import com.dnt.travel.models.TaiKhoan;
import com.dnt.travel.repository.ChiTietDatChoRepository;
import com.dnt.travel.repository.TaiKhoanRepository;
import java.lang.reflect.Field;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
public class ChiTietDatChoService {
    @Autowired
    private ChiTietDatChoRepository chiTietDatChoRepo;
    @Autowired
    private TaiKhoanRepository taiKhoanRepo;
    
    public List<ChiTietDatCho> getChiTietDatCho(String ngayDat, String email){
        if (ngayDat != null && !ngayDat.isEmpty()) {
        // Định dạng để phân tích ngày đầu vào và ngày lưu trữ
        DateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd");
        List<ChiTietDatCho> ctdtList = new ArrayList<>();

        try {
            // Phân tích ngày đầu vào
            Date parsedNgayDat = inputFormat.parse(ngayDat);

            // Định dạng ngày thành yyyy-MM-dd để so sánh
            String formattedNgayDat = inputFormat.format(parsedNgayDat);

            // Duyệt qua danh sách và so sánh ngày
            this.chiTietDatChoRepo.findAll().forEach(ctdt -> {
                // Định dạng ngày tạo để chỉ lấy ngày
                String formattedNgayTao = inputFormat.format(ctdt.getNgayTao());

                // So sánh phần ngày
                if (formattedNgayTao.equals(formattedNgayDat)) {
                    ctdtList.add(ctdt);
                }
            });
            
        } catch (ParseException e) {
            // Xử lý ngoại lệ
        }

        return ctdtList;
    }
        if (email != null && email != ""){
            TaiKhoan taiKhoan = this.taiKhoanRepo.findByEmail(email);
            return this.chiTietDatChoRepo.findByIdTaiKhoan(taiKhoan);
        }
        return this.chiTietDatChoRepo.findAll();
    }
    
    public ChiTietDatCho getChiTietDatChoById(int id){
        return this.chiTietDatChoRepo.findByChiTietDatChoId(id);
    }    
    
    public List<ChiTietDatCho> getChiTietDatChoByIdTaiKhoan(TaiKhoan taiKhoan){
        return this.chiTietDatChoRepo.findByIdTaiKhoan(taiKhoan);
    }
    
    public ChiTietDatCho saveChiTietDatCho(ChiTietDatCho ctdc){  
        return this.chiTietDatChoRepo.save(ctdc);
    }
    
    public ChiTietDatCho updateChiTietDatCho(int id, ChiTietDatCho newChiTietDatCho) {
        return chiTietDatChoRepo.findById(id)
                .map(existingChiTietDatCho -> {
                    // Cập nhật toàn bộ các trường
                    existingChiTietDatCho.setChiTietHoaDonList(newChiTietDatCho.getChiTietHoaDonList());
                    existingChiTietDatCho.setGhiChu(newChiTietDatCho.getGhiChu());
                    existingChiTietDatCho.setIdPhong(newChiTietDatCho.getIdPhong());
                    existingChiTietDatCho.setIdTaiKhoan(newChiTietDatCho.getIdTaiKhoan());
                    existingChiTietDatCho.setNgayCapNhat(newChiTietDatCho.getNgayCapNhat());
                    existingChiTietDatCho.setNgayDat(newChiTietDatCho.getNgayDat());
                    existingChiTietDatCho.setNgayTao(newChiTietDatCho.getNgayTao());
                    existingChiTietDatCho.setNgayTra(newChiTietDatCho.getNgayTra());
                    existingChiTietDatCho.setSoTien(newChiTietDatCho.getSoTien());
                    existingChiTietDatCho.setTinhTrang(newChiTietDatCho.getTinhTrang());
                    existingChiTietDatCho.setActive(newChiTietDatCho.getActive());
                    
                    return chiTietDatChoRepo.save(existingChiTietDatCho);
                })
                .orElseGet(() -> {
                    // Nếu không tìm thấy, tạo mới
                    newChiTietDatCho.setChiTietDatChoId(id);
                    return chiTietDatChoRepo.save(newChiTietDatCho);
                });
    }
    
    public void deleteChiTietDatCho(int id){
        this.chiTietDatChoRepo.deleteById(id);
    }
    
}
