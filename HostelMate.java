import java.time.LocalDate;
import java.util.*;

public class HostelMate {

    // Data Tables for array

    // 100 - maximum number of rooms and 6-attributes for each room
    static String[][] rooms = new String[100][6];

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
            System.out.println();
            System.out.println("***************************************************");
            System.out.println("*                                                 *");
            System.out.println("*              WELCOME TO HOSTELMATE              *");
            System.out.println("*          University Hostel Management           *");
            System.out.println("*                                                 *");
            System.out.println("***************************************************");
            System.out.println("                     LOGIN                         ");
            System.out.println("---------------------------------------------------");

            System.out.print(">> Username : ");
            user = input.nextLine();

            System.out.print(">> Password : ");
            password = input.nextLine();

            System.out.println("---------------------------------------------------");
            System.out.println("Verifying credentials... Please wait...");
            System.out.println();

            // validate the user login
            if (user.equals("kavindu") && password.equals("kavindu123")) {
                System.out.println("Authentication complete. Hello, " + user + "! Welcome to the HostelMate System.");
                System.out.println();
                break;
            } else {
                System.out.println("Oops! Your username or password didn't match. Please re-enter your credentials.");
                System.out.println();
            }
        }

    }

    // Implementing the home page
    private static void home() {
        while (true) {
            System.out.println();
            System.out.println("==============================================");
            System.out.println("||           HOSTELMATE MAIN MENU           ||");
            System.out.println("==============================================");
            System.out.println("  [1] Manage Rooms");
            System.out.println("  [2] Manage Students");
            System.out.println("  [3] Allocate Bed");
            System.out.println("  [4] Vacate Bed");
            System.out.println("  [5] Transfers");
            System.out.println("  [6] View Reports");
            System.out.println("  [7] Exit");
            System.out.println("==============================================");
            System.out.print("Enter your choice: ");

            // read the inputs as string
            String InputValue = input.nextLine();

            boolean isNumber = true; // assume number is valid

            if (InputValue.isEmpty()) { // check the input is empty or not
                isNumber = false;
            } else {
                for (int i = 0; i < InputValue.length(); i++) {
                    char ch = InputValue.charAt(i);
                    if (ch < '0' || ch > '9') {
                        isNumber = false;
                    }
                }
            }

            if (!isNumber) {
                System.out.println(">>> Invalid input. Please Enter valid input.");
                continue; // Go back to top of the while loop
            }

            int choice = Integer.parseInt(InputValue);

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
        int roomchoice;

        while (true) {
            System.out.println();
            System.out.println("==========================================");
            System.out.println("|          MANAGE ROOMS MENU             |");
            System.out.println("==========================================");
            System.out.println("|  1. Add Room                           |");
            System.out.println("|  2. Update Room                        |");
            System.out.println("|  3. Delete Room                        |");
            System.out.println("|  4. Search Room                        |");
            System.out.println("|  5. View All Rooms                     |");
            System.out.println("|  6. Back                               |");
            System.out.println("==========================================");
            System.out.print("Please choose an option: ");

            String rChoice = input.nextLine();

            boolean isNumber = true;

            if (rChoice.isEmpty()) {
                isNumber = false;
            } else {
                for (int i = 0; i < rChoice.length(); i++) {
                    char ch = rChoice.charAt(i);
                    if (ch < '0' || ch > '9') {
                        isNumber = false;
                        break;
                    }
                }
            }

            if (!isNumber) {
                System.out.println("Invalid input. Kindly enter a valid value.");
                continue;
            }

            roomchoice = Integer.parseInt(rChoice);

            switch (roomchoice) {
                case 1:
                    addRoom();
                    break;
                case 2:
                    updateRoom();
                    break;
                case 3:
                    deleteRoom();
                    break;
                case 4:
                    searchRoom();
                    break;
                case 5:
                    viewAllRooms();
                    break;
                case 6:
                    return; // Back to main menu
                default:
                    System.out.println("Invalid option! Please enter a valid choice.");

            }
        }

    }

    private static void addRoom() {
    System.out.println("\n-----------------------------------------");
    System.out.println("              ADD NEW ROOM               ");
    System.out.println("-----------------------------------------\n");

    String roomId;
    String floor;
    String roomNo;
    String capacityStr;
    String feePerDayStr;

    // Room ID (must be unique)
    while (true) {
        System.out.print("Room ID          : ");
        roomId = input.nextLine().trim();

        if (roomId.isEmpty()) {
            System.out.println("Error: Room ID cannot be empty. Please enter a valid ID.");
            continue;
        }

        boolean exists = false;
        for (int i = 0; i < countofrooms; i++) {
            if (rooms[i][0].equalsIgnoreCase(roomId)) {
                exists = true;
                break;
            }
        }
        if (exists) {
            System.out.println("Error: Room ID already exists. Please try another ID.");
        } else {
            break;
        }
    }

    // Floor number
    while (true) {
        System.out.print("Floor            : ");
        floor = input.nextLine().trim();

        if (floor.isEmpty()) {
            System.out.println("Error: Floor cannot be empty. Please enter a number.");
            continue;
        }

        boolean valid = true;
        for (int i = 0; i < floor.length(); i++) {
            char ch = floor.charAt(i);
            if (ch < '0' || ch > '9') {
                valid = false;
                break;
            }
        }

        if (!valid) {
            System.out.println("Error: Floor must contain only digits.");
            continue;
        } else {
            break;
        }
    }

    // Room number
    while (true) {
        System.out.print("Room No          : ");
        roomNo = input.nextLine().trim();

        if (roomNo.isEmpty()) {
            System.out.println("Error: Room Number cannot be empty. Please enter a number.");
            continue;
        }

        boolean isValid = true;
        for (int i = 0; i < roomNo.length(); i++) {
            char ch = roomNo.charAt(i);
            if (ch < '0' || ch > '9') {
                isValid = false;
                break;
            }
        }

        if (!isValid) {
            System.out.println("Error: Room Number must be a number.");
            continue;
        }

        boolean duplicate = false;
        for (int i = 0; i < countofrooms; i++) {
            if (rooms[i][1].equalsIgnoreCase(floor) && rooms[i][2].equalsIgnoreCase(roomNo)) {
                duplicate = true;
                break;
            }
        }

        if (duplicate) {
            System.out.println("Error: Room No " + roomNo + " already exists on Floor " + floor
                    + ". Try another room number.");
        } else {
            break;
        }
    }

    // Capacity
    int capacity = 0;
    while (true) {
        System.out.print("Capacity         : ");
        capacityStr = input.nextLine().trim();

        if (capacityStr.isEmpty()) {
            System.out.println("Error: Capacity cannot be empty.");
            continue;
        }

        boolean isNumber = true;
        for (int i = 0; i < capacityStr.length(); i++) {
            char ch = capacityStr.charAt(i);
            if (ch < '0' || ch > '9') {
                isNumber = false;
                break;
            }
        }

        if (!isNumber) {
            System.out.println("Invalid input. Please enter digits only for capacity.");
            continue;
        }

        capacity = Integer.parseInt(capacityStr);

        if (capacity <= 0) {
            System.out.println("Error: Capacity must be greater than zero.");
            continue;
        }

        break;
    }

    // Fee per day
    double feePerDay = 0.0;
    while (true) {
        System.out.print("Fee/Day (LKR)    : ");
        feePerDayStr = input.nextLine().trim();
        if (feePerDayStr.isEmpty()) {
            System.out.println("Error: Fee cannot be empty.");
            continue;
        }

        boolean isValid = true;
        int dotCount = 0;

        for (int i = 0; i < feePerDayStr.length(); i++) {
            char ch = feePerDayStr.charAt(i);

            if (ch == '.') {
                dotCount++;
                if (dotCount > 1) {
                    isValid = false;
                    break;
                }
            } else if (ch < '0' || ch > '9') {
                isValid = false;
                break;
            }
        }

        if (!isValid) {
            System.out.println("Invalid input. Enter a valid number");
            continue;
        }

        feePerDay = Double.parseDouble(feePerDayStr);

        if (feePerDay < 0) {
            System.out.println("Error: Fee cannot be negative.");
            continue;
        }

        break;
    }

    // Save data
    rooms[countofrooms][0] = roomId;
    rooms[countofrooms][1] = floor;
    rooms[countofrooms][2] = roomNo;
    rooms[countofrooms][3] = Integer.toString(capacity);
    rooms[countofrooms][4] = String.format("%.2f", feePerDay);
    rooms[countofrooms][5] = Integer.toString(capacity);

    countofrooms++;

    // Final output
    System.out.println();
    System.out.println("Room added successfully.");
    System.out.println("Available beds  : " + capacity);
    System.out.println("-----------------------------------------");
}


    private static void updateRoom() {
        System.out.println("\n>>> Update Room <<<");

        System.out.print("Enter Room ID to update: ");
        String roomId = input.nextLine();

        int roomIndex = -1;
        for (int i = 0; i < countofrooms; i++) {
            if (rooms[i][0].equalsIgnoreCase(roomId)) {
                roomIndex = i;
                break;
            }
        }

        if (roomIndex == -1) {
            System.out.println("Error: Room not found.");
            return;
        }

        // Capacity validation loop
        boolean validCapacity = false;
        while (!validCapacity) {
            System.out.print("New Capacity (or -): ");
            String newCap = input.nextLine();

            if (newCap.equals("-") || newCap.isEmpty()) {
                validCapacity = true;
                break;
            }

            boolean isNumber = true;
            for (int i = 0; i < newCap.length(); i++) {
                char ch = newCap.charAt(i);
                if (ch < '0' || ch > '9') {
                    isNumber = false;
                    break;
                }
            }

            if (!isNumber) {
                System.out.println("Invalid input. Capacity must be numeric. Please try again.");
            } else {
                int newCapacity = Integer.parseInt(newCap);
                if (newCapacity <= 0) {
                    System.out.println("Error: Capacity must be greater than zero. Please try again.");
                } else {
                    rooms[roomIndex][3] = Integer.toString(newCapacity);
                    rooms[roomIndex][5] = Integer.toString(newCapacity);
                    validCapacity = true;
                }
            }
        }

        // Fee-Day validation loop
        boolean validFee = false;
        while (!validFee) {
            System.out.print("New Fee/Day (or -): ");
            String newFee = input.nextLine().trim();

            if (newFee.equals("-") || newFee.isEmpty()) {
                validFee = true;
                break;
            }

            boolean isValid = true;
            int dotCount = 0;

            for (int i = 0; i < newFee.length(); i++) {
                char ch = newFee.charAt(i);
                if (ch == '.') {
                    dotCount++;
                    if (dotCount > 1) {
                        isValid = false;
                        break;
                    }
                } else if (ch < '0' || ch > '9') {
                    isValid = false;
                    break;
                }
            }

            if (!isValid) {
                System.out.println("Invalid input. Enter valid fee (e.g. 750 or 750.50). Please try again.");
            } else {
                double fee = Double.parseDouble(newFee);
                if (fee < 0) {
                    System.out.println("Error: Fee cannot be negative. Please try again.");
                } else {
                    rooms[roomIndex][4] = Double.toString(fee);
                    validFee = true;
                }
            }
        }

        System.out.println("Updated: "
                + rooms[roomIndex][0] + " | " // Room ID
                + "Floor=" + rooms[roomIndex][1] + " | "
                + "RoomNo=" + rooms[roomIndex][2] + " | "
                + "Capacity=" + rooms[roomIndex][3] + " | "
                + "Fee/Day=" + rooms[roomIndex][4] + " | "
                + "Avail=" + rooms[roomIndex][5]);
    }

    private static void deleteRoom() {
        System.out.println("\n>>> Delete Room <<<");

        System.out.print("Enter Room ID: ");
        String roomId = input.nextLine().trim();

        int roomIndex = -1;
        for (int i = 0; i < countofrooms; i++) {
            if (rooms[i][0].equalsIgnoreCase(roomId)) {
                roomIndex = i;
                break;
            }
        }

        if (roomIndex == -1) {
            System.out.println("Error: Room not found.");
            return;
        }

        // Check if this room has active allocations
        for (int i = 0; i < countofallocations; i++) {
            if (allocations[i][1] != null && allocations[i][1].equalsIgnoreCase(roomId)) {
                System.out.println("Error: Cannot delete. Active allocations exist for this room.");
                return;
            }
        }

        // Compact array (shift rows up)
        for (int i = roomIndex; i < countofrooms - 1; i++) {
            rooms[i] = rooms[i + 1];
        }

        countofrooms--;
        System.out.println("Room deleted successfully.");
    }

    private static void searchRoom() {
        System.out.println("\n>>> Search Room <<<");

        System.out.print("Enter Room ID: ");
        String roomId = input.nextLine().trim();

        int roomIndex = -1;
        for (int i = 0; i < countofrooms; i++) {
            if (rooms[i][0].equalsIgnoreCase(roomId)) {
                roomIndex = i;
                break;
            }
        }

        if (roomIndex == -1) {
            System.out.println("Error: Room not found.");
            return;
        }

        System.out.println("Found");

        System.out.printf("%-8s | %-8s | %-10s | %-10s | %-10s | %-10s%n",
                "ID", "Floor", "RoomNo", "Capacity", "AvailBeds", "Fee/Day");
        System.out.println("----------------------------------------------------------------------------------");

        // Print room row
        System.out.printf("%-8s | %-8s | %-10s | %-10s | %-10s | %-10s%n",
                rooms[roomIndex][0], rooms[roomIndex][1], rooms[roomIndex][2],
                rooms[roomIndex][3], rooms[roomIndex][5], rooms[roomIndex][4]);
    }

    private static void viewAllRooms() {

        System.out.println("\n >>> All Rooms <<<");
        System.out.println();

        if (countofrooms == 0) {
            System.out.println("No rooms available.");
            return;
        }

        // Header
        System.out.printf("%-8s | %-8s | %-10s | %-10s | %-10s | %-10s%n",
                "ID", "Floor", "RoomNo", "Capacity", "AvailBeds", "Fee/Day");
        System.out.println("----------------------------------------------------------------------------------");

        // Loop through all rooms
        for (int i = 0; i < countofrooms; i++) {
            System.out.printf("%-8s | %-8s | %-10s | %-10s | %-10s | %-10s%n",
                    rooms[i][0], rooms[i][1], rooms[i][2],
                    rooms[i][3], rooms[i][5], rooms[i][4]);
        }

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

            String stChoice = input.nextLine();

            boolean isNumber = true;

            if (stChoice.isEmpty()) {
                isNumber = false;
            } else {
                for (int i = 0; i < stChoice.length(); i++) {
                    char ch = stChoice.charAt(i);
                    if (ch < '0' || ch > '9') {
                        isNumber = false;
                        break;
                    }
                }
            }

            if (!isNumber) {
                System.out.println(">>> Invalid input. Please Enter valid input.");
                continue;
            }

            studentChoice = Integer.parseInt(stChoice);

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
                    return;

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
                System.out.println("Error: This contact number already exists. Please try again");
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
            System.out.println("Not Found the Student given ID. ");
            return;
        }

        // Contact
        // Contact validation with loop
        boolean validContact = false;
        while (!validContact) {
            System.out.println("New Contact (or -): ");
            newcontact = input.nextLine();

            if (newcontact.equals("-")) {
                validContact = true;
            } else {
                // validate contact: length & digits
                if (newcontact.length() != 10) {
                    System.out.println("Invalid contact length.");
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
                            validContact = true;
                        }
                    }
                }
            }
        }

        // Email validation with loop
        boolean validEmail = false;
        while (!validEmail) {
            System.out.println("New Email(or -): ");
            newemail = input.nextLine();

            if (newemail.equals("-")) {
                validEmail = true;
            } else {
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
                        System.out.println("Error: Email already exists. Enter new email.");
                    } else {
                        students[ids][3] = newemail; // update the email
                        validEmail = true;
                    }
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

        String id;

        System.out.println("\n >>>  Delete Student  <<<");

        System.out.println("Enter Student ID: ");
        id = input.nextLine();

        int ids = -1;
        for (int i = 0; i < countofstudents; i++) {
            if (students[i][0].equalsIgnoreCase(id)) {
                ids = i;
                break;
            }
        }

        if (ids == -1) {
            System.out.println("Error: Student not found.");
            return;
        }

        for (int i = 0; i < countofallocations; i++) {
            if (allocations[i][1] != null && allocations[i][1].equalsIgnoreCase(id)) {
                System.out.println("Error: Cannot Delete. Student has an active allocation");
                return;
            }
        }

        for (int i = ids; i < countofstudents - 1; i++) {
            students[i] = students[i + 1];
        }

        countofstudents--;

        System.out.println("Student Deleted Successfully. ");

    }

    private static void searchstudent() {

        String id;

        System.out.println("\n >>> Search Student <<< ");

        System.out.println("Enter Student ID: ");
        id = input.nextLine();

        int ids = -1;
        for (int i = 0; i < countofstudents; i++) {
            if (students[i][0].equalsIgnoreCase(id)) {
                ids = i; // found row index
                break;
            }
        }

        if (ids == -1) {
            System.out.println("Error: Student not found.");
            return;
        }

        System.out.println("Found");

        System.out.printf("%-6s | %-17s | %-11s | %-22s | %-8s%n",
                "ID", "Name", "Contact", "Email", "Status");
        System.out.println("----------------------------------------------------------------------------------");

        // Print row
        System.out.printf("%-6s | %-17s | %-11s | %-22s | %-8s%n",
                students[ids][0], students[ids][1], students[ids][2],
                students[ids][3], students[ids][4]);

    }

    private static void viewAllStudents() {
        System.out.println("\n >>> All Students <<<");
        System.out.println();

        if (countofstudents == 0) {
            System.out.println("No students available.");
            return;
        }

        // Header
        System.out.printf("%-8s | %-22s | %-12s | %-28s | %-10s%n",
                "ID", "Name", "Contact", "Email", "Status");
        System.out.println(
                "-----------------------------------------------------------------------------------------------------");

        // Loop through all students
        for (int i = 0; i < countofstudents; i++) {
            // System.out.println(students[i][0] + "\t"
            // + students[i][1] + "\t\t"
            // + students[i][2] + "\t"
            // + students[i][3] + "\t"
            // + students[i][4]);
            // }
            System.out.printf("%-8s | %-22s | %-12s | %-28s | %-10s%n",
                    students[i][0], students[i][1], students[i][2],
                    students[i][3], students[i][4]);
        }
    }

    // =============================================================================================================================

    // Method of allocate bed
    private static void allocateBed() {

        System.out.println("\n >>> Allocate Bed <<<");

        System.out.print("Student ID: ");
        String studentId = input.nextLine();

        // Find student
        int studentno = -1;
        for (int i = 0; i < countofstudents; i++) {
            if (students[i][0].equalsIgnoreCase(studentId)) {
                studentno = i;
                break;
            }
        }

        if (studentno == -1) {
            System.out.println("Error: Student not found.");
            return;
        }

        // Check if student is inactive
        if (students[studentno][4].equalsIgnoreCase("Inactive")) {
            System.out.println("Error: Student is inactive. Cannot allocate bed.");
            return;
        }

        // Check if student already has an active allocation
        for (int i = 0; i < countofallocations; i++) {
            if (allocations[i][0] != null && allocations[i][0].equalsIgnoreCase(studentId)) {
                System.out.println("Error: Student already has an active allocation.");
                return;
            }
        }

        System.out.print("Room ID: ");
        String roomId = input.nextLine();

        // Find room
        int roomIndex = -1;
        for (int i = 0; i < countofrooms; i++) {
            if (rooms[i][0].equalsIgnoreCase(roomId)) {
                roomIndex = i;
                break;
            }
        }

        if (roomIndex == -1) {
            System.out.println("Error: Room not found.");
            return;
        }

        // Check available beds
        int availableBeds = Integer.parseInt(rooms[roomIndex][5]);
        if (availableBeds <= 0) {
            System.out.println("Error: No available beds in this room.");
            return;
        }

        System.out.print("Due Date (YYYY-MM-DD): ");
        String dueDate = input.nextLine();

        // Manual date format validation - NO REGEX
        if (dueDate.length() != 10) {
            System.out.println("Error: Invalid date format. Please use YYYY-MM-DD.");
            return;
        }

        // Check positions of dashes
        if (dueDate.charAt(4) != '-' || dueDate.charAt(7) != '-') {
            System.out.println("Error: Invalid date format. Please use YYYY-MM-DD.");
            return;
        }

        // Check if year, month, day parts are digits
        boolean isValidFormat = true;

        // Check year (positions 0-3)
        for (int i = 0; i < 4; i++) {
            char ch = dueDate.charAt(i);
            if (ch < '0' || ch > '9') {
                isValidFormat = false;
                break;
            }
        }

        // Check month (positions 5-6)
        if (isValidFormat) {
            for (int i = 5; i < 7; i++) {
                char ch = dueDate.charAt(i);
                if (ch < '0' || ch > '9') {
                    isValidFormat = false;
                    break;
                }
            }
        }

        // Check day (positions 8-9)
        if (isValidFormat) {
            for (int i = 8; i < 10; i++) {
                char ch = dueDate.charAt(i);
                if (ch < '0' || ch > '9') {
                    isValidFormat = false;
                    break;
                }
            }
        }

        if (!isValidFormat) {
            System.out.println("Error: Invalid date format. Please use YYYY-MM-DD.");
            return;
        }

        String checkInDate = LocalDate.now().toString();

        // Due date must be after check-in date
        if (dueDate.compareTo(checkInDate) <= 0) {
            System.out.println("Error: Due date must be a future date.");
            return;
        }

        // Find an available bed
        int capacity = Integer.parseInt(rooms[roomIndex][3]);
        int bedIndex = -1;

        for (int bed = 0; bed < capacity; bed++) {
            if (occupancy[roomIndex][bed] == null) {
                bedIndex = bed;
                break;
            }
        }

        if (bedIndex == -1) {
            System.out.println("Error: No available beds found, despite availableBeds > 0.");
            return;
        }

        // Store allocation
        allocations[countofallocations][0] = studentId;
        allocations[countofallocations][1] = roomId;
        allocations[countofallocations][2] = Integer.toString(bedIndex);
        allocations[countofallocations][3] = checkInDate;
        allocations[countofallocations][4] = dueDate;
        countofallocations++;

        // Update occupancy
        occupancy[roomIndex][bedIndex] = studentId;

        // Decrease available beds
        rooms[roomIndex][5] = Integer.toString(availableBeds - 1);

        System.out.println("Bed allocated successfully!");
        System.out.println("Available beds (" + roomId + "): " + (availableBeds - 1));

    }

    private static void vacateBed() {
        System.out.println("\n >>> Vacate Bed <<<");

        System.out.print("Student ID: ");
        String studentId = input.nextLine();

        System.out.print("Room ID: ");
        String roomId = input.nextLine();

        int allocationIndex = -1;
        for (int i = 0; i < countofallocations; i++) {
            if (allocations[i][0] != null &&
                    allocations[i][0].equalsIgnoreCase(studentId) &&
                    allocations[i][1].equalsIgnoreCase(roomId)) {
                allocationIndex = i;
                break;
            }
        }

        if (allocationIndex == -1) {
            System.out.println("Error: No allocation found for this student in this room.");
            return;
        }

        String bedIndexStr = allocations[allocationIndex][2];
        String checkInDate = allocations[allocationIndex][3];
        String dueDate = allocations[allocationIndex][4];

        String currentDate = LocalDate.now().toString();

        int roomIndex = -1;
        for (int i = 0; i < countofrooms; i++) {
            if (rooms[i][0].equalsIgnoreCase(roomId)) {
                roomIndex = i;
                break;
            }
        }

        int overdueDays = 0;
        double fine = 0.0;

        if (currentDate.compareTo(dueDate) > 0) {
            // Current date is after due date - calculate overdue
            overdueDays = calculateDaysBetween(dueDate, currentDate);

            // Get fee per day
            double feePerDay = Double.parseDouble(rooms[roomIndex][4]);

            // Calculate fine
            fine = overdueDays * feePerDay;

            System.out.println("Overdue days: " + overdueDays +
                    " | Fee/Day: " + feePerDay +
                    " | Fine: " + fine);
        }

        // Get bed index
        int bedIndex = Integer.parseInt(bedIndexStr);

        // Remove allocation (compact array)
        for (int i = allocationIndex; i < countofallocations - 1; i++) {
            allocations[i] = allocations[i + 1];
        }
        countofallocations--;

        // Set occupancy to null (freed bed)
        occupancy[roomIndex][bedIndex] = null;

        // Increase available beds by 1
        int availableBeds = Integer.parseInt(rooms[roomIndex][5]);
        availableBeds = availableBeds + 1;
        rooms[roomIndex][5] = Integer.toString(availableBeds);

        System.out.println("Checkout completed. Bed freed. Available beds (" + roomId + "): " + availableBeds);

    }

    // Method of transfer bed
    private static void transferBed() {
        System.out.println("\n >>> Transfer Student <<<");

        // Get Student ID
        System.out.print("Student ID: ");
        String studentId = input.nextLine().trim();

        // Get From Room
        System.out.print("From Room: ");
        String fromRoomId = input.nextLine().trim();

        // Get To Room
        System.out.print("To Room: ");
        String toRoomId = input.nextLine().trim();

        // 1. Find the allocation for this student in fromRoom
        int allocationIndex = -1;
        for (int i = 0; i < countofallocations; i++) {
            if (allocations[i][0] != null &&
                    allocations[i][0].equalsIgnoreCase(studentId) &&
                    allocations[i][1].equalsIgnoreCase(fromRoomId)) {
                allocationIndex = i;
                break;
            }
        }

        if (allocationIndex == -1) {
            System.out.println("Error: No allocation found for this student in room " + fromRoomId);
            return;
        }

        // 2. Find fromRoom index
        int fromRoomIndex = -1;
        for (int i = 0; i < countofrooms; i++) {
            if (rooms[i][0].equalsIgnoreCase(fromRoomId)) {
                fromRoomIndex = i;
                break;
            }
        }

        if (fromRoomIndex == -1) {
            System.out.println("Error: From room not found.");
            return;
        }

        // 3. Find toRoom index
        int toRoomIndex = -1;
        for (int i = 0; i < countofrooms; i++) {
            if (rooms[i][0].equalsIgnoreCase(toRoomId)) {
                toRoomIndex = i;
                break;
            }
        }

        if (toRoomIndex == -1) {
            System.out.println("Error: To room not found.");
            return;
        }

        // 4. Check if toRoom has available beds
        int toRoomAvailableBeds = Integer.parseInt(rooms[toRoomIndex][5]);
        if (toRoomAvailableBeds <= 0) {
            System.out.println("Error: No available beds in room " + toRoomId);
            return;
        }

        // 5. Find the lowest free bed in toRoom
        int toRoomCapacity = Integer.parseInt(rooms[toRoomIndex][3]);
        int newBedIndex = -1;

        for (int bed = 0; bed < toRoomCapacity; bed++) {
            if (occupancy[toRoomIndex][bed] == null) {
                newBedIndex = bed;
                break;
            }
        }

        if (newBedIndex == -1) {
            System.out.println("Error: No available beds found in target room.");
            return;
        }

        int oldBedIndex = Integer.parseInt(allocations[allocationIndex][2]);

        String checkInDate = allocations[allocationIndex][3];
        String dueDate = allocations[allocationIndex][4];

        occupancy[fromRoomIndex][oldBedIndex] = null;

        int fromRoomAvailableBeds = Integer.parseInt(rooms[fromRoomIndex][5]);
        fromRoomAvailableBeds++;
        rooms[fromRoomIndex][5] = Integer.toString(fromRoomAvailableBeds);

        occupancy[toRoomIndex][newBedIndex] = studentId;

        toRoomAvailableBeds--;
        rooms[toRoomIndex][5] = Integer.toString(toRoomAvailableBeds);

        allocations[allocationIndex][1] = toRoomId;
        allocations[allocationIndex][2] = Integer.toString(newBedIndex);

        // 13. Log transfer (you can add transfer date if needed)
        String transferDate = LocalDate.now().toString();

        System.out.println("Transferred to " + toRoomId + " Bed " + newBedIndex);
        System.out.println("Avail (" + fromRoomId + "): " + fromRoomAvailableBeds +
                " | Avail (" + toRoomId + "): " + toRoomAvailableBeds);
        System.out.println("Transfer completed on: " + transferDate);

    }

    // Method of view reports
    private static void viewReports() {

    }

    // Method of exit
    private static void Exit() {

    }

    private static int calculateDaysBetween(String startDate, String endDate) {
        // Parse start date
        String[] startParts = startDate.split("-");
        int startYear = Integer.parseInt(startParts[0]);
        int startMonth = Integer.parseInt(startParts[1]);
        int startDay = Integer.parseInt(startParts[2]);

        // Parse end date
        String[] endParts = endDate.split("-");
        int endYear = Integer.parseInt(endParts[0]);
        int endMonth = Integer.parseInt(endParts[1]);
        int endDay = Integer.parseInt(endParts[2]);

        // Convert to total days from a reference point
        int startTotalDays = startYear * 365 + startMonth * 30 + startDay;
        int endTotalDays = endYear * 365 + endMonth * 30 + endDay;

        return endTotalDays - startTotalDays;
    }
}
