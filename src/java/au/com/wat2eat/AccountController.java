/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package au.com.wat2eat;

import java.io.Serializable;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Named;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author garysnmb
 */
@Named
@RequestScoped
public class AccountController implements Serializable {
    private AccountDTO account = new AccountDTO();
    private final String REDIRECT = "welcome";
    public AccountDTO getAccount() {
        return account;
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
        return REDIRECT;
    }    
    
    public void logout() {
        FacesContext context = FacesContext.getCurrentInstance();
        HttpServletRequest request = (HttpServletRequest)context.getExternalContext().getRequest();
        try {
            request.logout();
        } catch (ServletException e) {
            // (you could also log the exception to the server log)
            context.addMessage(null, new FacesMessage(e.getMessage()));
        }
    }
}
