import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
//Olaf Carlson
//Indiana University Southeast
//INFO 451

public class InventorySystem {
    public static void main(String[] args) throws SQLException {

        Scanner s = new Scanner(System.in);
        boolean keepGoing = true;
        //creating console input and output
        while (keepGoing) {
            System.out.println("     Inventory Menu");
            System.out.println("_____________________________");
            System.out.println("  1.  Login ");
            System.out.println("  2.  Search Inventory and Display");
            System.out.println("  3.  Create Inventory");
            System.out.println("  4.  Remove Inventory Equipment at Building Location");
            System.out.println("  5.  Display All Building Inventories");
            System.out.println("  6.  Change Inventory Quantity Count");
            System.out.println("  7.  Change Inventory Status");
            System.out.println("  8.  Exit");
            System.out.println();
            System.out.print("Please input your choice <1-4>:");

            int choice = s.nextInt();

            switch (choice) {
                case 1:
                    login();
                    System.out.println();
                    break;

                case 2:
                    searchInventory();
                    System.out.println();
                    break;

                case 3:
                    createInventoryAccount();
                    System.out.println();
                    break;

                case 4:
                    removeInventory();
                    System.out.println();
                    break;

                case 5:
                    displayTables ();
                    System.out.println();
                    break;

                case 6: changeInventoryQty();
                    System.out.println();
                    break;

                case 7: changeInventoryStatus();
                    System.out.println();
                    break;

                case 8:
                    System.out.println();
                    keepGoing = false;
                    break;
            }
        }
    }
    //allows user to login with username and password
    public static void login() throws SQLException {
        //makes connection to mySQL database mydatabase
        Connection connection = DatabaseConnection.getConnection();
        Scanner s = new Scanner(System.in);
        //creates user input
        System.out.print("Please Corporate USER NAME: ");
        String searchUserName = s.nextLine();
        System.out.println();

        System.out.print("Please enter CORPORATE PASSWORD: ");
        String searchPassword = s.nextLine();
        System.out.println();

        Statement statement;
        statement = connection.createStatement();
        ResultSet resultSet;

        Statement qc = connection.createStatement();
        resultSet = qc.executeQuery("select * from loginPassword WHERE login = '" + searchUserName +"' " +
                "AND password = '" + searchPassword + "' ");

        int code;
        String title;
        int count = 0;
        //while loop for verifying if exist
        while (resultSet.next()) {
            count++;
            String login = resultSet.getString("login");
            String password = resultSet.getString("password");
              }
        //if exists do the following
        if (count !=0) {
            ResultSet executionworked;
            executionworked = qc.executeQuery("select * from loginPassword WHERE login = '" + searchUserName +"' " + "AND password = '" + searchPassword + "' ");
            System.out.println("Password Accepted!");
            qc.close();
            connection.close();
        }
        //if does not exist print out for user
        else {
            System.out.println("Not found please try again!");
        }
    }
    //searches inventory with queries for buildingLocation, status, and heci,
    public static void searchInventory() throws SQLException {
        //makes connection to mySQL database mydatabase
        Connection connection = DatabaseConnection.getConnection();
        Scanner s = new Scanner(System.in);

        System.out.print("Please input 2 digit state and four digit Building Location: ");
        String searchBuildingLocation = s.nextLine();
        System.out.println();

        System.out.print("Please input the equipment Status: ");
        String statusEquip = s.nextLine();
        System.out.println();

        System.out.print("Please input the equipment HECI: ");
        String heciNumber = s.nextLine();
        System.out.println();

        Statement statement;
        statement = connection.createStatement();
        ResultSet resultSet;

        Statement qc = connection.createStatement();
        resultSet = qc.executeQuery("select * from Inventory WHERE buildingLocation = '" + searchBuildingLocation +"' " +
                "AND heci = '" + heciNumber +  "'  AND status = '" + statusEquip + "' ");

        int code;
        String title;
        int count = 0;
        //while loop for verifying if exist
        while (resultSet.next()) {

            count++;
            String buildingLocation = resultSet.getString("buildingLocation");
            String heci = resultSet.getString("heci");
            String description = resultSet.getString("description");
            Double cost = resultSet.getDouble("cost");
            Double bayLocation = resultSet.getDouble("bayLocation");
            String status = resultSet.getString("status");
            int quantity = resultSet.getInt("quantity");

            System.out.println("Inventory found!");
            System.out.println("buildingLocation : " + buildingLocation
                    + " heci : " + heci + "description : " + description
                    + " cost: " + cost + " bayLocation: " + bayLocation
                    + " status: " + status + " quantity: " + quantity);
        }
        if (count !=0) {
            ResultSet executionworked;
            executionworked = qc.executeQuery("select * from Inventory WHERE buildingLocation = '" + searchBuildingLocation +"' " +
                    "AND heci = '" + heciNumber +  "'  AND status = '" + statusEquip + "' ");

            qc.close();
            connection.close();
        }
        //if does not exist print out for user
        else {
            System.out.println("Not found please try again!");
        }
    }

    //creates inventory account with all table inputs
    public static void createInventoryAccount() throws SQLException {
        //makes connection to mySQL database mydatabase
        Connection connection = DatabaseConnection.getConnection();

        Scanner s = new Scanner(System.in);
        //BuildingLocation buildingLocation = new BuildingLocation();
        System.out.print("Please input 2 digit state and four digit Building Location: ");
        String buildingLocation = s.nextLine();
        System.out.println();

        System.out.print("Please input the equipment HECI: ");
        String heciNumber = s.nextLine();
        System.out.println();

        System.out.print("Please input the equipment Description: ");
        String descriptionEquip = s.nextLine();
        System.out.println();

        System.out.print("Please input the equipment Cost: ");
        Double costEquip = s.nextDouble();
        System.out.println();

        System.out.print("Please input the equipment Bay Location: ");
        Double bayLocationEquip = s.nextDouble();
        System.out.println();
        s.nextLine();
        System.out.print("Please input the equipment Status: ");
        String statusEquip = s.nextLine();
        System.out.println();

        System.out.print("Please input the Quantity: ");
        Integer quantityEquip = s.nextInt();
        System.out.println();

        System.out.println("Building account created successfully!");
        Statement st = connection.createStatement();
        st.execute("INSERT INTO Inventory (buildingLocation, heci, description, cost, bayLocation, status, quantity) VALUES ( '"+ buildingLocation + "', '" + heciNumber + "', '" + descriptionEquip + "', " + costEquip + ", " + bayLocationEquip + ", '" + statusEquip + "', " + quantityEquip + ")" );

        st.close();
        connection.close();
         }

         //removes table in Inventory

    public static void removeInventory() throws SQLException {
        //makes connection to mySQL database mydatabase
        Connection connection = DatabaseConnection.getConnection();
        Scanner s = new Scanner(System.in);

        System.out.print("Please input 2 digit state and four digit Building Location: ");
        String searchBuildingLocation = s.nextLine();
        System.out.println();

        System.out.print("Please input the equipment HECI: ");
        String heciNumber = s.nextLine();
        System.out.println();

        Statement qc = connection.createStatement();
        ResultSet resultSet = qc.executeQuery("select * from Inventory WHERE buildingLocation = '" + searchBuildingLocation +"' " +
                "AND heci = '" + heciNumber + "' " );
        int code;
        String title;
        int count = 0;
        //while loop for verifying if exist
        while (resultSet.next()) {
            count++;
            String buildingLocation = resultSet.getString("buildingLocation");
            String heci = resultSet.getString("heci");
            String description = resultSet.getString("description");
            Double cost = resultSet.getDouble("cost");
            Double bayLocation = resultSet.getDouble("bayLocation");
            String status = resultSet.getString("status");
            int quantity = resultSet.getInt("quantity");
        }
            if (count !=0) {
                boolean executionworked;
                executionworked = qc.execute("DELETE FROM Inventory WHERE heci = '" + heciNumber + "' AND buildingLocation = '" + searchBuildingLocation + "';");

                System.out.println("Inventory Delete Successful!");
                qc.close();
                connection.close();
            }
            //if does not exist print out for user
            else {
                System.out.println("Not found please try again!");
            }
    }

    public static void displayTables() throws SQLException {
        //makes connection to mySQL database mydatabase
        Connection connection = DatabaseConnection.getConnection();
        Statement statement;
        statement = connection.createStatement();
        ResultSet resultSet;
        resultSet = statement.executeQuery(
                "select * from Inventory");
        int code;
        String title;
        //while loop for verifying if exist
        while (resultSet.next()) {
            String buildingLocation = resultSet.getString("buildingLocation");
            String heci = resultSet.getString("heci");
            String description = resultSet.getString("description");
            Double cost = resultSet.getDouble("cost");
            Double bayLocation = resultSet.getDouble("bayLocation");
            String status = resultSet.getString("status");
            int quantity = resultSet.getInt("quantity");

            System.out.println("buildingLocation : " + buildingLocation
                    + " heci : " + heci + "description : " + description
                    + " cost: " + cost + " bayLocation: " + bayLocation
                    + " status: " + status + " quantity: " + quantity);
        }
        resultSet.close();
        statement.close();
        connection.close();

    }

    public static void changeInventoryQty() throws SQLException {
        //makes connection to mySQL database mydatabase
        Connection connection = DatabaseConnection.getConnection();

        Scanner s = new Scanner(System.in);
        System.out.print("Please input 2 digit state and four digit Building Location: ");
        String buildingLocationEquip = s.nextLine();
        System.out.println();

        System.out.print("Please input the equipment HECI: ");
        String heciNumber = s.nextLine();
        System.out.println();

        System.out.print("Please input the equipment Bay Location: ");
        Double bayLocationEquip = s.nextDouble();
        System.out.println();
        s.nextLine();

        System.out.print("Please input the equipment Status: ");
        String statusEquip = s.nextLine();
        System.out.println();

        System.out.print("Please input the NEW QUANTITY: ");
        Integer quantityEquip = s.nextInt();
        System.out.println();

        Statement qc = connection.createStatement();
        ResultSet resultSet = qc.executeQuery(
                "select * from Inventory WHERE buildingLocation = '" + buildingLocationEquip + "'  " +
                        "AND heci = '" + heciNumber + "'  AND  bayLocation = '" + bayLocationEquip + "' " +
                        "AND  status = '" + statusEquip + "'");
        int code;
        String title;
        int count =0;
        //while loop for verifying if exist
        while (resultSet.next()) {
            count++;
            String buildingLocation = resultSet.getString("buildingLocation");
            String heci = resultSet.getString("heci");
            String description = resultSet.getString("description");
            Double cost = resultSet.getDouble("cost");
            Double bayLocation = resultSet.getDouble("bayLocation");
            String status = resultSet.getString("status");
            int quantity = resultSet.getInt("quantity");
        }

        if (count != 0) {
            boolean executionWorked;
            executionWorked = qc.execute ("UPDATE Inventory SET quantity = '" + quantityEquip + "' WHERE  buildingLocation = '" + buildingLocationEquip + "'  " +
                    "AND heci = '" + heciNumber + "'  AND  bayLocation = '" + bayLocationEquip + "' " +
                    "AND  status = '" + statusEquip + "'");

            System.out.println("Building QUANTITY changed successfully!");
            qc.close();
            connection.close();
        }
        //if does not exist print out for user
        else {
            System.out.println("Not found please try again!");
        }
    }

    public static void changeInventoryStatus() throws SQLException {
        //makes connection to mySQL database mydatabase
        Connection connection = DatabaseConnection.getConnection();

        Scanner s = new Scanner(System.in);
        System.out.print("Please input 2 digit state and four digit Building Location: ");
        String buildingLocationEquip = s.nextLine();
        System.out.println();

        System.out.print("Please input the equipment HECI: ");
        String heciNumber = s.nextLine();
        System.out.println();


        System.out.print("Please input the equipment Bay Location: ");
        Double bayLocationEquip = s.nextDouble();
        System.out.println();
        s.nextLine();

        System.out.print("Please input the NEW equipment Status: ");
        String statusEquip = s.nextLine();
        System.out.println();

        Statement qc = connection.createStatement();
        ResultSet resultSet = qc.executeQuery(
                "select * from Inventory WHERE buildingLocation = '" + buildingLocationEquip + "'  " +
                        "AND heci = '" + heciNumber + "'  AND  bayLocation = '" + bayLocationEquip + "' " );
        int code;
        String title;

        int count = 0;
        //while loop for verifying if exist
        while (resultSet.next()) {
            count++;
            String buildingLocation = resultSet.getString("buildingLocation");
            String heci = resultSet.getString("heci");
            String description = resultSet.getString("description");
            Double cost = resultSet.getDouble("cost");
            Double bayLocation = resultSet.getDouble("bayLocation");
            String status = resultSet.getString("status");
            int quantity = resultSet.getInt("quantity");

        }

        if (count != 0) {
            boolean executionWorked;
            executionWorked = qc.execute("UPDATE Inventory SET status = '" + statusEquip + "' WHERE  buildingLocation = '" + buildingLocationEquip + "'  " +
                    "AND heci = '" + heciNumber + "'  AND  bayLocation = '" + bayLocationEquip + "' " + "");


            System.out.println("Building CHANGE INVENTORY STATUS changed successfully!");

            qc.close();
            connection.close();
            //if does not exist print out for user
        } else {
            System.out.println("Not found please try again!");


        }
    }
    //exits program
    public static boolean exit() {
        boolean keepGoing = true;
        System.out.println();
        keepGoing = false;
        return keepGoing;
    }
}

