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


