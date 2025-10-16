import java.time.LocalDate;
import java.util.*;

public class HostelMate {

    static String[][] rooms = new String[100][6];

    static String[][] students = new String[100][5];

    static String[][] allocations = new String[100][5];

    static String[][] occupancy = new String[100][10];

    static int countofstudents = 0;
    static int countofrooms = 0;
    static int countofallocations = 0;

    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {

        login();
        home();
    }

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
            System.out.println("|  6. Sort Rooms by Available Beds       |");
            System.out.println("|  7. Back                               |");
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
                    sortRoomsByAvailableBeds();
                    break;
                case 7:
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
            roomId = input.nextLine();

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
            floor = input.nextLine();

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
            roomNo = input.nextLine();

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
            System.out.print("Fee/Day (LKR)    : ");
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
        rooms[countofrooms][4] = Double.toString(feePerDay);
        rooms[countofrooms][5] = Integer.toString(capacity);

        countofrooms++;

        // Final output
        System.out.println();
        System.out.println("Room added successfully.");
        System.out.println("Available beds  : " + capacity);
        System.out.println("-----------------------------------------");
    }

    private static void updateRoom() {
        System.out.println("\n-----------------------------------------");
        System.out.println("              UPDATE ROOM                ");
        System.out.println("-----------------------------------------\n");

        System.out.print("Enter Room ID to update : ");
        String roomId = input.nextLine();

        if (roomId.isEmpty()) {
            System.out.println("Error: Room ID cannot be empty. Please enter a valid Room ID.");
            return;
        }

        int roomIndex = -1;
        for (int i = 0; i < countofrooms; i++) {
            if (rooms[i][0].equalsIgnoreCase(roomId)) {
                roomIndex = i;
                break;
            }
        }

        if (roomIndex == -1) {
            System.out.println("Error: Room with ID '" + roomId + "' not found in the system.");
            return;
        }

        // Capacity validation loop
        boolean validCapacity = false;
        while (!validCapacity) {
            System.out.print("New Capacity (or - to skip)       : ");
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
                System.out.println("Error: Capacity must contain digits only. Please try again.");
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
            System.out.print("New Fee/Day (LKR) (or - to skip)  : ");
            String newFee = input.nextLine();

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
                System.out.println("Error: Invalid input. Enter a valid number. Please try again.");
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

        System.out.println();
        System.out.println("Room updated successfully!");
        System.out.println("-----------------------------------------");
        System.out.println("Room ID          : " + rooms[roomIndex][0]);
        System.out.println("Floor            : " + rooms[roomIndex][1]);
        System.out.println("Room No          : " + rooms[roomIndex][2]);
        System.out.println("Capacity         : " + rooms[roomIndex][3]);
        System.out.println("Fee/Day (LKR)    : " + rooms[roomIndex][4]);
        System.out.println("Available Beds   : " + rooms[roomIndex][5]);
        System.out.println("-----------------------------------------");
    }

    private static void deleteRoom() {
        System.out.println("\n-----------------------------------------");
        System.out.println("              DELETE ROOM                ");
        System.out.println("-----------------------------------------\n");

        System.out.print("Enter Room ID to delete       : ");
        String roomId = input.nextLine();

        int roomIndex = -1;
        for (int i = 0; i < countofrooms; i++) {
            if (rooms[i][0].equalsIgnoreCase(roomId)) {
                roomIndex = i;
                break;
            }
        }

        if (roomId.isEmpty()) {
            System.out.println("Error: Room ID cannot be empty. Please enter a valid Room ID.");
            return;
        }

        if (roomIndex == -1) {
            System.out.println("Error: No room found with the ID '" + roomId + "'.");
            return;
        }

        // Check if this room has active allocations
        for (int i = 0; i < countofallocations; i++) {
            if (allocations[i][1] != null && allocations[i][1].equalsIgnoreCase(roomId)) {
                System.out.println("Error: Cannot delete room '" + roomId + "' as active allocations exist.");
                return;
            }
        }

        // Compact array (shift rows up)
        for (int i = roomIndex; i < countofrooms - 1; i++) {
            rooms[i] = rooms[i + 1];
        }

        countofrooms--;
        System.out.println("\nRoom deleted successfully!");
        System.out.println("-----------------------------------------");
        System.out.println("Deleted Room ID : " + roomId);
        System.out.println("-----------------------------------------");
    }

    private static void searchRoom() {
        System.out.println("\n-----------------------------------------");
        System.out.println("              SEARCH ROOM                ");
        System.out.println("-----------------------------------------\n");

        System.out.print("Enter Room ID      : ");
        String roomId = input.nextLine();

        if (roomId.isEmpty()) {
            System.out.println("Error: Room ID cannot be empty. Please enter a valid Room ID.");
            return;
        }

        int roomIndex = -1;
        for (int i = 0; i < countofrooms; i++) {
            if (rooms[i][0].equalsIgnoreCase(roomId)) {
                roomIndex = i;
                break;
            }
        }

        if (roomIndex == -1) {
            System.out.println("Error: No room found with the ID '" + roomId + "'.");
            return;
        }

        System.out.println("\nRoom found successfully!");
        System.out.println("-----------------------------------------");
        System.out.println();

        System.out.printf("%-10s | %-8s | %-10s | %-10s | %-12s | %-10s%n",
                "Room ID", "Floor", "Room No", "Capacity", "Avail Beds", "Fee/Day (LKR)");
        System.out.println("--------------------------------------------------------------------------------");

        System.out.printf("%-10s | %-8s | %-10s | %-10s | %-12s | %-10s%n",
                rooms[roomIndex][0],
                rooms[roomIndex][1],
                rooms[roomIndex][2],
                rooms[roomIndex][3],
                rooms[roomIndex][5],
                rooms[roomIndex][4]);

        System.out.println("--------------------------------------------------------------------------------");
    }

    private static void viewAllRooms() {

        System.out.println("\n-----------------------------------------");
        System.out.println("               ALL ROOMS                 ");
        System.out.println("-----------------------------------------\n");

        if (countofrooms == 0) {
            System.out.println("No rooms available in the system at the moment.");
            System.out.println("-----------------------------------------");
            return;
        }

        System.out.printf("%-10s | %-8s | %-10s | %-10s | %-12s | %-12s%n",
                "Room ID", "Floor", "Room No", "Capacity", "Avail Beds", "Fee/Day (LKR)");
        System.out.println("-------------------------------------------------------------------------------");

        for (int i = 0; i < countofrooms; i++) {
            System.out.printf("%-10s | %-8s | %-10s | %-10s | %-12s | %-12s%n",
                    rooms[i][0],
                    rooms[i][1],
                    rooms[i][2],
                    rooms[i][3],
                    rooms[i][5],
                    rooms[i][4]);
        }

        System.out.println("-------------------------------------------------------------------------------");
    }

    private static void sortRoomsByAvailableBeds() {
        if (countofrooms == 0) {
            System.out.println("\nNo rooms available to sort.");
            return;
        }

        for (int i = 0; i < countofrooms - 1; i++) {
            for (int j = 0; j < countofrooms - i - 1; j++) {
                int avail1 = Integer.parseInt(rooms[j][5]);
                int avail2 = Integer.parseInt(rooms[j + 1][5]);
                if (avail1 < avail2) { // swap if next room has more beds
                    String[] temp = rooms[j];
                    rooms[j] = rooms[j + 1];
                    rooms[j + 1] = temp;
                }
            }
        }

        System.out.println("\nRooms sorted successfully by available beds (descending).");
        System.out.println("-----------------------------------------");
        viewAllRooms();
    }

    private static void manageStudents() {
        int studentChoice;

        while (true) {
            System.out.println();
            System.out.println("==================================================");
            System.out.println("| No |           STUDENT MANAGEMENT MENU          |");
            System.out.println("==================================================");
            System.out.println("|  1 | Add Student                                |");
            System.out.println("|  2 | Update Student                             |");
            System.out.println("|  3 | Delete Student                             |");
            System.out.println("|  4 | Search Student                             |");
            System.out.println("|  5 | View All Students                          |");
            System.out.println("|  6 | Back                                       |");
            System.out.println("==================================================");
            System.out.print("Select Option: ");

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
                System.out.println("Invalid option selected! Please choose a valid menu option. ");
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
                    System.out.println("Invalid option. Kindly try again.");
            }

        }

    }

    private static void addstudent() {

        // Declare the variables
        String id;
        String name;
        String contact;
        String email;

        System.out.println("\n-----------------------------------------");
        System.out.println("              ADD STUDENT                ");
        System.out.println("-----------------------------------------\n");

        // get the student id of the student.
        while (true) {
            System.out.print("Student ID       : ");
            id = input.nextLine();

            if (id.isEmpty()) {
                System.out.println("Error: Student ID cannot be empty. Please enter a valid ID.\n");
                continue;
            }

            boolean alreadyexits = false;
            for (int i = 0; i < countofstudents; i++) {
                if (students[i][0].equalsIgnoreCase(id)) {
                    alreadyexits = true;
                    break;
                }
            }
            if (alreadyexits) {
                System.out.println("Error: Student ID already exists. Please try another one.\n");

            } else {
                break;
            }

        }

        while (true) {
            System.out.print("Name             : ");
            name = input.nextLine();

            if (name.isEmpty()) {
                System.out.println("Error: Name cannot be empty. Please enter a valid name.\n");
                continue;
            }

            boolean validName = true;
            for (int i = 0; i < name.length(); i++) {
                char ch = name.charAt(i);
                if (!Character.isLetter(ch) && ch != ' ') {
                    validName = false;
                    break;
                }
            }

            if (!validName) {
                System.out.println("Error: Name can only contain letters and spaces.\n");
                continue;
            }
            break;
        }

        // Contatct NO.
        while (true) {

            System.out.print("Contact No       : ");
            contact = input.nextLine();

            if (contact.isEmpty()) {
                System.out.println("Error: Contact number cannot be empty.\n");
                continue;
            }

            // Validation of the contact..
            if (contact.length() != 10) {
                System.out.println("Error: Contact number must contain exactly 10 digits.\n");
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
                System.out.println("Error: Contact number must contain digits only.\n");
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
                System.out.println("Error: This contact number already exists. Please try another.\n");
            } else {
                break;
            }
        }

        // Email.
        while (true) {

            System.out.print("Email            : ");
            email = input.nextLine();

            if (email.isEmpty()) {
                System.out.println("Error: Email cannot be empty. Please enter a valid email.\n");
                continue;
            }

            // Validate the email....
            if (!(email.contains("@") && email.contains("."))) {
                System.out.println("Error: Invalid email format. Please include '@' and '.'\n");
                continue;
            }

            int atIndex = email.indexOf('@');
            int lastDotIndex = email.lastIndexOf('.');

            if (atIndex < 1 || lastDotIndex < atIndex + 2 || lastDotIndex == email.length() - 1) {
                System.out.println(
                        "Error: Invalid email format. Please enter a valid email (e.g., w2051567@westminster.ac.uk).\n");
                continue;
            }

            boolean validLocal = true;
            String localPart = email.substring(0, atIndex);
            for (int i = 0; i < localPart.length(); i++) {
                char c = localPart.charAt(i);
                if (!Character.isLetterOrDigit(c) && c != '.' && c != '_' && c != '-') {
                    validLocal = false;
                    break;
                }
            }

            if (!validLocal) {
                System.out
                        .println("Error: Invalid characters \n");
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
                System.out.println("Error: This email already exists. Please use another email.\n");
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

        System.out.println("\nStudent added successfully!");
        System.out.println("-----------------------------------------");
        System.out.println("Student ID       : " + id);
        System.out.println("Name             : " + name);
        System.out.println("Contact No       : " + contact);
        System.out.println("Email Address    : " + email);
        System.out.println("Status           : Active");
        System.out.println("-----------------------------------------");

    }

    private static void updatestudent() {

        String id;
        String newcontact;
        String newemail;

        System.out.println("\n-----------------------------------------");
        System.out.println("             UPDATE STUDENT               ");
        System.out.println("-----------------------------------------\n");

        System.out.print("Enter Student ID         : ");
        id = input.nextLine();

        int ids = -1; // which row number the student is stored in student array
        for (int i = 0; i < countofstudents; i++) {
            if (students[i][0].equalsIgnoreCase(id)) {
                ids = i;
                break;
            }
        }

        if (id.isEmpty()) {
            System.out.println("Error: Student ID cannot be empty. Please enter a valid ID.");
            return;
        }

        if (ids == -1) { // not found the student
            System.out.println("Error: No student found with the given ID '" + id + "'.");
            return;
        }

        System.out.println("\nCurrent Student Details:");
        System.out.println("-----------------------------------------");
        System.out.println("Student ID       : " + students[ids][0]);
        System.out.println("Name             : " + students[ids][1]);
        System.out.println("Contact No       : " + students[ids][2]);
        System.out.println("Email Address    : " + students[ids][3]);
        System.out.println("Status           : " + students[ids][4]);
        System.out.println("-----------------------------------------");

        // Contact
        // Contact validation with loop
        boolean validContact = false;
        while (!validContact) {
            System.out.print("New Contact No (or - to skip)    : ");
            newcontact = input.nextLine();

            if (newcontact.equals("-") || newcontact.isEmpty()) {
                validContact = true;
            } else {
                if (newcontact.length() != 10) {
                    System.out.println("Error: Contact number must contain exactly 10 digits. Please try again.");
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
                        System.out.println("Error: Contact number must contain digits only. Please try again.");
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
                            System.out.println("Error: This contact number already exists. Please use another one.");
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
            System.out.print("New Email (or - to skip)         : ");
            newemail = input.nextLine();

            if (newemail.equals("-") || newemail.isEmpty()) {
                validEmail = true;
                break;
            }

            if (!newemail.contains("@") || !newemail.contains(".")) {
                System.out.println("Error: Invalid email format. Must include '@' and '.' characters.\n");
                continue;
            }

            int atIndex = newemail.indexOf('@');
            int lastDotIndex = newemail.lastIndexOf('.');

            if (atIndex < 1 || lastDotIndex < atIndex + 2 || lastDotIndex == newemail.length() - 1) {
                System.out.println("Error: Invalid email format.\n");
                continue;
            }

            // Step 3: Check allowed characters before '@'
            boolean validLocal = true;
            String localPart = newemail.substring(0, atIndex);
            for (int i = 0; i < localPart.length(); i++) {
                char c = localPart.charAt(i);
                if (!Character.isLetterOrDigit(c) && c != '.' && c != '_' && c != '-') {
                    validLocal = false;
                    break;
                }
            }

            if (!validLocal) {
                System.out
                        .println("Error: Invalid characters before '@'. Use only letters, digits, '.', '_' or '-'.\n");
                continue;
            }

            // Step 4: Check email uniqueness (ignore same student)
            boolean exists = false;
            for (int i = 0; i < countofstudents; i++) {
                if (i != ids && students[i][3].equalsIgnoreCase(newemail)) {
                    exists = true;
                    break;
                }
            }

            if (exists) {
                System.out.println("Error: This email already exists. Please use another one.\n");
                continue;
            }

            students[ids][3] = newemail;
            validEmail = true;

        }
        System.out.println("\nStudent updated successfully!");
        System.out.println("-----------------------------------------");
        System.out.println("Student ID       : " + students[ids][0]);
        System.out.println("Name             : " + students[ids][1]);
        System.out.println("Contact No       : " + students[ids][2]);
        System.out.println("Email Address    : " + students[ids][3]);
        System.out.println("Status           : " + students[ids][4]);
        System.out.println("-----------------------------------------");

    }

    private static void deletestudent() {

        String id;

        System.out.println("\n-----------------------------------------");
        System.out.println("             DELETE STUDENT               ");
        System.out.println("-----------------------------------------\n");

        System.out.print("Enter Student ID      : ");
        id = input.nextLine().trim();

        int ids = -1;
        for (int i = 0; i < countofstudents; i++) {
            if (students[i][0].equalsIgnoreCase(id)) {
                ids = i;
                break;
            }
        }

        if (id.isEmpty()) {
            System.out.println("Error: Student ID cannot be empty. Please enter a valid ID.");
            return;
        }

        if (ids == -1) {
            System.out.println("Error: No student found with the ID '" + id + "'.");
            return;
        }

        // Check for active allocations
        for (int i = 0; i < countofallocations; i++) {
            if (allocations[i][0] != null && allocations[i][0].equalsIgnoreCase(id)) {
                System.out.println("Error: Cannot delete student '" + id + " active room allocations exist.");
                return;
            }
        }

        //
        for (int i = ids; i < countofstudents - 1; i++) {
            students[i] = students[i + 1];
        }

        countofstudents--;

        System.out.println("\nStudent deleted successfully!");
        System.out.println("-----------------------------------------");
        System.out.println("Deleted Student ID : " + id);
        System.out.println("-----------------------------------------");

    }

    private static void searchstudent() {

        String id;

        System.out.println("\n-----------------------------------------");
        System.out.println("             SEARCH STUDENT              ");
        System.out.println("-----------------------------------------\n");

        System.out.print("Enter Student ID       : ");
        id = input.nextLine();

        int ids = -1;
        for (int i = 0; i < countofstudents; i++) {
            if (students[i][0].equalsIgnoreCase(id)) {
                ids = i;
                break;
            }
        }

        if (id.isEmpty()) {
            System.out.println("Error: Student ID cannot be empty. Please enter a valid ID.");
            return;
        }

        if (ids == -1) {
            System.out.println("Error: No student found with the ID '" + id + "'.");
            return;
        }

        System.out.println("\nStudent record found successfully!");
        System.out.println("-----------------------------------------");
        System.out.printf("%-10s | %-20s | %-12s | %-25s | %-8s%n",
                "Student ID", "Full Name", "Contact No", "Email Address", "Status");
        System.out.println("---------------------------------------------------------------------------------------");

        System.out.printf("%-10s | %-20s | %-12s | %-25s | %-8s%n",
                students[ids][0],
                students[ids][1],
                students[ids][2],
                students[ids][3],
                students[ids][4]);

        System.out.println("---------------------------------------------------------------------------------------");
    }

    private static void viewAllStudents() {
        System.out.println("\n===================================================");
        System.out.println("                   ALL STUDENTS                   ");
        System.out.println("===================================================\n");

        if (countofstudents == 0) {
            System.out.println("No student records available in the system.");
            System.out.println("===================================================");
            return;
        }

        // Table Header
        System.out.printf("%-10s | %-25s | %-12s | %-30s | %-10s%n",
                "Student ID", "Full Name", "Contact No", "Email Address", "Status");
        System.out.println(
                "-----------------------------------------------------------------------------------------------------------------------");

        // Display All Student Records
        for (int i = 0; i < countofstudents; i++) {
            System.out.printf("%-10s | %-25s | %-12s | %-30s | %-10s%n",
                    students[i][0],
                    students[i][1],
                    students[i][2],
                    students[i][3],
                    students[i][4]);
        }

        System.out.println(
                "-----------------------------------------------------------------------------------------------------------------------");
        System.out.println("Total Students: " + countofstudents);
        System.out.println("===================================================");
    }

    private static void allocateBed() {

        System.out.println("\n-----------------------------------------");
        System.out.println("               ALLOCATE BED              ");
        System.out.println("-----------------------------------------\n");

        String studentId = "";
        String roomId = "";
        String dueDate = "";
        String checkInDate = LocalDate.now().toString();
        int studentno = -1;
        int roomIndex = -1;

        while (true) {
            System.out.print("Enter Student ID        : ");
            studentId = input.nextLine();

            // Find student
            studentno = -1;
            for (int i = 0; i < countofstudents; i++) {
                if (students[i][0].equalsIgnoreCase(studentId)) {
                    studentno = i;
                    break;
                }
            }

            if (studentId.isEmpty()) {
                System.out.println("Error: Student ID cannot be empty. Please enter a valid ID.");
                continue;
            }

            if (studentno == -1) {
                System.out.println("Error: No student found with the ID '" + studentId + "'.");
                continue;
            }

            // Check if student is inactive
            if (students[studentno][4].equalsIgnoreCase("Inactive")) {
                System.out.println("Error: The selected student is inactive. Bed allocation not allowed.");
                continue;
            }

            // Check if student already has an active allocation
            boolean hasAllocation = false;
            for (int i = 0; i < countofallocations; i++) {
                if (allocations[i][0] != null && allocations[i][0].equalsIgnoreCase(studentId)) {
                    hasAllocation = true;
                    break;
                }
            }
            if (hasAllocation) {
                System.out.println("Error: The selected student already has an active bed allocation.");
                continue;
            }
            break;
        }

        while (true) {

            System.out.print("Enter Room ID           : ");
            roomId = input.nextLine();

            // Find room
            roomIndex = -1;
            for (int i = 0; i < countofrooms; i++) {
                if (rooms[i][0].equalsIgnoreCase(roomId)) {
                    roomIndex = i;
                    break;
                }
            }

            if (roomId.isEmpty()) {
                System.out.println("Error: Room ID cannot be empty. Please enter a valid Room ID.");
                continue;
            }

            if (roomIndex == -1) {
                System.out.println("Error: No room found with the ID '" + roomId + "'.");
                continue;
            }

            // Check available beds
            int availableBeds = Integer.parseInt(rooms[roomIndex][5]);
            if (availableBeds <= 0) {
                System.out.println("Error: No available beds in Room '" + roomId + "'.");
                continue;
            }
            break;
        }

        while (true) {
            System.out.print("Enter Due Date          : ");
            dueDate = input.nextLine();

            // Manual date format validation - NO REGEX
            if (dueDate.length() != 10) {
                System.out.println("Error: Invalid date format. Please use YYYY-MM-DD.");
                continue;
            }

            // Check positions of dashes
            if (dueDate.charAt(4) != '-' || dueDate.charAt(7) != '-') {
                System.out.println("Error: Invalid date format. Please use YYYY-MM-DD.");
                continue;
            }

            // Check if year, month, day parts are digits
            boolean isValidFormat = true;

            for (int i = 0; i < dueDate.length(); i++) {
                if (i == 4 || i == 7)
                    continue;
                char ch = dueDate.charAt(i);
                if (ch < '0' || ch > '9') {
                    isValidFormat = false;
                    break;
                }
            }

            if (!isValidFormat) {
                System.out.println("Error: Invalid date format. Please use YYYY-MM-DD.");
                continue;
            }

            int year = Integer.parseInt(dueDate.substring(0, 4));
            int month = Integer.parseInt(dueDate.substring(5, 7));
            int day = Integer.parseInt(dueDate.substring(8, 10));

            // Validate month
            if (month < 1 || month > 12) {
                System.out.println("Error: Invalid month value. Month must be between 01 and 12.");
                continue;
            }

            // Determine max days in month
            int maxDays;
            if (month == 1 || month == 3 || month == 5 || month == 7 ||
                    month == 8 || month == 10 || month == 12) {
                maxDays = 31;
            } else if (month == 4 || month == 6 || month == 9 || month == 11) {
                maxDays = 30;
            } else {
                // February - check leap year
                boolean isLeap = (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
                maxDays = isLeap ? 29 : 28;
            }

            // Validate day
            if (day < 1 || day > maxDays) {
                System.out.println(
                        "Error: Invalid day value. For month " + month + ", valid days are 01 to " + maxDays + ".");
                continue;
            }

            checkInDate = LocalDate.now().toString();

            // Due date must be after check-in date
            if (dueDate.compareTo(checkInDate) <= 0) {
                System.out.println("The due date you entered is not valid. Please provide a future date.");
                continue;

            }
            break;

        }

        int availableBeds = Integer.parseInt(rooms[roomIndex][5]);
        int capacity = Integer.parseInt(rooms[roomIndex][3]);
        boolean[] bedOccupied = new boolean[capacity];

        for (int i = 0; i < countofallocations; i++) {
            if (allocations[i][1] != null && allocations[i][1].equalsIgnoreCase(roomId)) {
                int bedNum = Integer.parseInt(allocations[i][2]);
                bedOccupied[bedNum] = true;
            }
        }

        int bedIndex = -1;
        for (int i = 0; i < capacity; i++) {
            if (!bedOccupied[i]) {
                bedIndex = i;
                break;
            }
        }

        if (bedIndex == -1) {
            System.out.println("Error: No available beds in this room.");
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

        System.out.println("\nBed allocated successfully!");
        System.out.println("-----------------------------------------");
        System.out.println("Student ID       : " + studentId);
        System.out.println("Room ID          : " + roomId);
        System.out.println("Allocated Bed No : " + (bedIndex));
        // System.out.println("Check-In Date : " + checkInDate);
        System.out.println("Due Date         : " + dueDate);
        System.out.println("Available Beds   : " + (availableBeds - 1));
        System.out.println("-----------------------------------------");

    }

    private static void vacateBed() {
        System.out.println("\n-----------------------------------------");
        System.out.println("               VACATE BED                ");
        System.out.println("-----------------------------------------\n");

        System.out.print("Enter Student ID                : ");
        String studentId = input.nextLine();

        System.out.print("Enter Room ID                   : ");
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

        if (studentId.isEmpty() || roomId.isEmpty()) {
            System.out.println("Error: Student ID or Room ID cannot be empty. Please enter valid values.");
            return;
        }

        if (allocationIndex == -1) {
            System.out.println(
                    "Error: No active allocation found for Student '" + studentId + "' in Room '" + roomId + "'.");
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

            System.out.println("\n-----------------------------------------");
            System.out.println("Overdue Information");
            System.out.println("-----------------------------------------");
            System.out.println("Overdue Days     : " + overdueDays);
            System.out.println("Fee per Day (LKR): " + feePerDay);
            System.out.println("Total Fine (LKR) : " + fine);
            System.out.println("-----------------------------------------\n");
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

        System.out.println("Checkout completed successfully! The assigned bed has been freed.");
        System.out.println("---------------------------------------------------------");
        System.out.println("Student ID                      : " + studentId);
        System.out.println("Room ID                         : " + roomId);
        System.out.println("Bed Index                       : " + (bedIndex + 1));
        System.out.println("Available Beds (" + roomId + ")   : " + availableBeds);
        System.out.println("---------------------------------------------------------");

    }

    private static void transferBed() {
        System.out.println("\n-----------------------------------------");
        System.out.println("             TRANSFER STUDENT            ");
        System.out.println("-----------------------------------------\n");

        // Get Student ID
        System.out.print("Enter Student ID               : ");
        String studentId = input.nextLine();

        // Get From Room
        System.out.print("From Room ID                   : ");
        String fromRoomId = input.nextLine();

        // Get To Room
        System.out.print("To Room ID                     : ");
        String toRoomId = input.nextLine();

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

        if (studentId.isEmpty() || fromRoomId.isEmpty() || toRoomId.isEmpty()) {
            System.out.println("Error: All fields (Student ID, From Room, To Room) are required.");
            return;
        }

        if (allocationIndex == -1) {
            System.out.println("Error: No active bed allocation found for Student '" + studentId + "' in Room '"
                    + fromRoomId + "'.");
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
            System.out.println(
                    "The specified source room ('" + fromRoomId + "') could not be located in the system records.");
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
            System.out.println(
                    "The specified destination room ('" + toRoomId + "') could not be located in the system records.");
            return;
        }

        // 4. Check if toRoom has available beds
        int toRoomAvailableBeds = Integer.parseInt(rooms[toRoomIndex][5]);
        if (toRoomAvailableBeds <= 0) {
            System.out.println("Error: No available beds in Room '" + toRoomId + "'.");
            return;
        }

        int toRoomCapacity = Integer.parseInt(rooms[toRoomIndex][3]);
        int newBedIndex = -1;

        for (int bed = 0; bed < toRoomCapacity; bed++) {
            if (occupancy[toRoomIndex][bed] == null) {
                newBedIndex = bed;
                break;
            }
        }

        if (newBedIndex == -1) {
            System.out.println("Error: No empty bed slots found in Room '" + toRoomId + "'.");
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

        String transferDate = LocalDate.now().toString();

        System.out.println("\nStudent transfer completed successfully!");
        System.out.println("-----------------------------------------");
        System.out.println("Student ID       : " + studentId);
        System.out.println("From Room        : " + fromRoomId);
        System.out.println("To Room          : " + toRoomId);
        System.out.println("New Bed Index    : " + (newBedIndex + 1));
        System.out.println("Check-In Date    : " + checkInDate);
        System.out.println("Due Date         : " + dueDate);
        System.out.println("Transfer Date    : " + transferDate);
        System.out.println("-----------------------------------------");
        System.out.println("Available Beds   :");
        System.out.println(" - " + fromRoomId + " → " + fromRoomAvailableBeds + " beds remaining");
        System.out.println(" - " + toRoomId + " → " + toRoomAvailableBeds + " beds remaining");
        System.out.println("-----------------------------------------");
    }

    private static void viewReports() {
        int reportChoice;

        while (true) {
            System.out.println();
            System.out.println("==========================================");
            System.out.println("|            VIEW REPORTS MENU            |");
            System.out.println("==========================================");
            System.out.println("|  1. Occupancy Map                       |");
            System.out.println("|  2. Vacant Beds by Floor                |");
            System.out.println("|  3. Students per Room                   |");
            System.out.println("|  4. Overdue Dues                        |");
            System.out.println("|  5. Revenue Projection (Daily)          |");
            System.out.println("|  6. Back                                |");
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

            reportChoice = Integer.parseInt(rChoice);

            switch (reportChoice) {
                case 1:
                    occupancyMapReport();
                    break;
                case 2:
                    vacantBedsByFloorReport();
                    break;
                case 3:
                    studentsPerRoomReport();
                    break;
                case 4:
                    overdueDuesReport();
                    break;
                case 5:
                    revenueProjectionReport();
                    break;
                case 6:
                    return; // Back to main menu
                default:
                    System.out.println("Invalid option! Please enter a valid choice.");
            }
        }

    }

    private static void occupancyMapReport() {
        System.out.println("\n-----------------------------------------");
        System.out.println("           OCCUPANCY MAP (Grid)          ");
        System.out.println("-----------------------------------------");
        System.out.printf("%-10s %-60s%n", "Room ID", "Beds");
        System.out.println("-----------------------------------------");

        for (int i = 0; i < countofrooms; i++) {
            System.out.printf("%-10s ", rooms[i][0]);

            int capacity = Integer.parseInt(rooms[i][3]);
            for (int bed = 0; bed < capacity; bed++) {
                if (occupancy[i][bed] != null)
                    System.out.printf("[%s]", occupancy[i][bed]);
                else
                    System.out.print("[empty]");

                if (bed < capacity - 1)
                    System.out.print(" | ");
            }
            System.out.println();
        }

        System.out.println("-----------------------------------------");
    }

    private static void vacantBedsByFloorReport() {
        System.out.println("\n-----------------------------------------");
        System.out.println("          VACANT BEDS BY FLOOR           ");
        System.out.println("-----------------------------------------");
        System.out.printf("%-8s %-12s %-12s %-12s %-12s%n",
                "Floor", "TotalRooms", "TotalBeds", "Occupied", "Vacant");
        System.out.println("-----------------------------------------------------------");

        int[] floors = new int[countofrooms];
        int floorCount = 0;

        for (int i = 0; i < countofrooms; i++) {
            int floorNo = Integer.parseInt(rooms[i][1]);
            boolean alreadyExists = false;

            for (int j = 0; j < floorCount; j++) {
                if (floors[j] == floorNo) {
                    alreadyExists = true;
                    break;
                }
            }

            if (!alreadyExists) {
                floors[floorCount++] = floorNo; 
            }
        }

        for (int fIndex = 0; fIndex < floorCount; fIndex++) {
            int f = floors[fIndex];
            int totalRooms = 0, totalBeds = 0, occupied = 0, vacant = 0;

            for (int i = 0; i < countofrooms; i++) {
                if (Integer.parseInt(rooms[i][1]) == f) {
                    totalRooms++;
                    int capacity = Integer.parseInt(rooms[i][3]);
                    int available = Integer.parseInt(rooms[i][5]);
                    totalBeds += capacity;
                    vacant += available;
                    occupied += (capacity - available);
                }
            }

            System.out.printf("%-8d %-12d %-12d %-12d %-12d%n",
                    f, totalRooms, totalBeds, occupied, vacant);
        }

        System.out.println("-----------------------------------------------------------");
    }

    private static void studentsPerRoomReport() {
        System.out.println("\n-----------------------------------------");
        System.out.println("             STUDENTS PER ROOM           ");
        System.out.println("-----------------------------------------");
        System.out.printf("%-10s %-8s %-20s%n", "Room", "Count", "Students");
        System.out.println("------------------------------------------------------");

        for (int i = 0; i < countofrooms; i++) {
            int capacity = Integer.parseInt(rooms[i][3]);
            String roomId = rooms[i][0];
            int count = 0;
            String studentsList = "";

            for (int bed = 0; bed < capacity; bed++) {
                if (occupancy[i][bed] != null) {
                    count++;
                    studentsList += occupancy[i][bed] + ",";
                }
            }

            if (count > 0) {
                if (studentsList.endsWith(",")) {
                    studentsList = studentsList.substring(0, studentsList.length() - 1);
                }

                System.out.printf("%-10s %-8d %-20s%n", roomId, count, studentsList);
            }
        }
        System.out.println("------------------------------------------------------");
    }

    private static void overdueDuesReport() {
        System.out.println("\n-----------------------------------------");
        System.out.println("              OVERDUE DUES               ");
        System.out.println("-----------------------------------------");
        System.out.printf("%-10s %-10s %-12s %-12s %-12s%n",
                "Student", "Room", "DaysOverdue", "Fee/Day", "EstimatedFine");
        System.out.println("---------------------------------------------------------------");

        String today = LocalDate.now().toString();
        boolean found = false;

        for (int i = 0; i < countofallocations; i++) {
            String studentId = allocations[i][0];
            String roomId = allocations[i][1];
            String dueDate = allocations[i][4];

            if (today.compareTo(dueDate) > 0) {
                int days = calculateDaysBetween(dueDate, today);

                // find room index
                int roomIndex = -1;
                for (int r = 0; r < countofrooms; r++) {
                    if (rooms[r][0].equalsIgnoreCase(roomId)) {
                        roomIndex = r;
                        break;
                    }
                }

                if (roomIndex != -1) {
                    double feePerDay = Double.parseDouble(rooms[roomIndex][4]);
                    double fine = days * feePerDay;
                    System.out.printf("%-10s %-10s %-12d %-12.2f %-12.2f%n",
                            studentId, roomId, days, feePerDay, fine);
                    found = true;
                }
            }
        }

        if (!found) {
            System.out.println("No overdue records found.");
        }
        System.out.println("---------------------------------------------------------------");
    }

    private static void revenueProjectionReport() {
        System.out.println("\n-----------------------------------------");
        System.out.println("         REVENUE PROJECTION (Daily)      ");
        System.out.println("-----------------------------------------");

        double totalRevenue = 0.0;

        for (int i = 0; i < countofrooms; i++) {
            int capacity = Integer.parseInt(rooms[i][3]);
            int available = Integer.parseInt(rooms[i][5]);
            int occupied = capacity - available;

            if (occupied > 0) {
                double fee = Double.parseDouble(rooms[i][4]);
                totalRevenue += occupied * fee;
            }
        }

        System.out.printf("Total Estimated Daily Revenue: %.2f LKR%n", totalRevenue);
        System.out.println("-----------------------------------------");
    }

    private static void Exit() {
        System.out.println();
        System.out.println("========================================================");
        System.out.println("||                                                    ||");
        System.out.println("||          Thank you for using HostelMate!           ||");
        System.out.println("||     University Hostel Management System (2025)     ||");
        System.out.println("||                                                    ||");
        System.out.println("||            Developed by Kavindu Rajapaksha         ||");
        System.out.println("||                                                    ||");
        System.out.println("||          System exiting... Please wait.            ||");
        System.out.println("========================================================");
        System.out.println("Goodbye and have a great day!");
        System.exit(0);
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
