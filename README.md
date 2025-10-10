# 🏨 HostelMate – University Hostel Management (CLI)

A **Command-Line Interface (CLI)** application designed to manage hostel operations at universities.  
The system provides **secure login**, **student management**, and key hostel functionalities such as **room management**, **bed allocation**, and **report generation** — all through a simple text-based interface.


## 🔐 1. Login to the System

The system starts with a secure **login screen** that prompts the user to enter their username and password.  
If incorrect credentials are entered, the system automatically **re-prompts** until valid details are provided.

### ✨ Features
- Prompts for **Username** and **Password**  
- Validates credentials and re-prompts if invalid  
- Displays a **success message** with the logged-in username  

### 💬 Sample Console Output
```
=== HostelMate Login ===
Username: ****
Password: ****
Login successful. Welcome, warden!
```

---

## 🏠 2. Home Page (Main Menu)

After successful login, the user is directed to the **main menu**, which serves as the central hub of the system.  
From here, the user can access all available management modules and perform administrative actions.

### ✨ Features
- Displays all major hostel management options  
- Validates numeric input (re-prompts for invalid entries)  
- Navigates to the selected module  
- Returns to the main menu after completing each task  

### 💬 Sample Console Output
```
=== HostelMate ===
1) Manage Rooms
2) Manage Students
3) Allocate Bed
4) Vacate Bed
5) Transfers
6) View Reports
7) Exit
Choose: _
```

---

## 🎓 3. Manage Students

The **Manage Students** module enables hostel wardens or admins to efficiently **add**, **update**, **delete**, **search**, and **view** student records.  
All actions ensure proper validation for data consistency and uniqueness.

### 🗂️ Data Structure
Each student record contains the following fields:

| Field       | Description                       |
|-------------|-----------------------------------|
| `studentId` | Unique ID (e.g., `S001`)          |
| `name`      | Full name of the student          |
| `contact`   | Valid 10-digit contact number     |
| `email`     | Valid email address               |
| `status`    | Defaults to **ACTIVE**            |

### 📋 Menu Options
```
>>>        HOSTELMATE MENU      <<<

1) Add Student
2) Update Student
3) Delete Student
4) Search Student
5) View All Students
6) Back
Choose ---> 
```

### ✨ Functionalities

#### ➕ Add Student
- Ensures **unique Student ID**, **unique contact**, and **unique email**
- Validates:
  - Contact → must be 10 digits, numeric only  
  - Email → must include `@` and `.`
- Sets **status = ACTIVE** by default  

✅ **Example Output:**
```
>>> Add Student <<<
Student ID: S001
Name: Nimal Perera
Contact NO: 0771234567
Email: nimal@example.com
Student added successfully.
```

---

#### ✏️ Update Student
- Locate student by ID  
- Update **contact** and/or **email**  
- Enter `-` to skip updating a field  
- Checks new values for validity and uniqueness  

✅ **Example Output:**
```
>>> Update Student <<<
Enter Student ID: S001
New Contact (or -): 0779876543
New Email (or -): nimal.p@example.com
Updated: S001 | Nimal Perera | 0779876543 | nimal.p@example.com | ACTIVE
```

---

#### ❌ Delete Student
- Deletes record **only if no active allocation exists**  
- Automatically rearranges the array after deletion  

✅ **Example Output:**
```
>>> Delete Student <<<
Enter Student ID: S001
Student deleted successfully.
```

---

#### 🔍 Search Student
- Search student by **Student ID**  
- Displays results in a structured table format  

✅ **Example Output:**
```
>>> Search Student <<<
Enter Student ID: S002
Found
ID     | Name              | Contact     | Email                  | Status
----------------------------------------------------------------------------------
S002   | Tharushi Silva    | 0715558899  | tharushi@example.com   | ACTIVE
```

---

#### 📑 View All Students
- Displays all students in a table format  
- Includes: ID, Name, Contact, Email, and Status  

✅ **Example Output:**
```
>>> All Students <<<

ID     | Name              | Contact     | Email                  | Status
----------------------------------------------------------------------------------
S001   | Nimal Perera      | 0771234567  | nimal@example.com      | ACTIVE
S002   | Tharushi Silva    | 0715558899  | tharushi@example.com   | ACTIVE
S003   | Kasun Jayasuriya  | 0752233445  | kasun@example.com      | ACTIVE
```

---

## 🚀 How to Run

1. Open the project in your preferred Java IDE (IntelliJ IDEA, Eclipse, or NetBeans).  
2. Ensure the arrays `students[][]` and `allocations[][]` are initialized.  
3. Run the program from the main class.  
4. Log in using valid credentials.  
5. Navigate using the **Home Menu** options.  

---

## 📌 Notes

- Student deletion is **blocked** if an active bed allocation exists.  
- Validation ensures **no duplicate Student IDs, contacts, or emails**.  
- The system is designed for **console-based execution**, but can easily be extended into a **GUI** or **database-integrated** version in the future.  


