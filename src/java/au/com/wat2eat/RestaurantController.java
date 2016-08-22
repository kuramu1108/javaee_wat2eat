/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package au.com.wat2eat;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Named;
import javax.enterprise.context.ApplicationScoped;
import javax.naming.NamingException;
/**
 *
 * @author garysnmb
 */
@Named
@ApplicationScoped
public class RestaurantController {
    
    public ArrayList<RestaurantDTO> getRestaurants() {
        RestaurantDAO dao;
        ArrayList<RestaurantDTO> res;
        try {
            dao = new RestaurantDAO_JavaDB_Impl();
            res = dao.retreivAll();
        } catch (NamingException ex) {
            Logger.getLogger(RestaurantController.class.getName()).log(Level.SEVERE, null, ex);
            res = new ArrayList<>();
        }
        return res;
    }
}
