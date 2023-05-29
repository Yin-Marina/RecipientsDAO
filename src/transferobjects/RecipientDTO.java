
package transferobjects;
/**
 * <p>
 * This is the DTO object for CST8288-Object Oriented Programming with design patterns(Java) Lab 2.
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
 * This class is the DTO class that works as a simple data structure for carrying
 * data between the data storage and the business logic layers of the program.
 * </p>
 *
 */
public class RecipientDTO {

    private Integer awardID;
    private String name;
    private Integer year;
    private String city;
    private String category;
    
    /**
     * Gets the award's ID.
     *
     * @return The award's ID.
     */
    public Integer getAwardID() {
        return awardID;
    }
    
    /**
     * Sets the award's ID.
     *
     * @param awardID The award's ID.
     */
    public void setAwardID(Integer awardID) {
        this.awardID = awardID;
    }

    /**
     * Gets the award's name.
     *
     * @return The award's name.
     */
    public String getName() {
        return name;
    }
    
    /**
     * Sets the award's name.
     *
     * @param name The award's name.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the award's year.
     *
     * @return The award's year.
     */
    public Integer getYear() {
        return year;
    }

    /**
     * Sets the award's year.
     *
     * @param year The award's year.
     */
    public void setYear(Integer year) {
        this.year = year;
    }
    
    /**
     * Gets the award's city.
     *
     * @return The award's city.
     */
    public String getCity() {
        return city;
    }
    
    /**
     * Sets the award's city.
     *
     * @param city The award's city.
     */
    public void setCity(String city) {
        this.city = city;
    }
    /**
     * Gets the award's category.
     *
     * @return The award's category.
     */
    public String getCategory() {
        return category;
    }
    
    /**
     * Sets the award's category.
     *
     * @param category The award's category.
     */
    public void setCategory(String category) {
        this.category = category;
    }

}
