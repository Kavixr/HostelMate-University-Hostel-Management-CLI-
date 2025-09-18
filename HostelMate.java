import java.util.Scanner;

public class HostelMate {

    // Data Tables for array

    // 100 - maximum number of rooms and 6-attributes for each room
    static String[][] rooms = new String[100][5];

    // 100 - maximum number of students and 6-attributes for each student
    static String[][] students = new String[100][5];

    // 100 - maximum number of allocationns and 6-attributes for each allocatiions
    static String[][] allocations = new String[100][5];

    // Stored the occupancy
    static String[][] occupancy = new String[100][10];

    // get the count of records
    static int countofstudents = 0; // count of students
    static int countofrooms = 0; // count of rooms
    static int countofallocations = 0; // count of allocations

    static Scanner input = new Scanner(System.in);

    // Main Method of the application
    public static void main(String[] args) {
        login(); // Login to the System

        home(); // Home page of the application

    }

    // Implementintg the login system
    private static void login() {

        // Declare the variables
        String user;
        String password;

        // get the user inputs
        while (true) {
            System.out.println("=".repeat(35));
            System.out.println(">>>      HOSTELMATE LOGIN      <<<");
            System.out.println("=".repeat(35));

            System.out.print("Username ---> ");
            user = input.nextLine();

            System.out.print("Password ---> ");
            password = input.nextLine();

            // validate the user login
            if (user.equals("kavindu") && password.equals("kavindu123")) {
                System.out.println(">>> Login Successfully!! Welcome " + user + " to HostelMate System.....");
                System.out.println();
                break;
            } else {
                System.out.println(">>> Invalid username or password. Please try again...");
                System.out.println();
            }
        }

    }

    // Implementing the home page
    private static void home() {

    }
}