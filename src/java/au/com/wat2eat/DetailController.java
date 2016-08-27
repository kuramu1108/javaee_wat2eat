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
import javax.enterprise.context.SessionScoped;
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
@SessionScoped
public class DetailController implements Serializable{
    private ReviewDTO newReview;
    private Integer rating;
    private RestaurantDTO restaurant;
    private AccountDTO current;
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
    
    public void loadAccount(String id) {
        try {
            AccountDAO accDao = new AccountDAO_JavaDB_Impl();
            if (id != null) {
                current = accDao.retreive(id);
                newReview = new ReviewDTO();
                rating = 0;
            }
        } catch (NamingException ex) {
            Logger.getLogger(DetailController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public RestaurantDTO getRestaurant() {
        return restaurant;
    }
    
    public ReviewDTO getReview() {
        return newReview;
    }
    
    public Integer getRating() {
        return rating;
    }
    
    public void setRating(Integer rating) {
        this.rating = rating;
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
    
    public String submitReview() throws NamingException {
        newReview.setUserId(current.getId());
        newReview.setRating(rating);
        newReview.setRestaurantId(restaurant.getId());

        newReview.setReviewDate(java.util.Calendar.getInstance().getTime());
        
        new ReviewDAO_JavaDB_Impl().create(newReview);
        return "userpage?faces-redirect=true";
    }
}