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
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
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
@Table(name = "tai_khoan")
@NamedQueries({
    @NamedQuery(name = "TaiKhoan.findAll", query = "SELECT t FROM TaiKhoan t"),
    @NamedQuery(name = "TaiKhoan.findByTaiKhoanId", query = "SELECT t FROM TaiKhoan t WHERE t.taiKhoanId = :taiKhoanId"),
    @NamedQuery(name = "TaiKhoan.findByUsername", query = "SELECT t FROM TaiKhoan t WHERE t.username = :username"),
    @NamedQuery(name = "TaiKhoan.findByPassword", query = "SELECT t FROM TaiKhoan t WHERE t.password = :password"),
    @NamedQuery(name = "TaiKhoan.findByHo", query = "SELECT t FROM TaiKhoan t WHERE t.ho = :ho"),
    @NamedQuery(name = "TaiKhoan.findByTen", query = "SELECT t FROM TaiKhoan t WHERE t.ten = :ten"),
    @NamedQuery(name = "TaiKhoan.findByDiaChi", query = "SELECT t FROM TaiKhoan t WHERE t.diaChi = :diaChi"),
    @NamedQuery(name = "TaiKhoan.findBySdt", query = "SELECT t FROM TaiKhoan t WHERE t.sdt = :sdt"),
    @NamedQuery(name = "TaiKhoan.findByEmail", query = "SELECT t FROM TaiKhoan t WHERE t.email = :email"),
    @NamedQuery(name = "TaiKhoan.findByNgayTao", query = "SELECT t FROM TaiKhoan t WHERE t.ngayTao = :ngayTao"),
    @NamedQuery(name = "TaiKhoan.findByNgayDangNhap", query = "SELECT t FROM TaiKhoan t WHERE t.ngayDangNhap = :ngayDangNhap"),
    @NamedQuery(name = "TaiKhoan.findByVaiTro", query = "SELECT t FROM TaiKhoan t WHERE t.vaiTro = :vaiTro"),
    @NamedQuery(name = "TaiKhoan.findByActive", query = "SELECT t FROM TaiKhoan t WHERE t.active = :active")})
public class TaiKhoan implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "tai_khoan_id")
    private Integer taiKhoanId;
    @Column(name = "username")
    private String username;
    @Column(name = "password")
    private String password;
    @Column(name = "ho")
    private String ho;
    @Column(name = "ten")
    private String ten;
    @Column(name = "dia_chi")
    private String diaChi;
    @Column(name = "sdt")
    private String sdt;
    @Column(name = "email")
    private String email;
    @Column(name = "ngay_tao")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ngayTao;
    @Column(name = "ngay_dang_nhap")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ngayDangNhap;
    @Column(name = "vai_tro")
    private String vaiTro;
    @Column(name = "avatar")
    private String avatar;
    @Column(name = "active")
    private Boolean active;
    @OneToMany(mappedBy = "idTaiKhoan")
    @JsonIgnore
    private List<ChoLuuTru> choLuuTruList;
    @OneToMany(mappedBy = "idTaiKhoan")
    @JsonIgnore
    private List<DanhGia> danhGiaList;
    @OneToMany(mappedBy = "idTaiKhoan")
    @JsonIgnore
    private List<ChiTietDatCho> chiTietDatChoList;

    @Transient
    private MultipartFile file;
    
    public TaiKhoan() {
    }

    public TaiKhoan(Integer taiKhoanId) {
        this.taiKhoanId = taiKhoanId;
    }

    public Integer getTaiKhoanId() {
        return taiKhoanId;
    }

    public void setTaiKhoanId(Integer taiKhoanId) {
        this.taiKhoanId = taiKhoanId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getHo() {
        return ho;
    }

    public void setHo(String ho) {
        this.ho = ho;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }
    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(Date ngayTao) {
        this.ngayTao = ngayTao;
    }

    public Date getNgayDangNhap() {
        return ngayDangNhap;
    }

    public void setNgayDangNhap(Date ngayDangNhap) {
        this.ngayDangNhap = ngayDangNhap;
    }

    public String getVaiTro() {
        return vaiTro;
    }

    public void setVaiTro(String vaiTro) {
        this.vaiTro = vaiTro;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
        
    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public List<ChoLuuTru> getChoLuuTruList() {
        return choLuuTruList;
    }

    public void setChoLuuTruList(List<ChoLuuTru> choLuuTruList) {
        this.choLuuTruList = choLuuTruList;
    }

    public List<DanhGia> getDanhGiaList() {
        return danhGiaList;
    }

    public void setDanhGiaList(List<DanhGia> danhGiaList) {
        this.danhGiaList = danhGiaList;
    }

    public List<ChiTietDatCho> getChiTietDatChoList() {
        return chiTietDatChoList;
    }

    public void setChiTietDatChoList(List<ChiTietDatCho> chiTietDatChoList) {
        this.chiTietDatChoList = chiTietDatChoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (taiKhoanId != null ? taiKhoanId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TaiKhoan)) {
            return false;
        }
        TaiKhoan other = (TaiKhoan) object;
        if ((this.taiKhoanId == null && other.taiKhoanId != null) || (this.taiKhoanId != null && !this.taiKhoanId.equals(other.taiKhoanId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.dnt.travel.models.TaiKhoan[ taiKhoanId=" + taiKhoanId + " ]";
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
