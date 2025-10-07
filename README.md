# 🏨 HostelMate-University-Hostel-Management-CLI-

## 🔐 Login to the System

The system starts with a **login screen** where the user must enter valid credentials to access HostelMate.  
If the credentials are incorrect, the system will **re-prompt** until the correct username and password are provided.  

### 📝 Features
- ⌨️ **Username & Password prompt**  
- ✅ **Validation** for correct credentials  
- 🔄 **Re-prompt until valid login**  
- 🎉 **Success message** with a personalized welcome 


## 🎓 Manage Students

The **Manage Students** module enables hostel wardens/admins to **add, update, delete, search, and view** student records.  
It ensures data validation (unique IDs, valid contacts, proper emails) to maintain data integrity.

---

### 🗂️ Data Structure

Student details are stored in a **2D String array** with the following fields:

| Field       | Description                       |
|-------------|-----------------------------------|
| `studentId` | Unique identifier (e.g., `S001`)  |
| `name`      | Full name of the student          |
| `contact`   | 10-digit valid contact number     |
| `email`     | Valid email address               |
| `status`    | Defaults to **ACTIVE**            |

---

### 📋 Menu Options

When you enter the **Manage Students** section, the following menu is displayed:

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

---

### 🧩 Functionalities

#### ➕ Add Student
- Ensures **unique Student ID**  
- Validates:
  - 📱 **Contact** → 10 digits, numeric only, unique  
  - 📧 **Email** → must contain `@` and `.`, unique  
- Sets **status = ACTIVE** by default  

✅ **Example:**
```
>>> Add Student <<<
Student ID: S001
Name: Nimal Perera
Contact NO: 0771234567
Email: nimal@example.com
Student added Successfully..
```

---

#### ✏️ Update Student
- Search student by ID  
- Update **Contact** and/or **Email**  
- Enter `-` to **skip updating** a field  
- Ensures updated values are valid & unique  

✅ **Example:**
```
>>> Update Student <<<
Enter the Student ID: S001
New Contact (or -): 0779876543
New Email (or -): nimal.p@example.com
Updated: S001 | Nimal Perera | 0779876543 | nimal.p@example.com | ACTIVE
```

---




