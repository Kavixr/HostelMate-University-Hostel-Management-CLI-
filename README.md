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




