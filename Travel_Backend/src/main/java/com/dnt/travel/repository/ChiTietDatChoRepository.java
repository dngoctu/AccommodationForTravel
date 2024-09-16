/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dnt.travel.repository;

import com.dnt.travel.models.ChiTietDatCho;
import com.dnt.travel.models.TaiKhoan;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author DikamonTu
 */
@Repository
public interface ChiTietDatChoRepository extends JpaRepository<ChiTietDatCho, Integer>{
    public ChiTietDatCho findByChiTietDatChoId(int id);
    public List<ChiTietDatCho> findByIdTaiKhoan(TaiKhoan idTaiKhoan);
}