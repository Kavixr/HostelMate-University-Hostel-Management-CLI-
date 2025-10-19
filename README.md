# 🏨 HostelMate – University Hostel Management (CLI)

A **Command-Line Interface (CLI)** application developed to manage hostel operations at universities.  
It provides secure **login authentication**, **student management**, **room management**, **bed allocation**, and **report generation** — all through an intuitive text-based interface built entirely using **Core Java and arrays**.

---

## 🔐 1. Login to the System

The **Login System** ensures that only authorized hostel administrators or wardens can access the system. It requires valid credentials to proceed and prevents unauthorized use. Incorrect inputs trigger clear error messages, encouraging correct retry attempts.

### ✨ Features
- Prompts user for **Username** and **Password**  
- Validates credentials securely  
- Re-prompts until valid credentials are entered  
- Displays a welcome message with the username

### 💬 Sample Console Output
```
***************************************************
*              WELCOME TO HOSTELMATE              *
*          University Hostel Management           *
***************************************************
                     LOGIN                         
---------------------------------------------------
>> Username : kavindu
>> Password : ********
---------------------------------------------------
Verifying credentials... Please wait...
Authentication complete. Hello, kavindu! Welcome to HostelMate.
```

---

## 🏠 2. Home Page (Main Menu)

The **Home Menu** is the navigation hub of the system, providing access to every core module. Each selection routes the user to specific management areas. Input validation ensures that users provide correct numeric choices.

### ✨ Features
- Displays all major management categories clearly  
- Ensures numeric input and re-prompts for invalid choices  
- Returns back to the main menu upon task completion  

### 💬 Sample Console Output
```
==============================================
||           HOSTELMATE MAIN MENU           ||
==============================================
  [1] Manage Rooms
  [2] Manage Students
  [3] Allocate Bed
  [4] Vacate Bed
  [5] Transfers
  [6] View Reports
  [7] Exit
==============================================
Enter your choice: 1
```

---

# 🏢 3. Manage Rooms Module

This module helps administrators manage all aspects of hostel rooms. It supports adding new rooms, modifying existing ones, deleting old rooms, and generating an overview of all rooms. It ensures data integrity and avoids duplication.

### ⚙️ Functionalities
| Option | Function | Description |
|:--:|:--|:--|
| 1 | ➕ **Add Room** | Register a new room with details such as ID, floor, number, capacity, and fee. |
| 2 | ✏️ **Update Room** | Modify room capacity or fee details without affecting existing allocations. |
| 3 | ❌ **Delete Room** | Remove a room that has no active student allocations. |
| 4 | 🔍 **Search Room** | Search for rooms by ID to view complete details. |
| 5 | 📋 **View All Rooms** | Display all registered rooms in table form. |
| 6 | 🔁 **Sort Rooms** | Sort rooms based on available beds (descending order). |
| 7 | 🔙 **Back** | Return to the main menu. |

### ➕ Add Room – Detailed Description
The **Add Room** feature ensures that each room added to the system is unique. Room IDs must not duplicate, room numbers cannot be repeated on the same floor, and capacity/fee inputs must be numeric. Invalid entries trigger descriptive error messages.

#### 💬 Example Output
```
>>> Add Room <<<
Room ID: R101
Floor: 1
Room No: 102
Capacity: 3
Fee/Day (LKR): 500
Room added successfully. Available beds: 3
```

### ✏️ Update Room – Detailed Description
Administrators can modify room capacity or fee values using this feature. It retains all other data (floor, room number). Entering a hyphen (`-`) skips updates. Input validation prevents negative or invalid data.

#### 💬 Example Output
```
>>> Update Room <<<
Enter Room ID to update: R101
New Capacity (or -): 4
New Fee/Day (LKR) (or -): 600
Room updated successfully!
Room ID: R101 | Floor: 1 | Room No: 102 | Capacity: 4 | Fee: 600 | Avail Beds: 4
```

### ❌ Delete Room – Detailed Description
Rooms can only be deleted if no active student allocations exist in them. This prevents data inconsistencies in allocation records.

#### 💬 Example Output
```
>>> Delete Room <<<
Enter Room ID: R201
Room deleted successfully.
```

### 🔍 Search Room – Detailed Description
Allows searching for rooms using Room ID and displays room information neatly in tabular format.

#### 💬 Example Output
```
>>> Search Room <<<
Enter Room ID: R102
Room found successfully!
Room ID | Floor | Room No | Capacity | Avail Beds | Fee/Day
------------------------------------------------------------
R102    | 1     | 102     | 3        | 2          | 450.00
```

### 📋 View All Rooms – Detailed Description
Displays a list of all existing rooms in a well-formatted table view.

#### 💬 Example Output
```
>>> All Rooms <<<
Room ID | Floor | Room No | Capacity | Avail Beds | Fee/Day
------------------------------------------------------------
R101    | 1     | 101     | 4        | 4          | 500.00
R102    | 1     | 102     | 3        | 2          | 450.00
R201    | 2     | 201     | 5        | 5          | 600.00
```

---

# 🎓 4. Manage Students Module

This module keeps student data structured and consistent. It handles adding, updating, deleting, and viewing student details while ensuring data accuracy and uniqueness.

### 🗂️ Structure
| Field | Description |
|:--|:--|
| `studentId` | Unique ID (e.g., S001) |
| `name` | Full name |
| `contact` | Valid 10-digit number |
| `email` | Valid email (must include @ and .) |
| `status` | Defaults to ACTIVE |

### ➕ Add Student – Detailed Description
The system validates student details such as contact numbers and email formats, and ensures uniqueness for ID, contact, and email.

#### 💬 Example Output
```
>>> Add Student <<<
Student ID: S001
Name: Nimal Perera
Contact No: 0771234567
Email: nimal@example.com
Student added successfully.
```
### ✏️ Update Student – Detailed Description
Admins can update existing student contact numbers and emails. Validation ensures the new data format is correct. If no changes are required, entering `-` skips that field.

#### 💬 Example Output
```
>>> Update Student <<<
Enter Student ID: S001
New Contact (or -): 0779998877
New Email (or -): nimal.p@example.com
Student updated successfully.
```

### ❌ Delete Student – Detailed Description
Students can only be deleted if they have no active room allocations. Once confirmed, the student’s record is removed and arrays are rearranged.

#### 💬 Example Output
```
>>> Delete Student <<<
Enter Student ID: S002
Student deleted successfully.
```

### 🔍 Search Student – Detailed Description
Allows the user to find a student by their unique ID and view all related details.

#### 💬 Example Output
```
>>> Search Student <<<
Enter Student ID: S003
Student found!
Student ID | Name | Contact | Email | Status
----------------------------------------------
S003       | Kasun Jayasuriya | 0712233445 | kasun@example.com | ACTIVE
```

### 📋 View All Students – Detailed Description
Shows all stored student records in a neat table format.

#### 💬 Example Output
```
>>> All Students <<<
Student ID | Name | Contact | Email | Status
----------------------------------------------------------
S001       | Nimal Perera | 0771234567 | nimal@example.com | ACTIVE
S002       | Tharushi Silva | 0715558899 | tharushi@example.com | ACTIVE
```

---

# 🛏️ 5. Bed Allocation Module

The **Bed Allocation Module** is a core feature of *HostelMate*, designed to streamline the process of assigning students to available hostel beds.  
It ensures every allocation is **accurate, validated, and conflict-free**, maintaining perfect synchronization between the student, room, and occupancy data tables.

Through intelligent validation and real-time updates, this module minimizes human error and ensures hostel occupancy records remain consistent across all operations.

---

## ⚙️ Functional Overview

| Step | Validation Layer | Description |
|:--:|:--|:--|
| 1 | 👩‍🎓 **Student Verification** | Ensures the student exists, is active, and not currently assigned to another room. |
| 2 | 🏠 **Room Availability Check** | Confirms the specified room exists and has vacant beds. |
| 3 | 📅 **Due Date Validation** | Validates manual date input in `YYYY-MM-DD` format and ensures it falls after the current date. |
| 4 | 🛠️ **Allocation Logic** | Locates the first available bed and reserves it for the selected student. |
| 5 | 💾 **System Update** | Records the allocation, updates the occupancy chart, and decreases the available bed count. |

---

## 🧠 Behind the Logic

- Uses **pure Core Java** (no external libraries) for validation and data handling.  
- Implements **manual date parsing** to verify format and handle leap years precisely.  
- Automatically assigns **Check-In Date** as the current system date (`LocalDate.now()`).  
- Uses a **boolean array** to detect the first free bed dynamically.  
- Prevents assigning multiple beds to the same student or exceeding room capacity.  
- Provides **context-specific error feedback** at every stage for a smooth user experience.

---

## 💬 Sample Console Interaction

```
-----------------------------------------
               ALLOCATE BED              
-----------------------------------------

Enter Student ID        : S001
Enter Room ID           : R102
Enter Due Date          : 2025-11-20

Bed allocated successfully!
-----------------------------------------
Student ID       : S001
Room ID          : R102
Allocated Bed No : 0
Due Date         : 2025-11-20
Available Beds   : 2
-----------------------------------------
```

---

## 🚫 Example Validation Feedback

```
Error: Student ID cannot be empty. Please enter a valid ID.
Error: No student found with the ID 'S009'.
Error: The selected student is inactive. Bed allocation not allowed.
Error: No available beds in Room 'R202'.
Error: Invalid date format. Please use YYYY-MM-DD.
Error: The due date you entered is not valid. Please provide a future date.
```

---

## 🧾 System Data Updates

When a bed is successfully allocated:

- **Allocations Table** → Stores:
  ```
  [ StudentID, RoomID, BedNo, CheckInDate, DueDate ]
  ```
- **Occupancy Table** → Marks the allocated bed index as occupied by the student.  
- **Rooms Table** → Automatically reduces the *Available Beds* count by 1.  

Together, these updates maintain **data integrity** across all hostel records — ensuring that occupancy, billing, and room availability always remain consistent.





