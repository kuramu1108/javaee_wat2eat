/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package au.com.wat2eat;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author garysnmb
 */
@Named
@RequestScoped
public class AccountController {
    private String id;
    private String password;
}
