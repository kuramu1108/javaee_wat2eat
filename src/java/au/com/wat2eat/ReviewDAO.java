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
public interface ReviewDAO {
    public void create(ReviewDTO review);
    public ReviewDTO retrieve(int id);
    public void update(ReviewDTO review);
    public void delete(int id);
    public ArrayList<ReviewDTO> retrieveAll();
}
