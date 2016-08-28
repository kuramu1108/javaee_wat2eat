package au.com.wat2eat.utility;

import au.com.wat2eat.RestaurantDTO;
import java.util.Comparator;
/**
 * Restaurant Comparator used to compare the ranking of the restaurants
 * @author mac
 */
public class RestaurantComparator implements Comparator<RestaurantDTO> {

    /**
     * compare function implementation
     * if used by sort function, would sort from high to low
     * @param o1 - restaurant 1
     * @param o2 - restaurant 2
     * @return intger result of comparison
     */
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
