/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package au.com.wat2eat;

/**
 *
 * @author garysnmb
 */
public interface ReviewDAO {
    public void createReview();
    public ReviewDAO retrieveReview(String id);
    public void updateReview(String id);
    public void deleteReview(String id);
}
