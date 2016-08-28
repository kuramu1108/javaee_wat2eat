package au.com.wat2eat;

import java.util.ArrayList;

/**
 * Review Data Access Object Interface
 * @author garysnmb
 */
public interface ReviewDAO {
    /**
     * add a new record of review to the data source
     * @param review - a new created ReviewDTO object
     */
    public void create(ReviewDTO review);
    
    /**
     * get the review with the specified id
     * @param id - reivew's unique identifier
     * @return a ReviewDTO object with data, or a new instance if account is not found
     */
    public ReviewDTO retrieve(int id);
    
    /**
     * update the record of the review
     * @param review - the review to be updated with new data
     */
    public void update(ReviewDTO review);
    
    /**
     * delete the record of review with the specified id in the data source
     * @param id - review's unique identifier
     */
    public void delete(int id);
    
    /**
     * get the list of review make to specific restaurant
     * @param id - the id of the restaurant
     * @return arraylist of ReviewDTO objects
     */
    public ArrayList<ReviewDTO> retrieveAllByRestaurant(int id);
    
    /**
     * get the list of review made by specific user 
     * @param id - the id of the user account
     * @return arraylist of ReviewDTO objects
     */
    public ArrayList<ReviewDTO> retreiveAllByUser(String id);
    
    /**
     * get the average rating of a specific restaurant
     * @param resId - the id of the restaurant
     * @return restaurant's average rating, floor to integer
     */
    public int getAverageRating(int resId);
}
