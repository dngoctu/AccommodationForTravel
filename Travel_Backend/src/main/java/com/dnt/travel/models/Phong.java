/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dnt.travel.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

/**
 *
 * @author DikamonTu
 */
@Entity
@Table(name = "phong")
@NamedQueries({
    @NamedQuery(name = "Phong.findAll", query = "SELECT p FROM Phong p"),
    @NamedQuery(name = "Phong.findByPhongId", query = "SELECT p FROM Phong p WHERE p.phongId = :phongId"),
    @NamedQuery(name = "Phong.findBySoTien", query = "SELECT p FROM Phong p WHERE p.soTien = :soTien"),
    @NamedQuery(name = "Phong.findBySoNguoi", query = "SELECT p FROM Phong p WHERE p.soNguoi = :soNguoi"),
    @NamedQuery(name = "Phong.findByTinhTrang", query = "SELECT p FROM Phong p WHERE p.tinhTrang = :tinhTrang"),
    @NamedQuery(name = "Phong.findByThoiGianTao", query = "SELECT p FROM Phong p WHERE p.thoiGianTao = :thoiGianTao"),
    @NamedQuery(name = "Phong.findByThoiGianCapNhat", query = "SELECT p FROM Phong p WHERE p.thoiGianCapNhat = :thoiGianCapNhat"),
    @NamedQuery(name = "Phong.findByActive", query = "SELECT p FROM Phong p WHERE p.active = :active")})
public class Phong implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "phong_id")
    private Integer phongId;
    @Lob
    @Column(name = "ten_phong")
    private String tenPhong;
    @Column(name = "so_tien")
    private Long soTien;
    @Column(name = "so_nguoi")
    private Integer soNguoi;
    @Column(name = "tinh_trang")
    private String tinhTrang;
    @Column(name = "thoi_gian_tao")
    @Temporal(TemporalType.TIMESTAMP)
    private Date thoiGianTao;
    @Column(name = "thoi_gian_cap_nhat")
    @Temporal(TemporalType.TIMESTAMP)
    private Date thoiGianCapNhat;
    @Column(name = "active")
    private Boolean active;
    @JoinColumn(name = "id_cho_luu_tru", referencedColumnName = "cho_luu_tru_id")
    @ManyToOne
    private ChoLuuTru idChoLuuTru;
    @OneToMany(mappedBy = "idPhong")
    @JsonIgnore
    private List<ChiTietDatCho> chiTietDatChoList;
    @OneToMany(mappedBy = "idPhong")
    @JsonIgnore
    private List<HinhAnhPhong> hinhAnhPhongList;

    public Phong() {
    }

    public Phong(Integer phongId) {
        this.phongId = phongId;
    }

    public Integer getPhongId() {
        return phongId;
    }

    public void setPhongId(Integer phongId) {
        this.phongId = phongId;
    }

    public String getTenPhong() {
        return tenPhong;
    }

    public void setTenPhong(String tenPhong) {
        this.tenPhong = tenPhong;
    }

    public Long getSoTien() {
        return soTien;
    }

    public void setSoTien(Long soTien) {
        this.soTien = soTien;
    }

    public Integer getSoNguoi() {
        return soNguoi;
    }

    public void setSoNguoi(Integer soNguoi) {
        this.soNguoi = soNguoi;
    }

    public String getTinhTrang() {
        return tinhTrang;
    }

    public void setTinhTrang(String tinhTrang) {
        this.tinhTrang = tinhTrang;
    }

    public Date getThoiGianTao() {
        return thoiGianTao;
    }

    public void setThoiGianTao(Date thoiGianTao) {
        this.thoiGianTao = thoiGianTao;
    }

    public Date getThoiGianCapNhat() {
        return thoiGianCapNhat;
    }

    public void setThoiGianCapNhat(Date thoiGianCapNhat) {
        this.thoiGianCapNhat = thoiGianCapNhat;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public ChoLuuTru getIdChoLuuTru() {
        return idChoLuuTru;
    }

    public void setIdChoLuuTru(ChoLuuTru idChoLuuTru) {
        this.idChoLuuTru = idChoLuuTru;
    }

    public List<ChiTietDatCho> getChiTietDatChoList() {
        return chiTietDatChoList;
    }

    public void setChiTietDatChoList(List<ChiTietDatCho> chiTietDatChoList) {
        this.chiTietDatChoList = chiTietDatChoList;
    }

    public List<HinhAnhPhong> getHinhAnhPhongList() {
        return hinhAnhPhongList;
    }

    public void setHinhAnhPhongList(List<HinhAnhPhong> hinhAnhPhongList) {
        this.hinhAnhPhongList = hinhAnhPhongList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (phongId != null ? phongId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Phong)) {
            return false;
        }
        Phong other = (Phong) object;
        if ((this.phongId == null && other.phongId != null) || (this.phongId != null && !this.phongId.equals(other.phongId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.dnt.travel.models.Phong[ phongId=" + phongId + " ]";
    }
    
}
