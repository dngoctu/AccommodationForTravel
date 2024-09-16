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
@Table(name = "chi_tiet_dat_cho")
@NamedQueries({
    @NamedQuery(name = "ChiTietDatCho.findAll", query = "SELECT c FROM ChiTietDatCho c"),
    @NamedQuery(name = "ChiTietDatCho.findByChiTietDatChoId", query = "SELECT c FROM ChiTietDatCho c WHERE c.chiTietDatChoId = :chiTietDatChoId"),
    @NamedQuery(name = "ChiTietDatCho.findByNgayDat", query = "SELECT c FROM ChiTietDatCho c WHERE c.ngayDat = :ngayDat"),
    @NamedQuery(name = "ChiTietDatCho.findByNgayTra", query = "SELECT c FROM ChiTietDatCho c WHERE c.ngayTra = :ngayTra"),
    @NamedQuery(name = "ChiTietDatCho.findBySoTien", query = "SELECT c FROM ChiTietDatCho c WHERE c.soTien = :soTien"),
    @NamedQuery(name = "ChiTietDatCho.findByTinhTrang", query = "SELECT c FROM ChiTietDatCho c WHERE c.tinhTrang = :tinhTrang"),
    @NamedQuery(name = "ChiTietDatCho.findByNgayTao", query = "SELECT c FROM ChiTietDatCho c WHERE c.ngayTao = :ngayTao"),
    @NamedQuery(name = "ChiTietDatCho.findByNgayCapNhat", query = "SELECT c FROM ChiTietDatCho c WHERE c.ngayCapNhat = :ngayCapNhat"),
    @NamedQuery(name = "ChiTietDatCho.findByActive", query = "SELECT c FROM ChiTietDatCho c WHERE c.active = :active")})
public class ChiTietDatCho implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "chi_tiet_dat_cho_id")
    private Integer chiTietDatChoId;
    @Column(name = "ngay_dat")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ngayDat;
    @Column(name = "ngay_tra")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ngayTra;
    @Lob
    @Column(name = "ghi_chu")
    private String ghiChu;
    @Column(name = "so_tien")
    private Long soTien;
    @Column(name = "tinh_trang")
    private String tinhTrang;
    @Column(name = "ngay_tao")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ngayTao;
    @Column(name = "ngay_cap_nhat")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ngayCapNhat;
    @Column(name = "active")
    private Boolean active;
    @JoinColumn(name = "id_phong", referencedColumnName = "phong_id")
    @ManyToOne
    private Phong idPhong;
    @JoinColumn(name = "id_tai_khoan", referencedColumnName = "tai_khoan_id")
    @ManyToOne
    private TaiKhoan idTaiKhoan;
    @OneToMany(mappedBy = "idChiTietDatCho")
    @JsonIgnore
    private List<ChiTietHoaDon> chiTietHoaDonList;

    public ChiTietDatCho() {
    }

    public ChiTietDatCho(Integer chiTietDatChoId) {
        this.chiTietDatChoId = chiTietDatChoId;
    }

    public Integer getChiTietDatChoId() {
        return chiTietDatChoId;
    }

    public void setChiTietDatChoId(Integer chiTietDatChoId) {
        this.chiTietDatChoId = chiTietDatChoId;
    }

    public Date getNgayDat() {
        return ngayDat;
    }

    public void setNgayDat(Date ngayDat) {
        this.ngayDat = ngayDat;
    }

    public Date getNgayTra() {
        return ngayTra;
    }

    public void setNgayTra(Date ngayTra) {
        this.ngayTra = ngayTra;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    public Long getSoTien() {
        return soTien;
    }

    public void setSoTien(Long soTien) {
        this.soTien = soTien;
    }

    public String getTinhTrang() {
        return tinhTrang;
    }

    public void setTinhTrang(String tinhTrang) {
        this.tinhTrang = tinhTrang;
    }

    public Date getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(Date ngayTao) {
        this.ngayTao = ngayTao;
    }

    public Date getNgayCapNhat() {
        return ngayCapNhat;
    }

    public void setNgayCapNhat(Date ngayCapNhat) {
        this.ngayCapNhat = ngayCapNhat;
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

    public TaiKhoan getIdTaiKhoan() {
        return idTaiKhoan;
    }

    public void setIdTaiKhoan(TaiKhoan idTaiKhoan) {
        this.idTaiKhoan = idTaiKhoan;
    }

    public List<ChiTietHoaDon> getChiTietHoaDonList() {
        return chiTietHoaDonList;
    }

    public void setChiTietHoaDonList(List<ChiTietHoaDon> chiTietHoaDonList) {
        this.chiTietHoaDonList = chiTietHoaDonList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (chiTietDatChoId != null ? chiTietDatChoId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ChiTietDatCho)) {
            return false;
        }
        ChiTietDatCho other = (ChiTietDatCho) object;
        if ((this.chiTietDatChoId == null && other.chiTietDatChoId != null) || (this.chiTietDatChoId != null && !this.chiTietDatChoId.equals(other.chiTietDatChoId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.dnt.travel.models.ChiTietDatCho[ chiTietDatChoId=" + chiTietDatChoId + " ]";
    }
    
}
