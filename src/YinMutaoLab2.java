
import businesslayer.ValidationException;
/**
 * <p>
 * This is the main method for CST8288-Object Oriented Programming with design patterns(Java) Lab 2.
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
 * This class is the main class within the pattern and creates the business object
 * that display all rows within the table, the metadata about the table and add, 
 * alter, and delete one test row within the database..
 * </p>
 *
 */

public class YinMutaoLab2 {
        /**
         * This is the main method that create a AddDeleteDemo object, 
         * calling the demo method within the object and conduct database manipulation.
         * @param args arguments passed from command line
         * @throws ValidationException If the data cannot be validated.
         */
	public static void main(String[] args) throws ValidationException {
		 (new AddDeleteDemo()).demo();
	}
}