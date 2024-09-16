/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dnt.travel.service;

import com.dnt.travel.models.ChiTietHoaDon;
import com.dnt.travel.repository.ChiTietHoaDonRepository;
import java.lang.reflect.Field;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ReflectionUtils;
import org.springframework.stereotype.Service;

/**
 *
 * @author DikamonTu
 */
@Service
public class ChiTietHoaDonService {
    @Autowired
    private ChiTietHoaDonRepository chiTietHoaDonRepo;
    
    public List<ChiTietHoaDon> getChiTietHoaDon(String thoiGianThanhToan){
        if (thoiGianThanhToan != null && !thoiGianThanhToan.isEmpty()) {
        // Định dạng để phân tích ngày đầu vào và ngày lưu trữ
            DateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd");
        List<ChiTietHoaDon> cthdList = new ArrayList<>();

        try {
            // Phân tích ngày đầu vào
            Date parsedNgayDat = inputFormat.parse(thoiGianThanhToan);

            // Định dạng ngày thành yyyy-MM-dd để so sánh
            String formattedNgayDat = inputFormat.format(parsedNgayDat);

            // Duyệt qua danh sách và so sánh ngày
            this.chiTietHoaDonRepo.findAll().forEach(cthd -> {
                // Định dạng ngày tạo để chỉ lấy ngày
                String formattedNgayTao = inputFormat.format(cthd.getThoiGianThanhToan());

                // So sánh phần ngày
                if (formattedNgayTao.equals(formattedNgayDat)) {
                    cthdList.add(cthd);
                }
            });
        } catch (ParseException e) {
            // Xử lý ngoại lệ
        }
        
        return cthdList;
    }
       
        return this.chiTietHoaDonRepo.findAll();
    }
    
    public ChiTietHoaDon getChiTietHoaDonById(int id){
        return this.chiTietHoaDonRepo.findByChiTietHoaDonId(id);
    }    
    
    public ChiTietHoaDon saveChiTietHoaDon(ChiTietHoaDon cthd){  
        return this.chiTietHoaDonRepo.save(cthd);
    }
    
    public ChiTietHoaDon updateChiTietHoaDon(int id, ChiTietHoaDon newChiTietHoaDon) {
        return chiTietHoaDonRepo.findById(id)
                .map(existingChiTietHoaDon -> {
                    // Cập nhật toàn bộ các trường trong `ChiTietHoaDon`
                    existingChiTietHoaDon.setIdChiTietDatCho(newChiTietHoaDon.getIdChiTietDatCho());
                    existingChiTietHoaDon.setNoiDung(newChiTietHoaDon.getNoiDung());
                    existingChiTietHoaDon.setSoTien(newChiTietHoaDon.getSoTien());
                    existingChiTietHoaDon.setThoiGianThanhToan(newChiTietHoaDon.getThoiGianThanhToan());
                    existingChiTietHoaDon.setActive(newChiTietHoaDon.getActive());

                    return chiTietHoaDonRepo.save(existingChiTietHoaDon);
                })
                .orElseGet(() -> {
                    // Nếu không tìm thấy, tạo mới một `ChiTietHoaDon`
                    newChiTietHoaDon.setChiTietHoaDonId(id);
                    return chiTietHoaDonRepo.save(newChiTietHoaDon);
                });
    }

    public void deleteChiTietHoaDon(int id){
        ChiTietHoaDon cthd = this.chiTietHoaDonRepo.findByChiTietHoaDonId(id);
        this.chiTietHoaDonRepo.delete(cthd);
    }
    
}
