/* Application developed for AW subject, belonging to passive operations
 group.*/
package es.unileon.ulebank.handler;

import java.io.Serializable;

/**
 * Handler pattern.
 * @author runix
 */
public interface Handler extends Serializable{

    /**
     * Compare the actual handler with another
     *
     * @param another ( Handler to compare )
     * @return (0 if are equals, != 0 otherwise )
     */
    public int compareTo(Handler another);

    /**
     *
     * @return
     */
    @Override
    public String toString();
}
