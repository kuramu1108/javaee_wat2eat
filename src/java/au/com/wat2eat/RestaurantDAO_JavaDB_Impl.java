/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package au.com.wat2eat;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 *
 * @author garysnmb
 */
public class RestaurantDAO_JavaDB_Impl implements RestaurantDAO {
    private ArrayList<RestaurantDTO> restaurants;
    
    public RestaurantDAO_JavaDB_Impl() {
        restaurants = new ArrayList<>();
        try {
            DataSource ds = (DataSource) InitialContext.doLookup("jdbc/aip");
            String sql = "select * from restaurant";
            try (Connection conn = ds.getConnection();
                    Statement stat = conn.createStatement();
                    ResultSet rs = stat.executeQuery(sql)) {
                while (rs.next()) {
                    // todo
                    RestaurantDTO res = new RestaurantDTO();
                }
            } catch (SQLException ex) {
                Logger.getLogger(RestaurantDAO_JavaDB_Impl.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (NamingException ex) {
            Logger.getLogger(RestaurantDAO_JavaDB_Impl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public void create(RestaurantDTO res) {
        try {
            DataSource ds = (DataSource) InitialContext.doLookup("jdbc/aip");
            String sql = "insert into restaurant (id, restaurantname, address, website, lat, lng) values(?, ?, ?, ?, ?, ?)";
            try (Connection conn = ds.getConnection();
                    PreparedStatement ps = conn.prepareStatement(sql);) {
                ps.setString(1, res.getId());
                ps.setString(2, res.getName());
                ps.setString(3, res.getAddress());
                ps.setString(4, res.getWebsite());
                ps.setFloat(5, (float) res.getLat());
                ps.setFloat(6, (float) res.getLng());
                ps.executeQuery();
            } catch (SQLException ex) {
                Logger.getLogger(RestaurantDAO_JavaDB_Impl.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (NamingException ex) {
            Logger.getLogger(RestaurantDAO_JavaDB_Impl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public RestaurantDTO retreive(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(RestaurantDTO restaurant) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<RestaurantDTO> retreivAll() {
        return restaurants;
    }
    
}
