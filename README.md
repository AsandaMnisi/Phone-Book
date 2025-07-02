# 📞 Java CLI Phonebook Application

A lightweight Java command-line phonebook application that allows users to store, search, dial, and manage contacts with ease. Featuring support for contact saving, calling history, and favorites!

---

## 🔧 Features

📇 **Store Contacts**  
Add names and numbers to your contact list.

📞 **Dial Numbers**  
Call existing or new numbers and optionally save them.

🔍 **Search Contacts**  
Find contacts by name and take actions like call or add to favorites.

🌟 **Favorite Contacts**  
Mark frequently used contacts for easy access.

🕘 **Recently Called**  
View a list of recent calls made through the app.

---

## 📂 Project Structure

```bash
📄 Phonebook.java        # Main application logic and menu system
```

---

## 🚀 How to Run

1. Compile the program:
```bash
javac Phonebook.java
```

2. Run the compiled class:
```bash
java Phonebook
```

3. Use the menu interface to interact with your contacts.

---

## 📋 Sample Menu Options

```text
1. Dial
2. Search Contact
3. Contacts
4. Favourite Contacts
5. Recently Called
6. Exit
```

---

## 📌 Notes

- Phone numbers must be exactly **10 digits long** and numeric only.
- Contact names are saved in **lowercase** for consistency.
- Contacts and phone numbers are kept in parallel `ArrayLists`.

---

## 💡 Future Enhancements

- Data persistence with file I/O or database
- Unique contact IDs
- GUI version using JavaFX or Swing
- Import/export contacts

---

## 👨‍💻 Author

Developed by **Asanda Mnisi** as part of a learning project in Java!

