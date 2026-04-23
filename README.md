# Phone Contact Manager

A JavaFX desktop application for managing phone contacts. Built as a lecture demonstration for the Advanced Java course, showing how to apply the Stream API and functional programming in a real GUI project.

---

## Features

- Loads contacts automatically from a CSV file on startup
- Displays total contact count in the UI
- Group contacts by relationship or by first name using `Collectors.groupingBy()`
- Sort contacts alphabetically by full name using `Comparator.comparing()`
- Filter favorite contacts using a checkbox and `.filter()`
- Controls reset automatically when switching between features

---

## Project Structure

```
src/
├── app/
│   └── Main.java                  # Application entry point
├── controllers/
│   └── MainAppController.java     # FXML controller with all stream logic
├── models/
│   └── Contact.java               # Contact model with createHeader() method
├── views/
│   ├── MainApp.fxml               # Main UI layout
│   └── MenuBar.fxml               # Menu bar layout
├── styles/                        # CSS stylesheets
└── data/
    └── contacts.csv               # Contact data file
```

---

## How It Works

**Loading data:**
Contacts are read from `contacts.csv` using `Files.lines()`, parsed with `.map()`, and stored in a `Map<Integer, Contact>` using `Collectors.toMap()`.

**Group by:**
Uses `Collectors.groupingBy()` to group contacts by relationship or first name, then injects section headers into the `ListView` using `Contact.createHeader()`.

**Sort by:**
Uses `.sorted(Comparator.comparing())` to sort contacts alphabetically by full name.

**Favorites:**
Uses `.filter(contact -> contact.getFavorite())` to show only starred contacts.

---

## CSV Format

```
id,name,phone,email,relationship,favorite
1,Ahmed Ali,0599000001,ahmed@mail.com,friend,true
2,Sara Nasser,0599000002,sara@mail.com,family,false
```

---

## Requirements

- Java 17 or later
- JavaFX 17 or later
- NetBeans IDE (recommended) or any IDE with JavaFX support

---

## How to Run

1. Clone the repository
2. Open the project in NetBeans or your IDE
3. Make sure JavaFX is configured in your project libraries
4. Add your contacts to `src/data/contacts.csv`
5. Run `Main.java`

---

## Course

Advanced Java — taught by **Aya Al-Harazin**

---

## Lecture Video

This project was built live during the following lecture. Watch it to follow along with the full explanation and code walkthrough.

[![Watch the lecture](https://youtu.be/_OiU9RdNXmQ?si=d1V_WplTHd3l8OhS)](YOUR_VIDEO_LINK_HERE)

> **Building a JavaFX Contacts Manager with Streams and Functional Programming | Advanced Java**
>
> Topics covered: project structure · reading CSV with Streams · `Collectors.toMap()` · `groupingBy()` · `Comparator.comparing()` · `.filter()` · ListView headers
