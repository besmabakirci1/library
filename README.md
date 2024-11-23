# 📚 Library Management System

Welcome to the **Library Management System** - a powerful yet easy-to-use tool for managing your library's books and members! Designed to make the management of a small library effortless, this system allows you to efficiently add, remove, search, and list books and users. Whether you're a beginner learning Java or someone who wants a simple library solution, this project has got you covered.

## ✨ Features

- **📕 Add Books**: Easily add new books to the library collection. Dynamic ISBN generation ensures each book is unique.
- **👥 Add Users**: Register new members to the library quickly and easily.
- **🔍 Search Books**: Find books by title or ISBN effortlessly.
- **🔎 Search Users**: Search for users by name with ease.
- **📚 List All Books**: View all books currently available in the library.
- **✒️ List Books by Author**: Discover books written by a specific author.
- **🗑 Remove Books and Users**: Manage and clean up the library by removing old books or users.
- **📋 View User Details**: Get detailed information about library members, including their borrowed books.
- **👨‍👩‍👧‍👦 List All Users**: See all registered users in one convenient list.

## 💻 Technologies Used

- **Java**: Developed in Java, offering a robust, object-oriented foundation.
- **JUnit**: Includes unit tests using JUnit to ensure reliability and correctness.
- **Console-based User Interface**: A simple, interactive console interface that’s beginner-friendly.

## 🚀 Getting Started

To get started with this project, you'll need the following installed on your system:

- **Java JDK** (version 8 or above)
- **Git**

### Installation Steps

1. **Clone the repository**:
   ```bash
   git clone https://github.com/yourusername/library-management-system.git
   ```
2. **Navigate to the project directory**:
   ```bash
   cd library-management-system
   ```
3. **Compile the code**:
   ```bash
   javac main/*.java
   ```
4. **Run the application**:
   ```bash
   java main.Main
   ```

## 📖 Usage

Once you start the application, you'll be greeted with an easy-to-use menu with multiple options:

1. **➕ Add a Book**: Enter the book title and author to add a new book to the library. An ISBN will be automatically generated.
2. **➕ Add a User**: Register a new user by providing their name and a unique user ID.
3. **🔍 Search for Books**: Find books by title or ISBN.
4. **🔎 Search for Users**: Look up users by their name.
5. **📚 List All Books**: View a comprehensive list of all books available in the library.
6. **✒️ List Books by Author**: Find books by a specific author.
7. **🗑 Remove Books or Users**: Remove a book by title or a user by name.
8. **👤 View User Details**: Display detailed information of a user, including the books they've borrowed.
9. **👨‍👩‍👧‍👦 List All Users**: List all the users registered in the library.
10. **🚪 Exit**: Quit the application.

## 🏗 Project Structure

The project contains the following key classes:

- **Main**: The entry point of the application, containing the menu and user interactions.
- **Book**: Represents a book with attributes like title, author, and ISBN.
- **User**: Represents a library user with attributes like name, ID, and borrowed books.
- **LibraryBookMemberLists**: Manages lists of books and users, containing methods to add, remove, and search them.
- **ISBNGenerator**: Generates unique ISBN numbers for books, ensuring each book is properly cataloged.

## 🤝 Contributing

Contributions are welcome! If you find any issues or have suggestions for improvements, please open an issue or submit a pull request.

To contribute:

1. **Fork** the repository.
2. **Create** a new branch (`git checkout -b feature-branch`).
3. **Commit** your changes (`git commit -m 'Add a new feature'`).
4. **Push** to the branch (`git push origin feature-branch`).
5. **Open** a Pull Request.

Happy coding and may your libraries always be organized and efficient! 📚✨

