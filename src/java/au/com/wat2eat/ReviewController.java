/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package au.com.wat2eat;

import java.io.Serializable;
import java.util.ArrayList;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author mac
 */
@Named
@RequestScoped
public class ReviewController implements Serializable{
    public ArrayList<ReviewDTO> getAllReviews(int resId) {
        ArrayList<ReviewDTO> results = new ArrayList<>();
        
        return results;
    }
}