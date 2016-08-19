/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package au.com.wat2eat;

/**
 *
 * @author garysnmb
 */
public interface AccountDAO {
    public void create(AccountDTO account);
    public AccountDTO retreive(String id);
    public void update(AccountDTO account);
    public void delete(String id);
    public boolean exist(String id);
}
