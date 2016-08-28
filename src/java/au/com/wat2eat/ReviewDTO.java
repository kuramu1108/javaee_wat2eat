package au.com.wat2eat;

import java.util.Date;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * the Review Data transfer object of the restaurant reviews
 * @author garysnmb
 */
public class ReviewDTO {
    private int id;
    @NotNull
    @Size(min=1, max=255, message ="Title must not be empty and not over 255 characters")
    private String title;
    private String comment;
    @Min(0)
    @Max(5)
    private int rating;
    private int restaurantId;
    private String userId;
    private Date reviewDate;
    
    /**
     * get the id of the review
     * @return the id of the review
     */
    public int getId() {
        return id;
    }

    /**
     * set id to new value
     * @param id - review's unique identifier
     */
    public void setId(int id) {
        this.id = id;
    }
    
    /**
     * get the title of the review
     * @return the title
     */
    public String getTitle() {
        return title;
    }
    
    /**
     * set title to new value
     * @param title - must not be null and not more than 255 characters
     */
    public void setTitle(String title) {
        this.title = title;
    }
    
    /**
     * get the comment of the review
     * @return comment, could be null
     */
    public String getComment() {
        return comment;
    }
    
    /**
     * set comment to new value
     * @param comment - comment made by user, could be null
     */
    public void setComment(String comment) {
        this.comment = comment;
    }

    /**
     * get the rating data of the review
     * @return the rating make by user, range from 0 to 5
     */
    public int getRating() {
        return rating;
    }

    /**
     * set rating to new value
     * @param rating - integer range from 0-5
     */
    public void setRating(int rating) {
        this.rating = rating;
    }

    /**
     * get the restaurant id that the review is made to
     * @return the id of the reviewed restaurant
     */
    public int getRestaurantId() {
        return restaurantId;
    }

    /**
     * set reviewed restaurant id to new value
     * @param restaurantId - reviewed resturant's id
     */
    public void setRestaurantId(int restaurantId) {
        this.restaurantId = restaurantId;
    }

    /**
     * get the user's id who make the review
     * @return the reviewer's account id
     */
    public String getUserId() {
        return userId;
    }

    /**
     * set the reviewer's id to new value
     * @param userId - user's account id
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * get the date when the reviewed was made
     * @return the date, in sql.Date format
     */
    public Date getReviewDate() {
        return reviewDate;
    }

    /**
     * set the reviewed date to new value
     * must be upate after editing
     * @param reviewDate - date of review, in sql.Date format
     */
    public void setReviewDate(Date reviewDate) {
        this.reviewDate = reviewDate;
    }
    
    
}
