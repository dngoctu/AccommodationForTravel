/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dnt.travel.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "cho_luu_tru")
@NamedQueries({
    @NamedQuery(name = "ChoLuuTru.findAll", query = "SELECT c FROM ChoLuuTru c"),
    @NamedQuery(name = "ChoLuuTru.findByChoLuuTruId", query = "SELECT c FROM ChoLuuTru c WHERE c.choLuuTruId = :choLuuTruId"),
    @NamedQuery(name = "ChoLuuTru.findByTen", query = "SELECT c FROM ChoLuuTru c WHERE c.ten = :ten"),
    @NamedQuery(name = "ChoLuuTru.findByLoai", query = "SELECT c FROM ChoLuuTru c WHERE c.loai = :loai"),
    @NamedQuery(name = "ChoLuuTru.findByThoiGianTao", query = "SELECT c FROM ChoLuuTru c WHERE c.thoiGianTao = :thoiGianTao"),
    @NamedQuery(name = "ChoLuuTru.findByThoiGianCapNhat", query = "SELECT c FROM ChoLuuTru c WHERE c.thoiGianCapNhat = :thoiGianCapNhat"),
    @NamedQuery(name = "ChoLuuTru.findByKinhDo", query = "SELECT c FROM ChoLuuTru c WHERE c.kinhDo = :kinhDo"),
    @NamedQuery(name = "ChoLuuTru.findByViDo", query = "SELECT c FROM ChoLuuTru c WHERE c.viDo = :viDo"),
    @NamedQuery(name = "ChoLuuTru.findByActive", query = "SELECT c FROM ChoLuuTru c WHERE c.active = :active")})
public class ChoLuuTru implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cho_luu_tru_id")
    private Integer choLuuTruId;
    @Lob
    @Column(name = "dia_chi")
    private String diaChi;
    @Column(name = "ten")
    private String ten;
    @Lob
    @Column(name = "mo_ta")
    private String moTa;
    @Column(name = "loai")
    private String loai;
    @Column(name = "thoi_gian_tao")
    @Temporal(TemporalType.TIMESTAMP)
    private Date thoiGianTao;
    @Column(name = "thoi_gian_cap_nhat")
    @Temporal(TemporalType.TIMESTAMP)
    private Date thoiGianCapNhat;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "kinh_do")
    private BigDecimal kinhDo;
    @Column(name = "vi_do")
    private BigDecimal viDo;
    @Column(name = "active")
    private Boolean active;
    @OneToMany(mappedBy = "idChoLuuTru")
    @JsonIgnore
    private List<HinhAnhChoLuuTru> hinhAnhChoLuuTruList;
    @JoinColumn(name = "id_khu_vuc", referencedColumnName = "khu_vuc_id")
    @ManyToOne
    private KhuVuc idKhuVuc;
    @JoinColumn(name = "id_tai_khoan", referencedColumnName = "tai_khoan_id")
    @ManyToOne
    private TaiKhoan idTaiKhoan;
    @OneToMany(mappedBy = "idChoLuuTru")
    @JsonIgnore
    private List<DanhGia> danhGiaList;
    @OneToMany(mappedBy = "idChoLuuTru")
    @JsonIgnore
    private List<Phong> phongList;

    public ChoLuuTru() {
    }

    public ChoLuuTru(Integer choLuuTruId) {
        this.choLuuTruId = choLuuTruId;
    }

    public Integer getChoLuuTruId() {
        return choLuuTruId;
    }

    public void setChoLuuTruId(Integer choLuuTruId) {
        this.choLuuTruId = choLuuTruId;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public String getLoai() {
        return loai;
    }

    public void setLoai(String loai) {
        this.loai = loai;
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

    public BigDecimal getKinhDo() {
        return kinhDo;
    }

    public void setKinhDo(BigDecimal kinhDo) {
        this.kinhDo = kinhDo;
    }

    public BigDecimal getViDo() {
        return viDo;
    }

    public void setViDo(BigDecimal viDo) {
        this.viDo = viDo;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public List<HinhAnhChoLuuTru> getHinhAnhChoLuuTruList() {
        return hinhAnhChoLuuTruList;
    }

    public void setHinhAnhChoLuuTruList(List<HinhAnhChoLuuTru> hinhAnhChoLuuTruList) {
        this.hinhAnhChoLuuTruList = hinhAnhChoLuuTruList;
    }

    public KhuVuc getIdKhuVuc() {
        return idKhuVuc;
    }

    public void setIdKhuVuc(KhuVuc idKhuVuc) {
        this.idKhuVuc = idKhuVuc;
    }

    public TaiKhoan getIdTaiKhoan() {
        return idTaiKhoan;
    }

    public void setIdTaiKhoan(TaiKhoan idTaiKhoan) {
        this.idTaiKhoan = idTaiKhoan;
    }

    public List<DanhGia> getDanhGiaList() {
        return danhGiaList;
    }

    public void setDanhGiaList(List<DanhGia> danhGiaList) {
        this.danhGiaList = danhGiaList;
    }

    public List<Phong> getPhongList() {
        return phongList;
    }

    public void setPhongList(List<Phong> phongList) {
        this.phongList = phongList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (choLuuTruId != null ? choLuuTruId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ChoLuuTru)) {
            return false;
        }
        ChoLuuTru other = (ChoLuuTru) object;
        if ((this.choLuuTruId == null && other.choLuuTruId != null) || (this.choLuuTruId != null && !this.choLuuTruId.equals(other.choLuuTruId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.dnt.travel.models.ChoLuuTru[ choLuuTruId=" + choLuuTruId + " ]";
    }
    
}
