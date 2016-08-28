package au.com.wat2eat;

import au.com.wat2eat.utility.RestaurantComparator;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Named;
import javax.enterprise.context.ApplicationScoped;
import javax.naming.NamingException;
/**
 * Controller of the main page, listing all the restaurants
 * @author garysnmb
 */
@Named
@ApplicationScoped
public class RestaurantController {
    
    /**
     * Retrive all the restaurants in the data source
     * @return arraylist of RestaurantDTO objects
     */
    public ArrayList<RestaurantDTO> getRestaurants() {
        RestaurantDAO resDao;
        ArrayList<RestaurantDTO> res;
        try {
            resDao = new RestaurantDAO_JavaDB_Impl();
            res = resDao.retrieveAll();
            ReviewDAO revDao = new ReviewDAO_JavaDB_Impl();
            for (RestaurantDTO restaurant: res) {
                restaurant.setRating(revDao.getAverageRating(restaurant.getId()));
            }
        } catch (NamingException ex) {
            Logger.getLogger(RestaurantController.class.getName()).log(Level.SEVERE, null, ex);
            res = new ArrayList<>();
        }
        return res;
    }
    
    /**
     * Randomly select 5 restaurants in the data source
     * @return arraylist of RestaurantDTO objects, sort by rating
     */
    public ArrayList<RestaurantDTO> getRandoms() {
        RestaurantDAO dao;
        ArrayList<RestaurantDTO> res = new ArrayList<>();
        try {
            dao = new RestaurantDAO_JavaDB_Impl();
            ArrayList<RestaurantDTO> all = dao.retrieveAll();
            ArrayList<Integer> ids = new ArrayList<>();
            int counter;
            for (counter = 0; counter < 5;) {
                int x = (int) Math.floor(Math.random() * all.size());
                if (!ids.contains(x)) {
                    ids.add(x);
                    counter++;
                }
            }
            ReviewDAO revDao = new ReviewDAO_JavaDB_Impl();
            for (int i = 0; i< ids.size();i++) {
                RestaurantDTO restaurant = dao.retreive(ids.get(i));
                restaurant.setRating(revDao.getAverageRating(restaurant.getId()));
                res.add(restaurant);
            }
            res.sort(new RestaurantComparator());
        } catch (NamingException ex) {
            Logger.getLogger(RestaurantController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;
    }
}
