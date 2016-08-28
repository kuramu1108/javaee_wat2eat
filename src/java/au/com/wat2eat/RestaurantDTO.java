package au.com.wat2eat;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

/**
 * Restaurant Data Transfer Object class
 * stores the information of a restaurant
 * @author garysnmb
 */
public class RestaurantDTO {
    private int id;
    private String name;
    private String address;
    private String website;
    private int rating;
    private double lat;
    private double lng;
    
    /**
     * get the id of the restaurant
     * @return id of the restaurant
     */
    public int getId() {
        return id;
    }
    
    /**
     * set the id to new value
     * @param id - restaurant's id, in integer
     */
    public void setId(int id) {
        this.id = id;
    }
    
    /**
     * get the name of the restaurant
     * @return name of the restaurant
     */
    @Size(min=1, max=50)
    public String getName() {
        return name;
    }
    
    /**
     * set the name of the restaurant to new value
     * @param name - new value of the restaurant, must not more than 50 characters
     */
    public void setName(String name) {
        this.name = name;
    }
    
    /**
     * get the address of the restaurant
     * @return string of the address
     */
    public String getAddress() {
        return address;
    }
    
    /**
     * set the address to new value
     * @param address - String of the new address
     */
    public void setAddress(String address) {
        this.address = address;
    }
    
    /**
     * get the website url of the restaurant
     * if no website provided, undefined would be returned
     * @return URL or 'undefined'
     */
    public String getWebsite() {
        return website;
    }
    
    /**
     * set the website of the resutaurant
     * @param website - the url of th erestaurant's website
     */
    public void setWebsite(String website) {
        this.website = website;
    }
    
    /**
     * get the rating of the restaurant
     * @return rating, between 0-5
     */
    @Min(0)
    @Max(5)
    public int getRating() {
        return rating;
    }

    /**
     * set the rating of the restaurant
     * @param rating - rating, between 0-5 in integer
     */
    public void setRating(int rating) {
        this.rating = rating;
    }
    
    /**
     * get the latitude of the restaurant's geographic location
     * @return the latitude of the location, range from -90 to 90
     */
    @Min(-90)
    @Max(90)
    public double getLat() {
        return lat;
    }
    
    /**
     * set the latitude to new value
     * @param lat - restaurant location's latitude, range from -90 to 90
     */
    public void setLat(double lat) {
        this.lat = lat;
    }
    
    /**
     * get the longitude of the restaurant's geographic location
     * @return the longitude of the location, range from -180 to 180
     */
    @Min(-180)
    @Max(180)
    public double getLng() {
        return lng;
    }
    
    /**
     * set the longitude to new value
     * @param lng - restaurant location's longitude, range from -180 to 180
     */
    public void setLng(double lng) {
        this.lng = lng;
    }
    
}
