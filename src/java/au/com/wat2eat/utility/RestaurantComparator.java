/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package au.com.wat2eat.utility;

import au.com.wat2eat.RestaurantDTO;
import java.util.Comparator;
/**
 *
 * @author mac
 */
public class RestaurantComparator implements Comparator<RestaurantDTO> {

    @Override
    public int compare(RestaurantDTO o1, RestaurantDTO o2) {
        if (o1.getRating() > o2.getRating())
            return -1;
        else if (o1.getRating() == o2.getRating())
            return 0;
        else
            return 1;
    }
}
