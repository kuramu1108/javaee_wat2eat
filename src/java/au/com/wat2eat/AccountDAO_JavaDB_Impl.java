/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package au.com.wat2eat;

import java.util.ArrayList;

/**
 *
 * @author garysnmb
 */
public class AccountDAO_JavaDB_Impl implements AccountDAO {
    private ArrayList<AccountDTO> accounts;
    
    public AccountDAO_JavaDB_Impl() {
        accounts = new ArrayList<>();
    }
    
    @Override
    public void create(AccountDTO account) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public AccountDTO retreive(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(AccountDTO account) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean exist(String id) {
        return false;
    }
    
}
