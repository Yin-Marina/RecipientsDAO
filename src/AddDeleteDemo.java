
import businesslayer.RecipientsBusinessLogic;
import businesslayer.ValidationException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;
import transferobjects.RecipientDTO;

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
 * This class that demos the display table content, table metadata, add one row, update one row, and delete one row using DAO design pattern.
 * </p>
 *
 */
public class AddDeleteDemo {

    /**
     * This program displays all rows within the table, displays column metadata, adds one row, updates one row and deletes it.
     * @throws ValidationException  Throws validation exception if the data is not validated.
     */
    public void demo() throws ValidationException {
        Connection connection = null; // manages connection
        Statement statement = null; // query statement
        ResultSet resultSet = null; // manages results

        Properties props = new Properties();
        InputStream in = null;
        try {
            in = Files.newInputStream(Paths.get("src/database.properties"));
            props.load(in);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }// catch()
        finally {
            try {
                in.close();
            } catch (IOException e) {
                
                e.printStackTrace();
            }
        }// finally

        String url = props.getProperty("jdbc.url");
        String username = props.getProperty("jdbc.username");
        String password = props.getProperty("jdbc.password");
        // connect to database Receipients and query database
        try {
            // establish connection to database                              
            connection = DriverManager.getConnection(
                    url, username, password);

            // create Statement for querying database
            statement = connection.createStatement();

            // query database                                        
            resultSet = statement.executeQuery("SELECT AwardID, Name, Year, City, Category FROM recipients");

            // process query results
            ResultSetMetaData metaData = resultSet.getMetaData();
            int numberOfColumns = metaData.getColumnCount();
            System.out.println("Recipients Table of Ontario Database:\n");
            for (int i = 1; i <= numberOfColumns; i++) {
                System.out.printf("%-25s\t", metaData.getColumnName(i));
                System.out.printf("%-25s\t", metaData.getColumnTypeName(i));
                System.out.printf("%-25s\t", metaData.getColumnClassName(i));
                System.out.printf("\n");
            }
            
            while (resultSet.next()) {
                for (int i = 1; i <= numberOfColumns; i++) {
                    System.out.printf("%-20s\t", resultSet.getObject(i));
                }
                System.out.println();
            } // end while
            System.out.println("\nRecipients Table - Column Attributes:");
            
            for (int i = 1; i <= numberOfColumns; i++) {
                System.out.printf("%-25s\t", metaData.getColumnName(i));
                System.out.printf("%-25s\t", metaData.getColumnTypeName(i));
                System.out.printf("%-25s\t", metaData.getColumnClassName(i));
                System.out.printf("\n");
            }

            System.out.println();
            

            RecipientsBusinessLogic logic = new RecipientsBusinessLogic();
            List<RecipientDTO> list = null;
            RecipientDTO recipient = null;

            System.out.println("Printing Recipients");
            list = logic.getAllRecipients();
            for (int i = 1; i <= numberOfColumns; i++) {
                System.out.printf("%-25s\t", metaData.getColumnName(i));
                System.out.printf("%-25s\t", metaData.getColumnTypeName(i));
                System.out.printf("%-25s\t", metaData.getColumnClassName(i));
                System.out.printf("\n");
            }
            System.out.println();
            printRecipients(list);

            System.out.println("Printing One Recipient");
            recipient = logic.getRecipients(1);
            for (int i = 1; i <= numberOfColumns; i++) {
                System.out.printf("%-25s\t", metaData.getColumnName(i));
                System.out.printf("%-25s\t", metaData.getColumnTypeName(i));
                System.out.printf("%-25s\t", metaData.getColumnClassName(i));
                System.out.printf("\n");
            }
            System.out.println();
            printRecipient(recipient);
            System.out.println();

            System.out.println("Inserting One Recipient");
            recipient = new RecipientDTO();
            recipient.setName("FirstTestAdd");
            recipient.setYear(2023);
            recipient.setCity("TestCity");
            recipient.setCategory("TestCategory");
            logic.addRecipient(recipient);
            list = logic.getAllRecipients();
            for (int i = 1; i <= numberOfColumns; i++) {
                System.out.printf("%-25s\t", metaData.getColumnName(i));
                System.out.printf("%-25s\t", metaData.getColumnTypeName(i));
                System.out.printf("%-25s\t", metaData.getColumnClassName(i));
                System.out.printf("\n");
            }
            System.out.println();
            printRecipients(list);

            System.out.println("Updating last recipient");
            Integer updatePrimaryKey = list.get(list.size() - 1).getAwardID();
            recipient = new RecipientDTO();
            recipient.setAwardID(updatePrimaryKey);
            recipient.setName("FirstTestUpdate");
            recipient.setYear(0);
            recipient.setCity("LastTestUpdateCity");
            recipient.setCategory("LastTestUpdateCategory");
            logic.updateRecipient(recipient);
            list = logic.getAllRecipients();
            System.out.println();
            for (int i = 1; i <= numberOfColumns; i++) {
                System.out.printf("%-25s\t", metaData.getColumnName(i));
                System.out.printf("%-25s\t", metaData.getColumnTypeName(i));
                System.out.printf("%-25s\t", metaData.getColumnClassName(i));
                System.out.printf("\n");
            }
            printRecipients(list);

            System.out.println("Deleting last recipient");
            recipient = list.get(list.size() - 1);
            logic.deleteRecipient(recipient);
            list = logic.getAllRecipients();
            System.out.println();
            for (int i = 1; i <= numberOfColumns; i++) {
                System.out.printf("%-25s\t", metaData.getColumnName(i));
                System.out.printf("%-25s\t", metaData.getColumnTypeName(i));
                System.out.printf("%-25s\t", metaData.getColumnClassName(i));
                System.out.printf("\n");
            }
            printRecipients(list);

        } // end try
        catch (SQLException sqlException) {
            sqlException.printStackTrace();
        } // end catch                                                     
        finally // ensure resultSet, statement and connection are closed
        {
            try {
                resultSet.close();
                statement.close();
                connection.close();
            } // end try                                               
            catch (Exception exception) {
                exception.printStackTrace();
            }
            // end catch
            // end catch                                             
        } // end finally                                              
    }

    /**
     * Prints the recipient information in a formatted manner.
     * @param recipient The recipient object to be printed.
     */
    private static void printRecipient(RecipientDTO recipient) {
        String output = String.format("%-5s\t %-25s\t %-25s\t %-25s\t %-25s\t",
                recipient.getAwardID().toString(),
                recipient.getName(),
                recipient.getYear().toString(),
                recipient.getCity(),
                recipient.getCategory());
        System.out.println(output);
    }
    
    /**
     * This method prints a list of {@link RecipientDTO} objects in a formatted way.
    For each recipient in the list, the method invokes the {@link #printRecipient(RecipientDTO)} method
    to print the individual recipient information.
     * @param recipients recipients A list of {@link RecipientDTO} objects to be printed
     */
    private static void printRecipients(List<RecipientDTO> recipients) {
        for (RecipientDTO recipient : recipients) {
            printRecipient(recipient);
        }
        System.out.println();
    }
    
    
} 
