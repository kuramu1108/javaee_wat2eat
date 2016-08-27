/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package au.com.wat2eat;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author garysnmb
 */
@Named
@SessionScoped
public class AccountController implements Serializable {
    private AccountDTO account = new AccountDTO();
    private ReviewDTO editReview;
    private Integer rating;
    private final String LOGOUT = "login?faces-redirect=true";
    private final String USERPAGE = "userpage?faces-redirect=true";
    
    public AccountDTO getAccount() {
        return account;
    }
    
    public ReviewDTO getReview() {
        return editReview;
    }
    
    public void loadReview(int id) throws NamingException {
        editReview = new ReviewDAO_JavaDB_Impl().retrieve(id);
        rating = editReview.getRating();
    }
    
    public Integer getRating() {
        return rating;
    }
    
    public void setRating(Integer rating) {
        this.rating = rating;
    }
    
    public String updateReview() throws NamingException {
        // need to add required fields
        editReview.setReviewDate(java.util.Calendar.getInstance().getTime());
        editReview.setRating(rating);
        new ReviewDAO_JavaDB_Impl().update(editReview);
        return USERPAGE;
    }
    
    public String deleteReview() throws NamingException {
        new ReviewDAO_JavaDB_Impl().delete(editReview.getId());
        return USERPAGE;
    }
    
    public String login() {
        FacesContext context = FacesContext.getCurrentInstance();
        HttpServletRequest req = (HttpServletRequest) context.getExternalContext().getRequest();
        try {
            req.login(account.getId(), account.getPassword());
        } catch (ServletException e) {
            context.addMessage("loginresult", new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR!",e.getMessage()));
            return null;
        }
        return USERPAGE;
    }    
    
    public String logout() {
        FacesContext context = FacesContext.getCurrentInstance();
        HttpServletRequest request = (HttpServletRequest)context.getExternalContext().getRequest();
        try {
            request.logout();
            request.getSession().invalidate();
        } catch (ServletException e) {
            // (you could also log the exception to the server log)
            context.addMessage(null, new FacesMessage(e.getMessage()));
        }
        return LOGOUT;
    }
    
    public ArrayList<ReviewDTO> getAllReviews() {
        ArrayList<ReviewDTO> result;
        
        try {
            ReviewDAO dao = new ReviewDAO_JavaDB_Impl();
            result = dao.retreiveAllByUser(account.getId());
        } catch (NamingException ex) {
            Logger.getLogger(AccountController.class.getName()).log(Level.SEVERE, null, ex);
            result = new ArrayList<>();
        }
        return result;
    }
}
