
package businesslayer;

/**
 * <p>
 * This is the ValidationException class for CST8288-Object Oriented Programming with design patterns(Java) Lab 2.
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
 * This class is the ValidationException that inherited from Exception class. It will
 * throw a message when the data is not passing the validation test.
 * </p>
 *
 */
public class ValidationException extends Exception {
	
        /**
         * This method throws the following message: "Data not in valid format"
         */
	public ValidationException(){
		super("Data not in valid format");
	}
	/**
         * This method will take the String as a parameter and output the String message when the Exception is caught.
         * @param message The message that is going to be thrown when the validation Exception is caught.
         */
	public ValidationException(String message){
		super(message);
	}
	/**
         *  This method will take the String and a Throwable as a parameter and output the String message when the Exception is caused by the throwable.
         * @param message The message that is going to be thrown when the throwable is caught.
         * @param throwable The throwable that this exception react to.
         */
	public ValidationException(String message, Throwable throwable){
		super(message, throwable);
	}
	/**
         * This method will take a Throwable as a parameter and catch the throwable.
         * @param throwable The throwable that this exception react to.
         */
	public ValidationException(Throwable throwable){
		super(throwable);
	}
}
