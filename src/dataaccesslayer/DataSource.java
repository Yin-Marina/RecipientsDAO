
package dataaccesslayer;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * <p>
 * This is the demo class that implements a business logic object for CST8288-Object Oriented Programming with design patterns(Java) Lab 2.
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
 * This class provides a single connection for this application, to prevent memory leaks.
 * </p>
 *
 */

public class DataSource {
	private Connection connection = null;
	
        /**
        Default constructor for DataSource class.
        */
	public DataSource(){}
        
        
        /**
        * createConnection is a method that creates a database connection using JDBC.
        * <p>
        * The method reads database connection properties from a properties file named "database.properties" located in the "src" directory.
        * The properties include the JDBC URL, username, and password, which are used to establish the connection with the database.
        * If a connection already exists, a message will be printed indicating that a new connection cannot be created.
        * In case of any exceptions, the method prints the stack trace of the exception.
        *
        * @return a java.SQL.Connection object representing the database connection.
        */
	public Connection createConnection() throws ClassNotFoundException{
            // added use of Properties and try-with-resources - kriger
            Properties props = new Properties();

		try (InputStream in = Files.newInputStream(Paths.get("src/database.properties"));) {
			props.load(in);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}// catch()

	    String url = props.getProperty("jdbc.url");
	    String username = props.getProperty("jdbc.username");
	    String password = props.getProperty("jdbc.password");
		try {
			if(connection != null){
				System.out.println("Cannot create new connection, one exists already");
			}
			else{
                            Class.forName("com.mysql.cj.jdbc.Driver");
				connection = DriverManager.getConnection(url, username, password);
			}
		}
		catch(SQLException ex){
                    ex.printStackTrace();
		}
		return connection;
	}
}