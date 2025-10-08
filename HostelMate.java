import java.util.Scanner;

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
            System.out.println("\n>>>        MANAGE ROOMS MENU      <<<");
            System.out.println();
            System.out.println("1) Add Room");
            System.out.println("2) Update Room");
            System.out.println("3) Delete Room");
            System.out.println("4) Search Room");
            System.out.println("5) View All Rooms");
            System.out.println("6) Back");
            System.out.print("Choose: ");

            try {
                roomchoice = Integer.parseInt(input.nextLine());

            } catch (Exception e) {
                System.out.println("Invalid input.. Please Try again.");
                continue;
            }

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
                    System.out.println("Invalid Option..");
            }
        }

    }

    private static void addRoom() {
        System.out.println("\n>>> Add Room <<<");

        String roomId, floor, roomNo, capacityStr, feePerDayStr;

        // Room ID (must be unique)
        while (true) {
            System.out.print("Room ID: ");
            roomId = input.nextLine();

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
        System.out.print("Floor: ");
        floor = input.nextLine();

        // Room number
        System.out.print("Room No: ");
        roomNo = input.nextLine();

        // Capacity
        int capacity = 0;
        while (true) {
            System.out.print("Capacity: ");
            capacityStr = input.nextLine();
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
            System.out.print("Fee/Day (LKR): ");
            feePerDayStr = input.nextLine();
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
                System.out.println("Invalid input. Enter a valid number (e.g., 750 or 750.50).");
                continue;
            }

            // 🔹 Now safely convert to double
            feePerDay = Double.parseDouble(feePerDayStr);

            // 🔹 Non-negative check
            if (feePerDay < 0) {
                System.out.println("Error: Fee cannot be negative.");
                continue;
            }

            break;
        }

        // 6️⃣ Store in rooms array
        rooms[countofrooms][0] = roomId;
        rooms[countofrooms][1] = floor;
        rooms[countofrooms][2] = roomNo;
        rooms[countofrooms][3] = Integer.toString(capacity);
        rooms[countofrooms][4] = Double.toString(feePerDay);
        rooms[countofrooms][5] = Integer.toString(capacity); // availableBeds = capacity

        countofrooms++;
        System.out.println();
        System.out.println("Room added successfully. Available beds: " + capacity);
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

        System.out.print("New Capacity (or -): ");
        String newCap = input.nextLine();

        if (!newCap.equals("-") && !newCap.isEmpty()) {
            boolean isNumber = true;

            for (int i = 0; i < newCap.length(); i++) {
                char ch = newCap.charAt(i);
                if (ch < '0' || ch > '9') {
                    isNumber = false;
                    break;
                }
            }

            if (!isNumber) {
                System.out.println("Invalid input. Capacity must be numeric.");
            } else {
                int newCapacity = Integer.parseInt(newCap);
                if (newCapacity <= 0) {
                    System.out.println("Error: Capacity must be greater than zero.");
                } else {
                    rooms[roomIndex][3] = Integer.toString(newCapacity);
                    rooms[roomIndex][5] = Integer.toString(newCapacity);

                }
            }
        }

        // Fee-Day
        System.out.print("New Fee/Day (or -): ");
        String newFee = input.nextLine().trim();

        if (!newFee.equals("-") && !newFee.isEmpty()) {
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
                System.out.println("Invalid input. Enter valid fee (e.g. 750 or 750.50).");
            } else {
                double fee = Double.parseDouble(newFee);
                if (fee < 0) {
                    System.out.println("Error: Fee cannot be negative.");
                } else {
                    rooms[roomIndex][4] = Double.toString(fee);

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
        System.out.printf("%-6s | %-17s | %-11s | %-22s | %-8s%n",
                "ID", "Name", "Contact", "Email", "Status");
        System.out.println("----------------------------------------------------------------------------------");

        // Loop through all students
        for (int i = 0; i < countofstudents; i++) {
            // System.out.println(students[i][0] + "\t"
            // + students[i][1] + "\t\t"
            // + students[i][2] + "\t"
            // + students[i][3] + "\t"
            // + students[i][4]);
            // }
            System.out.printf("%-6s | %-17s | %-11s | %-22s | %-8s%n",
                    students[i][0], students[i][1], students[i][2],
                    students[i][3], students[i][4]);
        }

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
