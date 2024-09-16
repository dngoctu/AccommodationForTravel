/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dnt.travel.repository;

import com.dnt.travel.models.ChiTietHoaDon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author DikamonTu
 */
@Repository
public interface ChiTietHoaDonRepository extends JpaRepository<ChiTietHoaDon, Integer>{
    public ChiTietHoaDon findByChiTietHoaDonId (int chiTietHoaDonId);
}
