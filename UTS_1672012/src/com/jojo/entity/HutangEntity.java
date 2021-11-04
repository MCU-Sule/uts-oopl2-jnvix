package com.jojo.entity;

import javax.persistence.*;
import java.util.Objects;

/**
 * @author Jonathan - 1672012
 */
@Entity
@Table(name = "hutang", schema = "SquidDB", catalog = "")
public class HutangEntity {
    private String id;
    private String pemberiUtang;
    private String jumlah;
    private String player_id;

    @Id
    @Column(name = "id", nullable = false, length = 7)
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Basic
    @Column(name = "pemberi_utang", nullable = false, length = 300)
    public String getPemberiUtang() {
        return pemberiUtang;
    }

    public void setPemberiUtang(String pemberiUtang) {
        this.pemberiUtang = pemberiUtang;
    }

    @Basic
    @Column(name = "jumlah", nullable = false, length = 100)
    public String getJumlah() {
        return jumlah;
    }

    public void setJumlah(String jumlah) {
        this.jumlah = jumlah;
    }

    @Basic
    @Column(name = "player_id", nullable = false)
    public String getKeahlian() {
        return player_id;
    }

    public void setPlayer_id(String player_id) {
        this.player_id = player_id;
    }


    @Override
    public int hashCode() {
        return Objects.hash(id, pemberiUtang, jumlah, player_id);
    }

    public void add(HutangEntity hutangEntity) {
    }
}
