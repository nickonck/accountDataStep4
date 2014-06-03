/* Application developed for AW subject, belonging to passive operations
 group.*/
package es.unileon.ulebank.account;

import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import es.unileon.ulebank.handler.Handler;


/**
 *
 * @author 
 */
@Entity
@Table(name="accountHandlers")
public class AccountHandler implements Handler {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static final String SEPARATOR = "-";
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Id")
    private BigInteger id;
    
	/**
     * The account number, the number of digits of this number is given by {
     *
     * @see ACCOUNT_NUMBER_LENGHT}
     */
    private String accountNumber;

    /**
     * The office identifier
     */
    private String office;
    /**
     * The bank identifier
     */
    private String bank;
    /**
     * The control digits
     */
    private String dc;


    public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getDc() {
		return dc;
	}

	public void setDc(String dc) {
		this.dc = dc;
	}

	public void setOffice(String officeHandler) {
		this.office= officeHandler;
	}

	public void setBank(String bank) {
		this.bank = bank;
	}

	/**
     *
     * @param another
     * @throws MalformedHandlerException
     */
    public AccountHandler(){
        
    }

    @Override
    public int compareTo(Handler another) {
        return this.toString().compareTo(another.toString());
    }

    
    
    public BigInteger getId() {
		return id;
	}

	public void setId(BigInteger id) {
		this.id = id;
	}

	/**
     *
     * @return
     */
    @Override
    public String toString() {
        return bank + SEPARATOR + office + SEPARATOR + dc + SEPARATOR + accountNumber;
    }
}
