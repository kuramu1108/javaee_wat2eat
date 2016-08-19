/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package au.com.wat2eat;

import java.util.ArrayList;
import javax.inject.Named;
import javax.enterprise.context.ApplicationScoped;
/**
 *
 * @author garysnmb
 */
@Named
@ApplicationScoped
public class RestaurantController {
    public ArrayList<RestaurantDTO> getRestaurants() {
        RestaurantDAO dao = new RestaurantDAO_JavaDB_Impl();
        return dao.retreivAll();
    }
}
