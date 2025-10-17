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





