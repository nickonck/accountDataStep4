/* Application developed for AW subject, belonging to passive operations
 group.*/

package es.unileon.ulebank.client;


/**
 *Class tha provides the basic gestion data of a client in a bank
 * 
 * @author Gonzalo Nicolas Barreales
 */
public class Client {
    
    /**
     * Identifier of the client
     */
    private String dni;
    
    /**
     * Accounts where the client appear
     */
    private String name;
    
    /**
     * Constructor of client. Receive the id and initilize the list of accounts
     * 
     * @param clientHandler 
     */
    public Client(){
        
    }

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
    
    
}
