package com.jojo.dao;

import com.jojo.entity.HutangEntity;
import com.jojo.util.DaoService;
import com.jojo.util.MySQLConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Jonathan-1672012
 */
public class HutangImpl implements DaoService<HutangEntity> {
    @Override
    public List<HutangEntity> fetchAll() throws SQLException, ClassNotFoundException {
        List<HutangEntity> hutangEntities = new ArrayList<>();
        try (Connection connection = MySQLConnection.createConnection()) {
            String query = "SELECT * FROM hutang";
            try (PreparedStatement ps = connection.prepareStatement(query)) {
                try (ResultSet rs = ps.executeQuery()) {
                    while (rs.next()) {
                        HutangEntity hutangEntity = new HutangEntity();
                        hutangEntity.setId(rs.getString("id"));
                        hutangEntity.setJumlah(rs.getString("jumlah"));
                        hutangEntity.setPemberiUtang(rs.getString("pemberi_utang"));
                        hutangEntity.setPlayer_id(rs.getString("player_id"));
                        hutangEntity.add(hutangEntity);
                    }
                    rs.close();
                }
                ps.close();
            }
            connection.close();
        }
        return hutangEntities;
    }

    @Override
    public int addData(HutangEntity object) throws SQLException, ClassNotFoundException {
        return 0;
    }

    @Override
    public int updateData(HutangEntity object) throws SQLException, ClassNotFoundException {
        return 0;
    }

    @Override
    public int deleteData(HutangEntity object) throws SQLException, ClassNotFoundException {
        int result = 0;
        try (Connection connection = MySQLConnection.createConnection()) {
            String query = "DELETE FROM hutang WHERE id=?";
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
