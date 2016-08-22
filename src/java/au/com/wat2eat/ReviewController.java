/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package au.com.wat2eat;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.naming.NamingException;

/**
 *
 * @author mac
 */
@Named
@RequestScoped
public class ReviewController implements Serializable{
    
    private RestaurantDTO restaurant;
    
    public void loadRestaurant(int resId) {
        try {
            RestaurantDAO resDao = new RestaurantDAO_JavaDB_Impl();
            restaurant = resDao.retreive(resId);
        } catch (NamingException ex) {
            Logger.getLogger(ReviewController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public RestaurantDTO getRestaurant() {
        return restaurant;
    }
    
    public ArrayList<ReviewDTO> getAllReviews(int resId) {
        ArrayList<ReviewDTO> results = new ArrayList<>();
        
        return results;
    }
}