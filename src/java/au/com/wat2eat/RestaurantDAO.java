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
public interface RestaurantDAO {
    public void create(RestaurantDTO restaurant);
    public RestaurantDTO retreive(String id);
    public void update(RestaurantDTO restaurant);
    public void delete(String id);
    public ArrayList<RestaurantDTO> retreivAll();
}
