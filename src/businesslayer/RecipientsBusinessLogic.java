
package businesslayer;

import java.util.List;
import dataaccesslayer.RecipientsDao;
import dataaccesslayer.RecipientsDaoImpl;
import transferobjects.RecipientDTO;
/**
 * <p>
 * This is the BusinessLogic class for CST8288-Object Oriented Programming with design patterns(Java) Lab 2.
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
 * This class is the Business Logic Class of the program.
 * </p>
 *
 */

public class RecipientsBusinessLogic {
	private static final int NAME_MAX_LENGTH = 30;
	private static final int CITY_MAX_LENGTH = 30;
        private static final int CATEGORY_MAX_LENGTH = 50;
	
	private RecipientsDao recipientsDao = null;
	
        /**
         * The method create a new recipientsDAOImpl object.
         */
	public RecipientsBusinessLogic(){
		recipientsDao = new RecipientsDaoImpl();
	}
	
        /**
         * This method creates a new list of all recipients within the table.
         * @return a list of all RecipientsDTO
         */
	public List<RecipientDTO> getAllRecipients(){
		return recipientsDao.getAllRecipients();
	}
	
        /**
         * This method returns a RecipientsDTO Object based on the integer awardID passed in.
         * @param awardID The awardID that needs to be passed.
         * @return The RecipientDTO with the awardID
         */
	public RecipientDTO getRecipients(Integer awardID){
		return recipientsDao.getRecipientByAwardId(awardID);
	}
	
        /**
         * Adds a recipient to the recipient database.
         *
         * @param recipient the recipient information to be added to the database
         * @throws ValidationException if the recipient information is invalid
         */
	public void addRecipient(RecipientDTO recipient) throws ValidationException{
		cleanRecipient(recipient);
		validateRecipient(recipient);
		recipientsDao.addRecipient(recipient);
	}
	
        /**
        * Updates a recipient in the recipient database.
        * 
        * @param recipient the updated recipient information to be stored in the database
        * @throws ValidationException if the updated recipient information is invalid
        */
	public void updateRecipient(RecipientDTO recipient) throws ValidationException{
		cleanRecipient(recipient);
		validateRecipient(recipient);
		recipientsDao.updateRecipient(recipient);
	}
	
        /**
        * Deletes a recipient from the recipient database.
        *
        * @param recipient The recipient to be deleted.
        */
	public void deleteRecipient(RecipientDTO recipient){
		recipientsDao.deleteRecipient(recipient);
	}
	
        /**
        * Cleans the recipient data by trimming leading and trailing whitespaces.
        *
        * @param recipient The recipient whose data needs to be cleaned.
        */
	private void cleanRecipient(RecipientDTO recipient){
		if(recipient.getName() != null){ 
			recipient.setName(recipient.getName().trim());
		}
                if(recipient.getCity() != null){ 
			recipient.setCity(recipient.getCity().trim());
		}
	}
	
        /**
        * Validates the recipient data and throws a ValidationException if any of the fields are invalid.
        *
        * @param recipient The recipient whose data needs to be validated.
        * @throws ValidationException If the recipient data is invalid.
        */
	private void validateRecipient(RecipientDTO recipient) throws ValidationException{
		validateString(recipient.getName(), "Name", NAME_MAX_LENGTH, true);
		validateString(recipient.getCity(), "City", CITY_MAX_LENGTH, true);
                validateString(recipient.getCategory(), "Category", CATEGORY_MAX_LENGTH, true);
	}
	
        
        /**
        * Validates a string field and throws a ValidationException if the field is invalid.
        *
        * @param value The value of the string field to be validated.
        * @param fieldName The name of the field being validated.
        * @param maxLength The maximum allowed length of the string field.
        * @param isNullAllowed Specifies whether the field is allowed to be null.
        * @throws ValidationException If the string field is invalid.
        */
	private void validateString(String value, String fieldName, int maxLength, boolean isNullAllowed)
	    throws ValidationException{
		if(value == null && isNullAllowed){
			// return; // null permitted, nothing to validate
		}
		else if(value == null && ! isNullAllowed){
		    throw new ValidationException(String.format("%s cannot be null", 
		    		fieldName));
		}
		else if(value.length() == 0){
			throw new ValidationException(String.format("%s cannot be empty or only whitespace", 
					fieldName));
		}
		else if(value.length() > maxLength){
			throw new ValidationException(String.format("%s cannot exceed %d characters", 
					fieldName, maxLength));
		}
	}
	
}
