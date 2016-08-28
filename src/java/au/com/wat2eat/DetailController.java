package au.com.wat2eat;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.naming.NamingException;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import org.primefaces.model.map.DefaultMapModel;
import org.primefaces.model.map.LatLng;
import org.primefaces.model.map.MapModel;
import org.primefaces.model.map.Marker;

/**
 * Controller for the detail information of a restaurant
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
    
    /**
     * load the RestaurantDTO object to the restaurant variable
     * set the rating of the restaurant by calculting the reviews
     * create the google map model and add the marker
     * @param resId - id of the restaurant
     */
    public void loadRestaurant(int resId) {
        try {
            RestaurantDAO resDao = new RestaurantDAO_JavaDB_Impl();
            restaurant = resDao.retreive(resId);
            restaurant.setRating(new ReviewDAO_JavaDB_Impl().getAverageRating(restaurant.getId()));
            
            mapModel = new DefaultMapModel();

            LatLng coord = new LatLng(restaurant.getLat(), restaurant.getLng());
            mapModel.addOverlay(new Marker(coord, restaurant.getName()));
        } catch (NamingException ex) {
            Logger.getLogger(DetailController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * load the current logged in account
     * initialize a new ReviewDTO object
     * initialize rating
     * @param id - id of the current user
     */
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
    
    /**
     * get the current restaurant
     * @return RestaurantDTO object of the current restaurant
     */
    public RestaurantDTO getRestaurant() {
        return restaurant;
    }
    
    /**
     * get the new create review
     * @return ReviewDTO object being created
     */
    public ReviewDTO getReview() {
        return newReview;
    }
    
    /**
     * get the current rating value
     * @return rating value
     */
    @Min(0)
    @Max(5)
    public Integer getRating() {
        return rating;
    }
    
    /**
     * set the rating to new value
     * @param rating - integer range 0-5
     */
    public void setRating(Integer rating) {
        this.rating = rating;
    }
    
    /**
     * get the map model of google map
     * @return MapModel object
     */
    public MapModel getMapModel() {
        return mapModel;
    }
    
    /**
     * get all the reviews of the current restaurant
     * @return Arraylist of ReviewDTO objects
     */
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
    
    /**
     * submit the review and create the record into data source
     * userid, rating, restaurantid and reviewdate are added before inserting
     * @return page redirection to user's page
     * @throws NamingException 
     */
    public String submitReview() throws NamingException {
        newReview.setUserId(current.getId());
        newReview.setRating(rating);
        newReview.setRestaurantId(restaurant.getId());

        newReview.setReviewDate(java.util.Calendar.getInstance().getTime());
        
        new ReviewDAO_JavaDB_Impl().create(newReview);
        return "userpage?faces-redirect=true";
    }
}