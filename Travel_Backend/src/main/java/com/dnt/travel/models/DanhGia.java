/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dnt.travel.models;

import java.io.Serializable;
import java.util.Date;
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
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

/**
 *
 * @author DikamonTu
 */
@Entity
@Table(name = "danh_gia")
@NamedQueries({
    @NamedQuery(name = "DanhGia.findAll", query = "SELECT d FROM DanhGia d"),
    @NamedQuery(name = "DanhGia.findByDanhGiaId", query = "SELECT d FROM DanhGia d WHERE d.danhGiaId = :danhGiaId"),
    @NamedQuery(name = "DanhGia.findByThoiGian", query = "SELECT d FROM DanhGia d WHERE d.thoiGian = :thoiGian"),
    @NamedQuery(name = "DanhGia.findByDanhGia", query = "SELECT d FROM DanhGia d WHERE d.danhGia = :danhGia"),
    @NamedQuery(name = "DanhGia.findByActive", query = "SELECT d FROM DanhGia d WHERE d.active = :active")})
public class DanhGia implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "danh_gia_id")
    private Integer danhGiaId;
    @Lob
    @Column(name = "binh_luan")
    private String binhLuan;
    @Column(name = "thoi_gian")
    @Temporal(TemporalType.TIMESTAMP)
    private Date thoiGian;
    @Column(name = "danh_gia")
    private Integer danhGia;
    @Column(name = "active")
    private Boolean active;
    @JoinColumn(name = "id_cho_luu_tru", referencedColumnName = "cho_luu_tru_id")
    @ManyToOne
    private ChoLuuTru idChoLuuTru;
    @JoinColumn(name = "id_tai_khoan", referencedColumnName = "tai_khoan_id")
    @ManyToOne
    private TaiKhoan idTaiKhoan;

    public DanhGia() {
    }

    public DanhGia(Integer danhGiaId) {
        this.danhGiaId = danhGiaId;
    }

    public Integer getDanhGiaId() {
        return danhGiaId;
    }

    public void setDanhGiaId(Integer danhGiaId) {
        this.danhGiaId = danhGiaId;
    }

    public String getBinhLuan() {
        return binhLuan;
    }

    public void setBinhLuan(String binhLuan) {
        this.binhLuan = binhLuan;
    }

    public Date getThoiGian() {
        return thoiGian;
    }

    public void setThoiGian(Date thoiGian) {
        this.thoiGian = thoiGian;
    }

    public Integer getDanhGia() {
        return danhGia;
    }

    public void setDanhGia(Integer danhGia) {
        this.danhGia = danhGia;
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

    public TaiKhoan getIdTaiKhoan() {
        return idTaiKhoan;
    }

    public void setIdTaiKhoan(TaiKhoan idTaiKhoan) {
        this.idTaiKhoan = idTaiKhoan;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (danhGiaId != null ? danhGiaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DanhGia)) {
            return false;
        }
        DanhGia other = (DanhGia) object;
        if ((this.danhGiaId == null && other.danhGiaId != null) || (this.danhGiaId != null && !this.danhGiaId.equals(other.danhGiaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.dnt.travel.models.DanhGia[ danhGiaId=" + danhGiaId + " ]";
    }
    
}
