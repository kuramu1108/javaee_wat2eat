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
 * RestaurantDAO JavaDB implementation
 * @author garysnmb
 */
public class RestaurantDAO_JavaDB_Impl implements RestaurantDAO {
    DataSource ds;
    
    /**
     * Initialize the data source to be used
     * @throws NamingException 
     */
    public RestaurantDAO_JavaDB_Impl() throws NamingException {
        ds = (DataSource) InitialContext.doLookup("jdbc/aip");
    }
    
    @Override
    public void create(RestaurantDTO res) {
        String sql = "insert into w.restaurant (restaurantname, address, website, lat, lng) "
                + "values(?, ?, ?, ?, ?)";
        try (Connection conn = ds.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql);) {
            ps.setString(1, res.getName());
            ps.setString(2, res.getAddress());
            ps.setString(3, res.getWebsite());
            ps.setFloat(4, (float) res.getLat());
            ps.setFloat(5, (float) res.getLng());
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
            
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    res.setId(id);
                    res.setName(rs.getString("restaurantname"));
                    res.setAddress(rs.getString("address"));
                    res.setWebsite(rs.getString("website"));
                    res.setLat(rs.getFloat("lat"));
                    res.setLng(rs.getFloat("lng"));
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(RestaurantDAO_JavaDB_Impl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;
    }

    @Override
    public void update(RestaurantDTO res) {
        String sql = "update w.restaurant "
                + "set restaurantname=?, address=?, website=?, lat=?, lng=? "
                + "where id=?";
        try (Connection conn = ds.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql);){
            ps.setString(1, res.getName());
            ps.setString(2, res.getAddress());
            ps.setString(3, res.getWebsite());
            ps.setFloat(4, (float) res.getLat());
            ps.setFloat(5, (float) res.getLng());
            ps.setInt(6, res.getId());
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
    public ArrayList<RestaurantDTO> retrieveAll() {
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
