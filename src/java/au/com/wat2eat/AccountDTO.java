package au.com.wat2eat;

import java.io.Serializable;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

/**
 * Account data transfer object
 * represents a single user account stored in the datasource
 * @author garysnmb
 */
public class AccountDTO implements Serializable{
    private String id;
    private String password;
    private String gender;
    private int age;
    private String nationality;
    
    /**
     * get the id of the account
     * @return string id of the account
     */
    @Size(min=6, max=20, message="id must be between 6 and 20 characters")
    public String getId() {
        return id;
    }
    
    /**
     * set the id to the new value of the account
     * @param id - string, must be between 6-20 characters
     */
    public void setId(String id) {
        this.id = id;
    }
    
    /**
     * get the password of the user
     * @return password string
     */
    @Size(min=6, max=20, message="password must be between 6 and 20 characters")
    public String getPassword() {
        return password;
    }
    
    /**
     * set the password to the new value
     * @param password - string size of 6 - 20 characters
     */
    public void setPassword(String password) {
        this.password = password;
    }
    
    /**
     * get the gender of the user
     * @return either "M" or "F"
     */
    public String getGender() {
        return gender;
    }
    
    /**
     * set the gender to the new value
     * @param gender - M or F
     */
    public void setGender(String gender) {
        this.gender = gender;
    }
    
    /**
     * get the age of the user
     * @return age of the user
     */
    @Min(10)
    @Max(120)
    public int getAge() {
        return age;
    }
    
    /**
     * set the age to new value
     * @param age - integer between 10 and 120
     */
    public void setAge(int age) {
        this.age = age;
    }
    
    /**
     * get the nationality of the user
     * @return user's nationality
     */
    public String getNationality() {
        return nationality;
    }
    
    /**
     * set the nationality to the new value
     * @param nationality - string of the nationality
     */
    public void setNationality(String nationality) {
        this.nationality = nationality;
    }
    
}
