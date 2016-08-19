/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package au.com.wat2eat;

import java.sql.Connection;
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
    private ArrayList<ReviewDTO> reviews;
    private String dbuser = "aip";
    private String dbpass = "aip";
    
    public ReviewDAO_JavaDB_Impl() {
        reviews = new ArrayList<>();
        try {
            DataSource ds = (DataSource) InitialContext.doLookup("jdbc/aip");
            String sqlquery = "select * from review";
            try (Connection conn = ds.getConnection();
                    Statement stat = conn.createStatement();
                    ResultSet rs = stat.executeQuery(sqlquery);) {
                while (rs.next()) {
                    ReviewDTO review = new ReviewDTO();
                    
                }
            } catch (SQLException ex) {
                Logger.getLogger(ReviewDAO_JavaDB_Impl.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (NamingException ex) {
            Logger.getLogger(ReviewDAO_JavaDB_Impl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @Override
    public void createReview() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ReviewDAO retrieveReview(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateReview(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteReview(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
