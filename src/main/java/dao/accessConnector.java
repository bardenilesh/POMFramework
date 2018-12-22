package dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
 
public class accessConnector {
	static Connection connection;
    static Statement statement;
    static ResultSet resultSet;
    static PreparedStatement preparedStatement;
    public static void main(String[] args){
    	
        updateDB();
        selectDB();
    }
    
    public static void selectDB(){
    	// variables
        connection = null;
        statement = null;
        resultSet = null;
 
        // Step 1: Loading or registering Oracle JDBC driver class
        try {
 
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
        }
        catch(ClassNotFoundException cnfex) {
 
            System.out.println("Problem in loading or "
                    + "registering MS Access JDBC driver");
            cnfex.printStackTrace();
        }
 
        // Step 2: Opening database connection
        try {
 
            String msAccDB = "Database1.accdb";
            String dbURL = "jdbc:ucanaccess://" + msAccDB; 
 
            // Step 2.A: Create and get connection using DriverManager class
            connection = DriverManager.getConnection(dbURL); 
 
            // Step 2.B: Creating JDBC Statement 
            statement = connection.createStatement();
 
         // Step 2.C: Executing SQL &amp; retrieve data into ResultSet
            resultSet = statement.executeQuery("SELECT * FROM personal");
 
            System.out.println("ID\tfname\t\tmname\tlname\tdob\tgender");
            System.out.println("==\t================\t===\t====\t");
 
            // processing returned data and printing into console
            while(resultSet.next()) {
                System.out.println(resultSet.getInt(1) + "\t" + 
                        resultSet.getString(2) + "\t" + 
                        resultSet.getString(3) + "\t" +
                        resultSet.getString(4)+ "\t" +
                		resultSet.getString(5));
            }
        }
        catch(SQLException sqlex){
            sqlex.printStackTrace();
        }
        finally {
 
            // Step 3: Closing database connection
            try {
                if(null != connection) {
 
                    // cleanup resources, once after processing
                    resultSet.close();
                    statement.close();
 
                    // and then finally close connection
                    connection.close();
                }
            }
            catch (SQLException sqlex) {
                sqlex.printStackTrace();
            }
        }
    }
    public static void updateDB(){
    	connection = null;
        statement = null;

        // Step 1: Loading or registering Oracle JDBC driver class
        try {
 
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
        }
        catch(ClassNotFoundException cnfex) {
 
            System.out.println("Problem in loading or "
                    + "registering MS Access JDBC driver");
            cnfex.printStackTrace();
        }
 
        // Step 2: Opening database connection
        try {
 
            String msAccDB = "Database1.accdb";
            String dbURL = "jdbc:ucanaccess://" + msAccDB; 
 
            // Step 2.A: Create and get connection using DriverManager class
            connection = DriverManager.getConnection(dbURL); 
 
 
            preparedStatement=connection.prepareStatement("insert into personal (fname,mname,lname,dob,gender) values(?,?,?,?,?)");
            //Setting values for Each Parameter
            preparedStatement.setString(1,"Sandeep");
            preparedStatement.setString(2,"N");
            preparedStatement.setString(3,"Kandalkar");
            preparedStatement.setString(4,"12/12/1988");
            preparedStatement.setString(5,"Male");
            //Executing Query
            preparedStatement.executeUpdate();
            System.out.println("data inserted successfully");
        }
            catch(SQLException sqlex){
                sqlex.printStackTrace();
            }
            finally {
     
                // Step 3: Closing database connection
                try {
                    if(null != connection) {
     
                        // cleanup resources, once after processing
                        preparedStatement.close();
     
                        // and then finally close connection
                        connection.close();
                    }
                }
                catch (SQLException sqlex) {
                    sqlex.printStackTrace();
                }
            }
    }
}