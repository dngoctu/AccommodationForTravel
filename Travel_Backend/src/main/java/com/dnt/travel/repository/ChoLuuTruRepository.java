/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dnt.travel.repository;

import com.dnt.travel.models.ChoLuuTru;
import com.dnt.travel.models.KhuVuc;
import com.dnt.travel.models.TaiKhoan;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author DikamonTu
 */
@Repository
public interface ChoLuuTruRepository extends JpaRepository<ChoLuuTru, Integer>{
    public List<ChoLuuTru> findByIdKhuVucAndLoaiContainingAndSort (KhuVuc idKhuVuc, String loai);
    public List<ChoLuuTru> findByIdTaiKhoan (TaiKhoan idTaiKhoan);
    public ChoLuuTru findByChoLuuTruId(int choLuuTruId);
}
