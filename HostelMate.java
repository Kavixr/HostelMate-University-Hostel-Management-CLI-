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
        while (true) {
            System.out.println("=".repeat(35));
            System.out.println(">>>        HOSTELMATE MENU      <<<");
            System.out.println();
            System.out.println("=".repeat(35));
            System.out.println(" 1) Manage Rooms ");
            System.out.println(" 2) Manage Students ");
            System.out.println(" 3) Allocate Bed ");
            System.out.println(" 4) Vacate Bed");
            System.out.println(" 5) Transfers ");
            System.out.println(" 6) View Reportss ");
            System.out.println(" 7) Exit");
            System.out.println("=".repeat(35));
            System.out.println("Enter your choice: ");

            int choice;
            try {
                choice = Integer.parseInt(input.nextLine());
            } catch (Exception e) {
                System.out.println(">>> Ivalid input. Enter a correct number.  ");
                continue;
            }

            switch (choice) {
                case 1:
                    mangeRooms();
                    break;

                case 2:
                    manageStudents();
                    break;

                case 3:
                    allocateBed();
                    break;

                case 4:
                    vacateBed();
                    break;

                case 5:
                    transferBed();
                    break;

                case 6:
                    viewReports();
                    break;

                case 7:
                    Exit();
                    break;

                default:
                    System.out.println("Invalid Option..Choose Correct one..");
                    System.out.println();
            }
        }

    }

    // Method of mange Rooms
    private static void mangeRooms() {

    }

    // Methof of manage Students
    private static void manageStudents() {
        int studentChoice;

        while (true) {
            System.out.println("\n>>>        HOSTELMATE MENU      <<<");
            System.out.println();
            System.out.println("1) Add Student");
            System.out.println("2) Update Student");
            System.out.println("3) Delete Student");
            System.out.println("4) Search Student");
            System.out.println("5) View All Studnets");
            System.out.println("6) Back");
            System.out.println("Choose ---> ");

            try {
                studentChoice = Integer.parseInt(input.nextLine()); // convert to an integer

            } catch (Exception e) {
                System.out.println(" Invalid input.. Please Try again ");
                continue;
            }

            switch (studentChoice) {
                case 1:
                    addstudent();
                    break;
                case 2:
                    updatestudent();
                    break;

                case 3:
                    deletestudent();
                    break;

                case 4:
                    searchstudent();
                    break;

                case 5:
                    viewAllStudents();
                    break;

                case 6:
                    Back();
                    break;

                default:
                    System.out.println(" Invalid Option..");
            }

        }

    }

    private static void addstudent() {

        // Declare the variables
        String id;
        String name;
        String contact;
        String email;

        System.out.println("\n >>>  Add Student  <<<");

        // get the student id of the student.
        while (true) {
            System.out.println("Student ID: ");
            id = input.nextLine();

            boolean alreadyexits = false;

            // validation: if id alrady have or not
            for (int i = 0; i < countofstudents; i++) {
                if (students[i][0].equalsIgnoreCase(id)) { // Compare ignoring case
                    alreadyexits = true; // Found a duplicate
                    break; // No need to check further
                }
            }
            if (alreadyexits) {
                System.out.println("Error: Student ID already exists. Please Try again");

            } else {
                break;
            }

        }

        System.out.println("Name: ");
        name = input.nextLine();

        // Contatct NO.
        while (true) {

            System.out.println("Contact NO: ");
            contact = input.nextLine();

            // Validation of the contact..
            if (contact.length() != 10) {
                System.out.println("Invalid number.. Please Enter Correct number");
                continue;
            }

            boolean digit = true;

            for (int i = 0; i < contact.length(); i++) {
                char ct = contact.charAt(i); // go throught the each character in contact.
                if (ct < '0' || ct > '9') { // Check that number have between these two ..
                    digit = false;
                    break;
                }
            }

            if (!digit) {
                System.out.println("Error... Contact must contain only digit.");
                continue;
            }
            boolean exists = false;
            for (int i = 0; i < countofstudents; i++) {
                if (students[i][2].equals(contact)) {
                    exists = true; // found the duplicate contatc number
                    break;
                }
            }

            if (exists) {
                System.out.println("Error: This contact number already exists. Please try again.");
            } else {
                break;
            }
        }

        // Email.
        while (true) {

            System.out.println("Email: ");
            email = input.nextLine();

            // Validate the email....
            if (!(email.contains("@") && email.contains("."))) { // check the enter email have these "@" and "."..
                System.out.println("Invalid email. Please Enter valid email..");
                continue;
            }

            boolean exists = false;
            for (int i = 0; i < countofstudents; i++) {
                if (students[i][3].equalsIgnoreCase(email)) {
                    exists = true; // found duplicate
                    break;
                }
            }

            if (exists) {
                System.out.println("Error: This email already exists. Please try again.");
            } else {
                break;
            }
        }

        // store the details in each students
        students[countofstudents][0] = id;
        students[countofstudents][1] = name;
        students[countofstudents][2] = contact;
        students[countofstudents][3] = email;
        students[countofstudents][4] = "Active";

        countofstudents++; // count each new student

        System.out.println("Student added Successfully..");

    }

    private static void updatestudent() {

        String id;
        String newcontact;
        String newemail;

        System.out.println("\n >>> Update Student <<<");

        System.out.print("Enter the Student ID: ");
        id = input.nextLine();

        int ids = -1; // which row number the student is stored in student array
        for (int i = 0; i < countofstudents; i++) {
            if (students[i][0].equalsIgnoreCase(id)) {
                ids = i;
                break;
            }
        }

        if (ids == -1) { // not found the student
            System.out.println("Not Found the Student given id. ");
            return;
        }

        // Contact
        System.out.println("New Contact (or -): ");
        newcontact = input.nextLine();

        if (!newcontact.equals("-")) {
            // validate contact: length & digits
            if (newcontact.length() != 10) {
                System.out.println("Invalid contact length. Update skipped.");
            } else {
                boolean digit = true;
                for (int i = 0; i < newcontact.length(); i++) {
                    char ct = newcontact.charAt(i);
                    if (ct < '0' || ct > '9') {
                        digit = false;
                        break;
                    }
                }
                if (!digit) {
                    System.out.println("Error.. Contact must be digits only ");
                } else {
                    // check uniqueness
                    boolean alreadyexists = false;
                    for (int i = 0; i < countofstudents; i++) {
                        if (i != ids && students[i][2].equals(newcontact)) {
                            alreadyexists = true;
                            break;
                        }
                    }
                    if (alreadyexists) {
                        System.out.println("Error: Contact already exists. Please enter new number.");
                    } else {
                        students[ids][2] = newcontact; // update the contact
                    }
                }
            }
        }

        // Email..
        System.out.println("New Email(or -): ");
        newemail = input.nextLine();

        if (!newemail.equals("-")) {
            if (!(newemail.contains("@") && newemail.contains("."))) {
                System.out.println("Invalid email format.");
            } else {
                // check uniqueness
                boolean exists = false;
                for (int i = 0; i < countofstudents; i++) {
                    if (i != ids && students[i][3].equalsIgnoreCase(newemail)) {
                        exists = true;
                        break;
                    }
                }
                if (exists) {
                    System.out.println("Error: Email already exists. Enter new email."); // Check altready have or not
                } else {
                    students[ids][3] = newemail; // update the email
                }
            }
        }

        
        System.out.println("Updated: "
                + students[ids][0] + " |" // Student ID
                + students[ids][1] + " |" // Name
                + students[ids][2] + " |" // Contact (updated or not)
                + students[ids][3] + " |" // Email (updated or not)
                + students[ids][4] // Status
            );     

    }

    private static void deletestudent() {
    }

    private static void searchstudent() {

    }

    private static void viewAllStudents() {

    }

    private static void Back() {
        return;
    }

    // =============================================================================================================================

    // Method of allocate bed
    private static void allocateBed() {

    }

    // Method of vacate Bed
    private static void vacateBed() {

    }

    // Method of transfer bed
    private static void transferBed() {

    }

    // Method of view reports
    private static void viewReports() {

    }

    // Method of exit
    private static void Exit() {

    }

}
