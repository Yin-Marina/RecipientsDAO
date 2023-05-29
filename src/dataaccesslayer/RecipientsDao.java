
package dataaccesslayer;

import java.util.List;

import transferobjects.RecipientDTO;

/**
 * <p>
 * This is the DAO interface class for CST8288-Object Oriented Programming with design patterns(Java) Lab 2.
 * </p>
 * <p>
 * This program demonstrate the DAO pattern used to manipulate the Recipients table in Ontario database.
 * </p>
 * 
 * <pre>
 * Class: CST8288 - Lab Section: 013
 * </pre>
 * 
 * <pre>
 * Lab Professor: Siju Philip
 * </pre>
 * 
 * <pre>
 * Date: Feb. 10, 2023
 * </pre>
 * 
 * @author Mutao Yin
 * @version 1.0
 * 
 * <p>
 * This class is the interface of DAO that provided the abstract method to be implemented by DAO implementation classes.
 * </p>
 *
 */
public interface RecipientsDao {
        /**
         * This abstract method is used to get all recipients.
         * @return list of RecipientDTO objects.
         */
	List<RecipientDTO> getAllRecipients();
	
        /**
         * This method returns the recipient based on the awardID provided.
         * @param awardID
         * @return The RecipientDTO with the given awardID
         */
	RecipientDTO getRecipientByAwardId(Integer awardID);
        
        /**
         * This method adds new row for recipient database.
         * @param recipient The RecipientDTO that needs to be added.
         */
	void addRecipient(RecipientDTO recipient);
        
        /**
         * This method updates the row within the recipient table.
         * @param recipient The RecipientDTO that needs update.
         */
	void updateRecipient(RecipientDTO recipient);
        
        /**
         * This method deletes one row within the table.
         * @param recipient The RecipientDTO that needs to be deleted.
         */
	void deleteRecipient(RecipientDTO recipient);
}
