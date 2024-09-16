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
import jakarta.persistence.Transient;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author DikamonTu
 */
@Entity
@Table(name = "hinh_anh_phong")
@NamedQueries({
    @NamedQuery(name = "HinhAnhPhong.findAll", query = "SELECT h FROM HinhAnhPhong h"),
    @NamedQuery(name = "HinhAnhPhong.findByHinhAnhPhongId", query = "SELECT h FROM HinhAnhPhong h WHERE h.hinhAnhPhongId = :hinhAnhPhongId"),
    @NamedQuery(name = "HinhAnhPhong.findByDuongDan", query = "SELECT h FROM HinhAnhPhong h WHERE h.duongDan = :duongDan"),
    @NamedQuery(name = "HinhAnhPhong.findByThoiGianTao", query = "SELECT h FROM HinhAnhPhong h WHERE h.thoiGianTao = :thoiGianTao"),
    @NamedQuery(name = "HinhAnhPhong.findByActive", query = "SELECT h FROM HinhAnhPhong h WHERE h.active = :active")})
public class HinhAnhPhong implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "hinh_anh_phong_id")
    private Integer hinhAnhPhongId;
    @Column(name = "duong_dan")
    private String duongDan;
    @Lob
    @Column(name = "ghi_chu")
    private String ghiChu;
    @Column(name = "thoi_gian_tao")
    @Temporal(TemporalType.TIMESTAMP)
    private Date thoiGianTao;
    @Column(name = "active")
    private Boolean active;
    @JoinColumn(name = "id_phong", referencedColumnName = "phong_id")
    @ManyToOne
    private Phong idPhong;

    @Transient
    private MultipartFile file;
    
    public HinhAnhPhong() {
    }

    public HinhAnhPhong(Integer hinhAnhPhongId) {
        this.hinhAnhPhongId = hinhAnhPhongId;
    }

    public Integer getHinhAnhPhongId() {
        return hinhAnhPhongId;
    }

    public void setHinhAnhPhongId(Integer hinhAnhPhongId) {
        this.hinhAnhPhongId = hinhAnhPhongId;
    }

    public String getDuongDan() {
        return duongDan;
    }

    public void setDuongDan(String duongDan) {
        this.duongDan = duongDan;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    public Date getThoiGianTao() {
        return thoiGianTao;
    }

    public void setThoiGianTao(Date thoiGianTao) {
        this.thoiGianTao = thoiGianTao;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Phong getIdPhong() {
        return idPhong;
    }

    public void setIdPhong(Phong idPhong) {
        this.idPhong = idPhong;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (hinhAnhPhongId != null ? hinhAnhPhongId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HinhAnhPhong)) {
            return false;
        }
        HinhAnhPhong other = (HinhAnhPhong) object;
        if ((this.hinhAnhPhongId == null && other.hinhAnhPhongId != null) || (this.hinhAnhPhongId != null && !this.hinhAnhPhongId.equals(other.hinhAnhPhongId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.dnt.travel.models.HinhAnhPhong[ hinhAnhPhongId=" + hinhAnhPhongId + " ]";
    }

    /**
     * @return the file
     */
    public MultipartFile getFile() {
        return file;
    }

    /**
     * @param file the file to set
     */
    public void setFile(MultipartFile file) {
        this.file = file;
    }
    
}
