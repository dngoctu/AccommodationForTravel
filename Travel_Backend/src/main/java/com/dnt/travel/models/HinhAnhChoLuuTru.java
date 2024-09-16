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
@Table(name = "hinh_anh_cho_luu_tru")
@NamedQueries({
    @NamedQuery(name = "HinhAnhChoLuuTru.findAll", query = "SELECT h FROM HinhAnhChoLuuTru h"),
    @NamedQuery(name = "HinhAnhChoLuuTru.findByHinhAnhChoLuuTruId", query = "SELECT h FROM HinhAnhChoLuuTru h WHERE h.hinhAnhChoLuuTruId = :hinhAnhChoLuuTruId"),
    @NamedQuery(name = "HinhAnhChoLuuTru.findByDuongDan", query = "SELECT h FROM HinhAnhChoLuuTru h WHERE h.duongDan = :duongDan"),
    @NamedQuery(name = "HinhAnhChoLuuTru.findByThoiGianTao", query = "SELECT h FROM HinhAnhChoLuuTru h WHERE h.thoiGianTao = :thoiGianTao"),
    @NamedQuery(name = "HinhAnhChoLuuTru.findByActive", query = "SELECT h FROM HinhAnhChoLuuTru h WHERE h.active = :active")})
public class HinhAnhChoLuuTru implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "hinh_anh_cho_luu_tru_id")
    private Integer hinhAnhChoLuuTruId;
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
    @JoinColumn(name = "id_cho_luu_tru", referencedColumnName = "cho_luu_tru_id")
    @ManyToOne
    private ChoLuuTru idChoLuuTru;

    @Transient
    private MultipartFile file;
    
    public HinhAnhChoLuuTru() {
    }

    public HinhAnhChoLuuTru(Integer hinhAnhChoLuuTruId) {
        this.hinhAnhChoLuuTruId = hinhAnhChoLuuTruId;
    }

    public Integer getHinhAnhChoLuuTruId() {
        return hinhAnhChoLuuTruId;
    }

    public void setHinhAnhChoLuuTruId(Integer hinhAnhChoLuuTruId) {
        this.hinhAnhChoLuuTruId = hinhAnhChoLuuTruId;
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

    public ChoLuuTru getIdChoLuuTru() {
        return idChoLuuTru;
    }

    public void setIdChoLuuTru(ChoLuuTru idChoLuuTru) {
        this.idChoLuuTru = idChoLuuTru;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (hinhAnhChoLuuTruId != null ? hinhAnhChoLuuTruId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HinhAnhChoLuuTru)) {
            return false;
        }
        HinhAnhChoLuuTru other = (HinhAnhChoLuuTru) object;
        if ((this.hinhAnhChoLuuTruId == null && other.hinhAnhChoLuuTruId != null) || (this.hinhAnhChoLuuTruId != null && !this.hinhAnhChoLuuTruId.equals(other.hinhAnhChoLuuTruId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.dnt.travel.models.HinhAnhChoLuuTru[ hinhAnhChoLuuTruId=" + hinhAnhChoLuuTruId + " ]";
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
