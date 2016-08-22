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
    DataSource ds;
    
    public RestaurantDAO_JavaDB_Impl() throws NamingException {
        ds = (DataSource) InitialContext.doLookup("jdbc/aip");
    }
    
    @Override
    public void create(RestaurantDTO res) {
        String sql = "insert into w.restaurant (restaurantname, address, rating, website, lat, lng) "
                + "values(?, ?, ?, ?, ?, ?)";
        try (Connection conn = ds.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql);) {
            ps.setString(1, res.getName());
            ps.setString(2, res.getAddress());
            ps.setInt(3, res.getRating());
            ps.setString(4, res.getWebsite());
            ps.setFloat(5, (float) res.getLat());
            ps.setFloat(6, (float) res.getLng());
            ps.execute();
            
        } catch (SQLException ex) {
            Logger.getLogger(RestaurantDAO_JavaDB_Impl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public RestaurantDTO retreive(int id) {
        String sql = "select * from w.restaurant where id=?";
        RestaurantDTO res = new RestaurantDTO();
        try (Connection conn = ds.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql);){
            ps.setInt(1, id);
            
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                res.setId(id);
                res.setName(rs.getString("restaurantname"));
                res.setAddress(rs.getString("address"));
                res.setRating(rs.getInt("rating"));
                res.setWebsite(rs.getString("website"));
                res.setLat(rs.getFloat("lat"));
                res.setLng(rs.getFloat("lng"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(RestaurantDAO_JavaDB_Impl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;
    }

    @Override
    public void update(RestaurantDTO res) {
        String sql = "update w.restaurant "
                + "set restaurantname=?, address=?, rating=?, website=?, lat=?, lng=? "
                + "where id=?";
        try (Connection conn = ds.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql);){
            ps.setString(1, res.getName());
            ps.setString(2, res.getAddress());
            ps.setInt(3, res.getRating());
            ps.setString(4, res.getWebsite());
            ps.setFloat(5, (float) res.getLat());
            ps.setFloat(6, (float) res.getLng());
            ps.setInt(7, res.getId());
            ps.execute();
            
        } catch (SQLException ex) {
            Logger.getLogger(RestaurantDAO_JavaDB_Impl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(int id) {
        String sql = "delete from w.restaurant "
                + "where id=?";
        try (Connection conn = ds.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql);) {
            ps.setInt(1, id);
            ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(AccountDAO_JavaDB_Impl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public ArrayList<RestaurantDTO> retreivAll() {
        ArrayList<RestaurantDTO> results = new ArrayList<>();
        String sql = "select * from w.restaurant";
        try (Connection conn = ds.getConnection();
                Statement stat = conn.createStatement();
                ResultSet rs = stat.executeQuery(sql)) {
            while (rs.next()) {
                RestaurantDTO res = new RestaurantDTO();
                res.setId(rs.getInt("id"));
                res.setName(rs.getString("restaurantname"));
                res.setAddress(rs.getString("address"));
                res.setRating(rs.getInt("rating"));
                res.setWebsite(rs.getString("website"));
                res.setLat(rs.getFloat("lat"));
                res.setLng(rs.getFloat("lng"));
                results.add(res);
            }
        } catch (SQLException ex) {
            Logger.getLogger(RestaurantDAO_JavaDB_Impl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return results;
    }
    
}
