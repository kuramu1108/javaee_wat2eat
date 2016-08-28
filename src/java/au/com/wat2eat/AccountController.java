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
 * Controller that incharge of the operation related to the current logged in user
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
    private final String REST = "detail?faces-redirect=true";
    
    /**
     * get the current logged in user's account data
     * @return AccountDTO object of the account
     */
    public AccountDTO getAccount() {
        return account;
    }
    
    /**
     * get the current review object, either a new one or loaded one
     * @return ReviewDTO object of the current review
     */
    public ReviewDTO getReview() {
        return editReview;
    }
    
    /**
     * load the reivew object from review DAO
     * @param id - the unique id of the review record, in Integer
     * @throws NamingException 
     */
    public void loadReview(int id) throws NamingException {
        editReview = new ReviewDAO_JavaDB_Impl().retrieve(id);
        rating = editReview.getRating();
    }
    
    /**
     * get the current rating value, used by primefaces' rating tag
     * @return current rating in Integer
     */
    public Integer getRating() {
        return rating;
    }
    
    /**
     * set the rating value, used by primefaces' rating tag
     * @param rating - new rating, range from 0- 5
     */
    public void setRating(Integer rating) {
        this.rating = rating;
    }
    
    /**
     * update current review in database by passing the DTO to DAO
     * @return redirection of the page, to restaurant's detaul page
     * @throws NamingException 
     */
    public String updateReview() throws NamingException {
        editReview.setReviewDate(java.util.Calendar.getInstance().getTime());
        editReview.setRating(rating);
        new ReviewDAO_JavaDB_Impl().update(editReview);
        return REST + "&resId=" + editReview.getRestaurantId();
    }
    
    /**
     * delete the current review
     * @return redirection of the page, to userpage
     * @throws NamingException 
     */
    public String deleteReview() throws NamingException {
        new ReviewDAO_JavaDB_Impl().delete(editReview.getId());
        return USERPAGE;
    }
    
    /**
     * user login method, make use of JavaEE authentication built in GlassFish
     * @return page redirection, stay at same page if login fail, otherwise direct to userpage
     */
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
    
    /**
     * user logout method, also invalidate the current user session
     * @return page redirection, direct to login page after logout
     */
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
    
    /**
     * get all the reviews made by the current user
     * @return an array list of ReviewDTO objects
     */
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
