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
@Table(name = "chi_tiet_hoa_don")
@NamedQueries({
    @NamedQuery(name = "ChiTietHoaDon.findAll", query = "SELECT c FROM ChiTietHoaDon c"),
    @NamedQuery(name = "ChiTietHoaDon.findByChiTietHoaDonId", query = "SELECT c FROM ChiTietHoaDon c WHERE c.chiTietHoaDonId = :chiTietHoaDonId"),
    @NamedQuery(name = "ChiTietHoaDon.findByThoiGianThanhToan", query = "SELECT c FROM ChiTietHoaDon c WHERE c.thoiGianThanhToan = :thoiGianThanhToan"),
    @NamedQuery(name = "ChiTietHoaDon.findBySoTien", query = "SELECT c FROM ChiTietHoaDon c WHERE c.soTien = :soTien"),
    @NamedQuery(name = "ChiTietHoaDon.findByActive", query = "SELECT c FROM ChiTietHoaDon c WHERE c.active = :active")})
public class ChiTietHoaDon implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "chi_tiet_hoa_don_id")
    private Integer chiTietHoaDonId;
    @Column(name = "thoi_gian_thanh_toan")
    @Temporal(TemporalType.TIMESTAMP)
    private Date thoiGianThanhToan;
    @Column(name = "so_tien")
    private Long soTien;
    @Lob
    @Column(name = "noi_dung")
    private String noiDung;
    @Column(name = "active")
    private Boolean active;
    @JoinColumn(name = "id_chi_tiet_dat_cho", referencedColumnName = "chi_tiet_dat_cho_id")
    @ManyToOne
    private ChiTietDatCho idChiTietDatCho;

    public ChiTietHoaDon() {
    }

    public ChiTietHoaDon(Integer chiTietHoaDonId) {
        this.chiTietHoaDonId = chiTietHoaDonId;
    }

    public Integer getChiTietHoaDonId() {
        return chiTietHoaDonId;
    }

    public void setChiTietHoaDonId(Integer chiTietHoaDonId) {
        this.chiTietHoaDonId = chiTietHoaDonId;
    }

    public Date getThoiGianThanhToan() {
        return thoiGianThanhToan;
    }

    public void setThoiGianThanhToan(Date thoiGianThanhToan) {
        this.thoiGianThanhToan = thoiGianThanhToan;
    }

    public Long getSoTien() {
        return soTien;
    }

    public void setSoTien(Long soTien) {
        this.soTien = soTien;
    }

    public String getNoiDung() {
        return noiDung;
    }

    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public ChiTietDatCho getIdChiTietDatCho() {
        return idChiTietDatCho;
    }

    public void setIdChiTietDatCho(ChiTietDatCho idChiTietDatCho) {
        this.idChiTietDatCho = idChiTietDatCho;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (chiTietHoaDonId != null ? chiTietHoaDonId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ChiTietHoaDon)) {
            return false;
        }
        ChiTietHoaDon other = (ChiTietHoaDon) object;
        if ((this.chiTietHoaDonId == null && other.chiTietHoaDonId != null) || (this.chiTietHoaDonId != null && !this.chiTietHoaDonId.equals(other.chiTietHoaDonId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.dnt.travel.models.ChiTietHoaDon[ chiTietHoaDonId=" + chiTietHoaDonId + " ]";
    }
    
}
