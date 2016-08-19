/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package au.com.wat2eat;

import java.util.Date;

/**
 *
 * @author garysnmb
 */
public class ReviewDTO {
    private String id;
    private String title;
    private String comment;
    private int rating;
    private String restaurantId;
    private String userId;
    private Date reviewedDate;
    
    public ReviewDTO() {
        
    }
}
