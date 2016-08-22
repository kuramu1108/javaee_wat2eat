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
import org.primefaces.model.map.DefaultMapModel;
import org.primefaces.model.map.LatLng;
import org.primefaces.model.map.MapModel;
import org.primefaces.model.map.Marker;

/**
 *
 * @author mac
 */
@Named
@RequestScoped
public class DetailController implements Serializable{
    
    private RestaurantDTO restaurant;    
    private MapModel mapModel;
    
    public void loadRestaurant(int resId) {
        try {
            RestaurantDAO resDao = new RestaurantDAO_JavaDB_Impl();
            restaurant = resDao.retreive(resId);
            mapModel = new DefaultMapModel();
            
            LatLng coord = new LatLng(restaurant.getLat(), restaurant.getLng());
            mapModel.addOverlay(new Marker(coord, restaurant.getName()));
        } catch (NamingException ex) {
            Logger.getLogger(DetailController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public RestaurantDTO getRestaurant() {
        return restaurant;
    }
    
    public MapModel getMapModel() {
        return mapModel;
    }
    
    public boolean hasWebsite() {
        return !restaurant.getWebsite().equals("undefined");
    }
    
    public ArrayList<ReviewDTO> getRestaurantsReviews() {
        ArrayList<ReviewDTO> results;
        try {
            ReviewDAO dao = new ReviewDAO_JavaDB_Impl();
            results = dao.retrieveAllByRestaurant(restaurant.getId());
        } catch (NamingException ex) {
            Logger.getLogger(DetailController.class.getName()).log(Level.SEVERE, null, ex);
            results = new ArrayList<>();
        }
        return results;
    }
    
    public boolean currentUser(String reviewer, String current) {
        if (reviewer.equals(current))
            return true;
        else
            return false;
    }
}