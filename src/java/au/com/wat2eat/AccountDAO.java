package au.com.wat2eat;

/**
 * Account Data Access Object interface
 * @author garysnmb
 */
public interface AccountDAO {
    /**
     * add a new record of account to the data source
     * @param account - a new created AccountDTO object
     */
    public void create(AccountDTO account);
    
    /**
     * get the account with the specified id
     * @param id - account's unique identifier
     * @return a AccountDTO object with account data, or a new instance if account is not found
     */
    public AccountDTO retreive(String id);
    
    /**
     * update the record of the account
     * @param account - the account to be updated with new data
     */
    public void update(AccountDTO account);
    
    /**
     * delete the record of account with the specified id in the data source
     * @param id - account's unique identifier
     */
    public void delete(String id);
    
    /**
     * check whether the id is used
     * @param id - account's unique identifier
     * @return ture/false on whether it exist
     */
    public boolean exist(String id);
}
