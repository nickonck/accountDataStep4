package es.unileon.ulebank.account;

import es.unileon.ulebank.client.Client;
import es.unileon.ulebank.handler.Handler;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.apache.log4j.Logger;

/**
 *
 * @author 
 */
@Entity
@Table(name="accounts")
public class Account implements Serializable{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
     * The logger of the class
     */
    private static final Logger LOG = Logger.getLogger(Account.class.getName());

    /**
     * The account identifier
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private BigInteger id;
    
    @OneToOne
    @JoinColumn(name = "id")
    private AccountHandler accountHandler;

    /**
     * The account balance
     */
    private double balance;
    /**
     * The account titulars
     */
    @OneToMany (mappedBy="account")
    private List<Client> titulars;


    /**
     * The max account's overdraft ( in positive )
     */
    private double maxOverdraft;

    /**
     * Create a new account
     *
     * @param office (The office of the account)
     *
     * @param bank ( The bank of the office )
     *
     * @param accountnumber (the accountNumber)
     * @param authorized
     *
     * @throws es.unileon.ulebank.handler.MalformedHandlerException
     * @throws es.unileon.ulebank.history.conditions.WrongArgsException
     *
     */

    public Account(){
    	this.titulars = new ArrayList<Client>();
    }
    
    

    public BigInteger getId() {
		return id;
	}



	public void setId(BigInteger id) {
		this.id = id;
	}



	/**
     * Set the max account's overdraft
     *
     * @param maxOverdraft ( the account's overdraft ( in positive ))
     * @return ( true if succes, false otherwise)
     */
    public boolean setMaxOverdraft(double maxOverdraft) {
        if (maxOverdraft >= 0) {
            LOG.info("Change max overdraft to " + maxOverdraft + "\n");
            this.maxOverdraft = maxOverdraft;
            return true;
        }
        return false;
    }

    /**
     *
     * Add a new titular. The client cannot be repeated, that is, two titulars
     * cannot have the same id, because its id is unique. If we try to add a
     * person that is already added the method return false.
     *
     * @param client ( client to add)
     *
     * @return ( true if success, else false )
     */
    public boolean addTitular(Client titular) {
        boolean found = false;
        if (titular == null || titular.getDni() == null) {
            found = true;
        } else {
            int i = 0;
            while (i < this.titulars.size() && !found) {
                if (this.titulars.get(i++).getDni().compareTo(titular.getDni()) == 0) {
                    found = true;
                }
            }
            if (!found) {
                LOG.info(("Add new titular " + titular.getDni()));
                this.titulars.add(titular);
            } else {
                LOG.error("Cannot add the titular " + titular.getDni().toString() + " , the titular already exists");
            }
        }
        return !found;
    }
    
    public void setTitulars(List<Client> titulars){
    	this.titulars=titulars;
    }

    /**
     *
     * Delete a titular. If the titular hadn't been added, the method return
     * false.
     *
     * @see es.unileon.ulebank.handler.Handler}.
     *
     * @param id ( The client id )
     *
     * @return ( true if success, false otherwise )
     */
    public boolean deleteTitular(String dni) {
        boolean found = false;
        int i = 0;
        StringBuilder err = new StringBuilder();
        if (this.titulars.size() <= 1) {
            err.append("Error, the account must have at least one titular\n");
        } else {
            while (i < this.titulars.size() && !found) {
                if (this.titulars.get(i).getDni().compareTo(dni) == 0) {
                    LOG.info("Delete " + dni.toString() + " titular");
                    this.titulars.remove(i);
                    found = true;
                }
                i++;
            }
            if (!found) {
                err.append("Cannot remove the titular ").append(id.toString()).append(" because it doesn't exist");
            }
        }
        if (err.length() > 1) {
            found = false;
            LOG.error(err);
        }
        return found;
    }


   /**
     * Get the account titulars
     *
     * @return ( The titulars )
     */
    public List<Client> getTitulars() {
        return new ArrayList<Client>(this.titulars);
    }


    /**
     * Get the account's balance
     *
     * @return (the balance)
     *
     * @author runix
     */
    public final double getBalance() {
        return this.balance;
    }

    /**
     * Get the max account's overdraft
     *
     * @return (the account's overdraft )
     */
    public double getMaxOverdraft() {
        return this.maxOverdraft;
    }

    /**
     * Get the account ID
     *
     * @return (the account id)
     * @author runix
     */
    public final AccountHandler getAccountHandler() {
        return this.accountHandler;
    }
    
    public void setAccountHandler(AccountHandler accountHandler){
    	this.accountHandler=(AccountHandler)accountHandler;
    }
    
    public int titularsSize(){
    	return titulars.size();
    }
    
    public boolean existsTitular(String dni){
    	boolean exists=false;
    	int i=0;
    	while(!exists && i<titulars.size()){
    		if(titulars.get(i).getDni().compareTo(dni)==0){
    			exists=true;
    		}
    		i++;
    	}
    	return exists;
    }

}
