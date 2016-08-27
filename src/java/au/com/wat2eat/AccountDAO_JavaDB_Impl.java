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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 *
 * @author garysnmb
 */
public class AccountDAO_JavaDB_Impl implements AccountDAO { 
    DataSource ds;
    
    public AccountDAO_JavaDB_Impl () throws NamingException {
        ds = (DataSource) InitialContext.doLookup("jdbc/aip");
    }
    
    @Override
    public void create(AccountDTO account) {
        String sql = "insert into w.account (id, password, gender, age, nationality) "
                + "values (?, ?, ?, ?, ?)";
        try (Connection conn = ds.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql);) {
            ps.setString(1, account.getId());
            ps.setString(2, account.getPassword());
            ps.setString(3, account.getGender());
            ps.setInt(4, account.getAge());
            ps.setString(5, account.getNationality());
            ps.execute();
            
        } catch (SQLException ex) {
            Logger.getLogger(AccountDAO_JavaDB_Impl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public AccountDTO retreive(String id) {
        String sql = "select * from w.account where id=?";
        AccountDTO result = new AccountDTO();
        try (Connection conn = ds.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql);) {
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                result.setId(id);
                result.setPassword(rs.getString("password"));
                result.setGender(rs.getString("gender"));
                result.setAge(rs.getInt("age"));
                result.setNationality(rs.getString("nationality"));
            }
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(AccountDAO_JavaDB_Impl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    @Override
    public void update(AccountDTO account) {
        String sql = "update w.account "
                + "set password=?, gender=?, age=?, nationality=? "
                + "where id=?";
        try (Connection conn = ds.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql);) {
            ps.setString(1, account.getPassword());
            ps.setString(2, account.getGender());
            ps.setInt(3, account.getAge());
            ps.setString(4, account.getNationality());
            ps.setString(5, account.getId());
            ps.execute();
            
        } catch (SQLException ex) {
            Logger.getLogger(AccountDAO_JavaDB_Impl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(String id) {
        String sql = "delete from w.account "
                + "where id=?";
        try (Connection conn = ds.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql);) {
            ps.setString(1, id);
            ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(AccountDAO_JavaDB_Impl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public boolean exist(String id) {
        String sql = "select id from w.account "
                + "where id=?";
        boolean exist = false;
        try (Connection conn = ds.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql);) {
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next())
                exist = true;
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(AccountDAO_JavaDB_Impl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return exist;
    }
    
}
