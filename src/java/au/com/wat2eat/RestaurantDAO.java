/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package au.com.wat2eat;

import java.util.ArrayList;

/**
 * Restaurant Data Access Object Interface
 * @author garysnmb
 */
public interface RestaurantDAO {
    /**
     * add a new record of restaurant to the data source
     * @param restaurant - a new created RestaurantDTO object
     */
    public void create(RestaurantDTO restaurant);
    
    /**
     * get the restaurant with the specified id
     * @param id - restaurant's unique identifier
     * @return a RestaurantDTO object with  data, or a new instance if restaurant is not found
     */
    public RestaurantDTO retreive(int id);
    
    /**
     * update the record of the restaurant
     * @param restaurant - the restaurant to be updated with new data
     */
    public void update(RestaurantDTO restaurant);
    
    /**
     * delete the record of restaurant with the specified id in the data source
     * @param id - restaurant's unique identifier
     */
    public void delete(int id);
    
    /**
     * retrieve all the restaurant record in the data source
     * @return arraylist of RestaurantDTO objects
     */
    public ArrayList<RestaurantDTO> retrieveAll();
}
