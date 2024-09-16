/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dnt.travel.repository;

import com.dnt.travel.models.TaiKhoan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author DikamonTu
 */
@Repository
public interface TaiKhoanRepository extends JpaRepository<TaiKhoan, Integer>{
    TaiKhoan findByUsername(String username);
    TaiKhoan findByTaiKhoanId(int taiKhoanId);
    TaiKhoan findByEmail(String email);
}
