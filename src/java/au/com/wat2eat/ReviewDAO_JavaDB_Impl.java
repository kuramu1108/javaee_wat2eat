/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package au.com.wat2eat;

import java.sql.Connection;
import java.sql.Date;
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
public class ReviewDAO_JavaDB_Impl implements ReviewDAO {
    private DataSource ds;
    
    public ReviewDAO_JavaDB_Impl() throws NamingException {
        ds = (DataSource) InitialContext.doLookup("jdbc/aip");
    }
    
    @Override
    public void create(ReviewDTO review) {
        String sql = "insert into w.review (title, comment, rating, restaurantid, userid, reviewdate) "
                + "values(?, ?, ?, ?, ?, ?)";
        try (Connection conn = ds.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql);) {
            ps.setString(1, review.getTitle());
            ps.setString(2, review.getComment());
            ps.setInt(3, review.getRating());
            ps.setInt(4, review.getRestaurantId());
            ps.setString(5, review.getUserId());
            ps.setDate(6, (Date) review.getReviewDate());
            ps.execute();
            
        } catch (SQLException ex) {
            Logger.getLogger(RestaurantDAO_JavaDB_Impl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public ReviewDTO retrieve(int id) {
        String sql = "select * from w.review where id=?";
        ReviewDTO rev = new ReviewDTO();
        try (Connection conn = ds.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql);) {
            ps.setInt(1, id);
            
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                rev.setId(rs.getInt("id"));
                rev.setTitle(rs.getString("title"));
                rev.setComment(rs.getString("comment"));
                rev.setRating(rs.getInt("rating"));
                rev.setRestaurantId(rs.getInt("restaurantid"));
                rev.setUserId(rs.getString("userid"));
                rev.setReviewDate(rs.getDate("reviewdate"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ReviewDAO_JavaDB_Impl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rev;
    }

    @Override
    public void update(ReviewDTO review) {
        String sql = "update w.review "
                + "set title=?, comment=?, rating=?, reviewdate=? "
                + "where id=?";
        try (Connection conn = ds.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql);) {
            ps.setString(1, review.getTitle());
            ps.setString(2, review.getComment());
            ps.setInt(3, review.getRating());
            ps.setDate(4, (Date) review.getReviewDate());
            ps.setInt(5, review.getId());
            
            ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(ReviewDAO_JavaDB_Impl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(int id) {
        String sql = "delete from w.review "
                + "where id=?";
        try (Connection conn = ds.getConnection();
                PreparedStatement ps =  conn.prepareStatement(sql);) {
            ps.setInt(1, id);
            ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(ReviewDAO_JavaDB_Impl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public ArrayList<ReviewDTO> retrieveAllByRestaurant(int id) {
        ArrayList<ReviewDTO> result = new ArrayList<>();
        String sql = "select * from w.review "
                + "where restaurantid=?";
        try (Connection conn = ds.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql);) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ReviewDTO rev = new ReviewDTO();
                rev.setId(rs.getInt("id"));
                rev.setTitle(rs.getString("title"));
                rev.setComment(rs.getString("comment"));
                rev.setRating(rs.getInt("rating"));
                rev.setRestaurantId(rs.getInt("restaurantid"));
                rev.setUserId(rs.getString("userid"));
                rev.setReviewDate(rs.getDate("reviewdate"));
                result.add(rev);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ReviewDAO_JavaDB_Impl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    
    @Override
    public ArrayList<ReviewDTO> retreiveAllByUser (String id) {
        ArrayList<ReviewDTO> result = new ArrayList<>();
        String sql = "select * from w.review "
                + "where userid=?";
        try (Connection conn = ds.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql);) {
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ReviewDTO rev = new ReviewDTO();
                rev.setId(rs.getInt("id"));
                rev.setTitle(rs.getString("title"));
                rev.setComment(rs.getString("comment"));
                rev.setRating(rs.getInt("rating"));
                rev.setRestaurantId(rs.getInt("restaurantid"));
                rev.setUserId(rs.getString("userid"));
                rev.setReviewDate(rs.getDate("reviewdate"));
                result.add(rev);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ReviewDAO_JavaDB_Impl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    
}
