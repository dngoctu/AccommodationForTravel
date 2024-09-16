/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dnt.travel.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.List;
import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

/**
 *
 * @author DikamonTu
 */
@Entity
@Table(name = "khu_vuc")
@NamedQueries({
    @NamedQuery(name = "KhuVuc.findAll", query = "SELECT k FROM KhuVuc k"),
    @NamedQuery(name = "KhuVuc.findByKhuVucId", query = "SELECT k FROM KhuVuc k WHERE k.khuVucId = :khuVucId"),
    @NamedQuery(name = "KhuVuc.findByActive", query = "SELECT k FROM KhuVuc k WHERE k.active = :active")})
public class KhuVuc implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "khu_vuc_id")
    private Integer khuVucId;
    @Lob
    @Column(name = "ten_khu_vuc")
    private String tenKhuVuc;
    @Column(name = "active")
    private Boolean active;
    @OneToMany(mappedBy = "idKhuVuc")
    @JsonIgnore
    private List<ChoLuuTru> choLuuTruList;

    public KhuVuc() {
    }

    public KhuVuc(Integer khuVucId) {
        this.khuVucId = khuVucId;
    }

    public Integer getKhuVucId() {
        return khuVucId;
    }

    public void setKhuVucId(Integer khuVucId) {
        this.khuVucId = khuVucId;
    }

    public String getTenKhuVuc() {
        return tenKhuVuc;
    }

    public void setTenKhuVuc(String tenKhuVuc) {
        this.tenKhuVuc = tenKhuVuc;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (khuVucId != null ? khuVucId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof KhuVuc)) {
            return false;
        }
        KhuVuc other = (KhuVuc) object;
        if ((this.khuVucId == null && other.khuVucId != null) || (this.khuVucId != null && !this.khuVucId.equals(other.khuVucId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.dnt.travel.models.KhuVuc[ khuVucId=" + khuVucId + " ]";
    }
    
}
