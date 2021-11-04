package com.jojo.entity;

import javax.persistence.*;
import java.util.Objects;

/**
 * @author Jonathan - 1672012
 */
@Entity
@Table(name = "player", schema = "SquidDB", catalog = "")
public class PlayerEntity {
    private String id;
    private String nama;
    private String umur;
    private String keahlian;

    @Id
    @Column(name = "id", nullable = false, length = 7)
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Basic
    @Column(name = "nama", nullable = false, length = 100)
    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    @Basic
    @Column(name = "umur", nullable = false, length = 300)
    public String getUmur() {
        return umur;
    }

    public void setUmur(String umur) {
        this.umur = umur;
    }

    @Basic
    @Column(name = "keahlian", nullable = false)
    public String getKeahlian() {
        return keahlian;
    }

    public void setKeahlian(String keahlian) {
        this.keahlian = keahlian;
    }


    @Override
    public int hashCode() {
        return Objects.hash(id, nama, umur, keahlian);
    }

}
