package com.jojo.dao;

import com.jojo.entity.HutangEntity;
import com.jojo.entity.PlayerEntity;
import com.jojo.util.DaoService;
import com.jojo.util.MySQLConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Jonathan-1627012
 */
public class PlayerDaoImpl implements DaoService<PlayerEntity> {
    @Override
    public List<PlayerEntity> fetchAll() throws SQLException, ClassNotFoundException {
        List<PlayerEntity> playerEntities = new ArrayList<>();
        try (Connection connection = MySQLConnection.createConnection()) {
            String query = "SELECT * FROM mahasiswa";
            try (PreparedStatement ps = connection.prepareStatement(query)) {
                try (ResultSet rs = ps.executeQuery()) {
                    while (rs.next()) {
                        HutangEntity hutangEntity = new HutangEntity();
                        hutangEntity.setId(rs.getString("id"));
                        hutangEntity.setJumlah(rs.getString("jumlah"));
                        hutangEntity.setPemberiUtang(rs.getString("pemberi_utang"));
                        hutangEntity.setPlayer_id(rs.getString("player_id"));


                        PlayerEntity playerEntity = new PlayerEntity();
                        playerEntity.setId(rs.getString("id"));
                        playerEntity.setNama(rs.getString("nama"));
                        playerEntity.setUmur(rs.getString("umur"));
                        playerEntity.setKeahlian(rs.getString("keahlian"));
                    }
                    rs.close();
                }
                ps.close();
            }
            connection.close();
        }
        return playerEntities;
    }

    @Override
    public int addData(PlayerEntity object) throws SQLException, ClassNotFoundException {
        int result = 0;
        try (Connection connection = MySQLConnection.createConnection()) {
            String query = "INSERT INTO mahasiswa(id, first_name, last_name, address, birth_date, male, dosen_wali_nik) VALUES(?,?)";
            try (PreparedStatement ps = connection.prepareStatement(query)) {
                ps.setString(1, object.getId());
                ps.setString(2, object.getNama());
                ps.setString(3, object.getUmur());
                ps.setString(4, object.getKeahlian());
                if (ps.executeUpdate() != 0) {
                    connection.commit();
                    result = 1;
                } else {
                    connection.rollback();
                }
                ps.close();
            }
            connection.close();
        }
        return result;
    }

    @Override
    public int updateData(PlayerEntity object) throws SQLException, ClassNotFoundException {
        int result = 0;
        try (Connection connection = MySQLConnection.createConnection()) {
            String query = "UPDATE mahasiswa SET first_name=?, address=?WHERE id = ?";
            try (PreparedStatement ps = connection.prepareStatement(query)) {
                ps.setString(1, object.getId());
                ps.setString(2,object.getNama());
                ps.setString(3, object.getUmur());
                ps.setString(3, object.getKeahlian());
                if (ps.executeUpdate() != 0) {
                    connection.commit();
                    result = 1;
                } else {
                    connection.rollback();
                }
                ps.close();
            }
            connection.close();
        }
        return result;
    }

    @Override
    public int deleteData(PlayerEntity object) throws SQLException, ClassNotFoundException {
        int result = 0;
        try (Connection connection = MySQLConnection.createConnection()) {
            String query = "DELETE FROM mahasiswa WHERE id=?";
            try (PreparedStatement ps = connection.prepareStatement(query)) {
                ps.setString(1, object.getId());
                if (ps.executeUpdate() != 0) {
                    connection.commit();
                    result = 1;
                } else {
                    connection.rollback();
                }
                ps.close();
            }
            connection.close();
        }
        return result;
    }
}
