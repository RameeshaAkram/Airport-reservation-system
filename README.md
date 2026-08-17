# ✈️ Airport Reservation System

A Java-based **Airport Reservation System** developed as a desktop GUI application for managing airport flights, passenger bookings, staff information, invoices, and administrative operations.

The system provides separate interfaces and functionality for different airport roles, allowing users to manage flight-related operations through an easy-to-use graphical interface.

## 📌 Project Overview

The Airport Reservation System is designed to computerize basic airport reservation and management activities.

The application allows users and staff to interact with flight information, manage bookings, view available flights, generate invoices, and perform administrative tasks.

The project is implemented in **Java** using object-oriented programming concepts and GUI-based screens.

## ✨ Features

* ✈️ Flight management
* 🔎 View available flights
* 🎫 Passenger flight booking
* 👤 Passenger information management
* 🧑‍💼 Administrator management
* 👨‍✈️ Pilot management
* 👩‍✈️ Air hostess/staff management
* 📋 Flight status management
* 🧾 Invoice generation
* 🔐 Login and registration functionality
* 💾 File-based data storage
* 🖥️ Graphical User Interface (GUI)
* 🔄 Flight information updates
* 📑 View booked flights

## 👥 System Roles

### 👤 Passenger

Passengers can interact with the reservation system to:

* View available flights
* Enter personal information
* Book flights
* View booking information
* Generate/view invoices

### 🧑‍💼 Administrator

The administrator is responsible for managing airport operations, including:

* Managing flights
* Adding new flights
* Updating flight information
* Viewing flight lists
* Managing staff information
* Managing pilots
* Monitoring flight status

### 👨‍✈️ Pilot

The system provides a dedicated pilot interface for managing and viewing pilot-related information.

### 👩‍✈️ Air Hostess / Staff

The system provides staff-related screens for managing air hostess and other staff information.

## 🛠️ Technologies Used

| Technology                      | Purpose                                       |
| ------------------------------- | --------------------------------------------- |
| **Java**                        | Core application development                  |
| **Java Swing / GUI**            | Desktop graphical user interface              |
| **Object-Oriented Programming** | Application structure and design              |
| **File Handling**               | Persistent storage of flight and booking data |
| **IntelliJ IDEA**               | Development environment                       |

## 📁 Project Structure

```text
Airport Reservation System/
│
├── src/
│   ├── GUI/
│   │   ├── AddFlight.java
│   │   ├── AdminGui.java
│   │   ├── AdminRegister.java
│   │   ├── FlightsList.java
│   │   ├── GenerateInvoice.java
│   │   ├── LoginScreen.java
│   │   ├── PilotGui.java
│   │   ├── StaffScreen.java
│   │   ├── StatusScreen.java
│   │   ├── UpdateFlights.java
│   │   ├── airHostessGui.java
│   │   ├── bookedFlights.java
│   │   ├── gui.java
│   │   ├── personDetails.java
│   │   └── userScreen.java
│   │
│   ├── User/
│   │   ├── AvailableFlights.java
│   │   ├── Invoice.java
│   │   └── Passenger.java
│   │
│   ├── administrator/
│   │   ├── Administrator.java
│   │   ├── AirHostess.java
│   │   ├── BusinessClass.java
│   │   ├── Crew.java
│   │   ├── FirstClass.java
│   │   ├── Flights.java
│   │   ├── Login.java
│   │   └── Pilots.java
│   │
│   ├── ars/
│   │   ├── Filing.java
│   │   └── FlightRunner.java
│   │
│   └── extras/
│       ├── Date.java
│       └── Time.java
│
├── flights.txt
├── bookedflights.txt
├── Administrator
├── AirHostess
├── Flights
├── Pilots
└── Airport Reservation System.iml
```

## 🖥️ Main GUI Modules

The application contains multiple GUI screens for different operations.

### Login & Registration

The system provides login and administrator registration screens for accessing the application.

### Flight Management

Administrators can:

* Add flights
* Update flight information
* View flight lists
* Check flight status

### Passenger Management

Passenger-related screens allow users to provide their personal information and interact with the reservation system.

### Booking Management

The booking module manages passenger flight reservations and provides access to booked flight information.

### Invoice Generation

The system includes an invoice generation module for creating invoice information associated with reservations.

### Staff Management

Separate screens are available for pilot and air hostess/staff-related operations.

## 💾 Data Storage

The application uses **text files for storing application data**, including:

* `flights.txt` — stores flight-related information
* `bookedflights.txt` — stores booked flight information
* Other data files are used for administrator, pilot, air hostess, and flight information.

This approach demonstrates the use of Java **file handling and persistent data storage** without requiring an external database.

## ⚙️ Requirements

Before running the project, make sure you have:

* Java Development Kit (JDK)
* IntelliJ IDEA or another Java IDE
* Java Swing support

## ▶️ How to Run

### 1. Clone the repository

```bash
git clone https://github.com/RameeshaAkram/Airport-reservation-system.git
```

### 2. Open the project

Open the downloaded project in **IntelliJ IDEA**.

### 3. Configure Java

Make sure a valid JDK is selected for the project.

### 4. Run the application

Locate the main application class:

```text
src/ars/FlightRunner.java
```

Run `FlightRunner.java` to start the application.

## 🧩 OOP Concepts Demonstrated

The project demonstrates several Object-Oriented Programming concepts, including:

* Classes and Objects
* Encapsulation
* Inheritance
* Constructors
* Methods
* Data abstraction
* Modular class organization

The project separates GUI, user, administrator, and supporting functionality into different packages.

## 🎯 Project Objectives

The main objectives of this project are to:

1. Automate basic airport reservation activities.
2. Provide a user-friendly graphical interface.
3. Manage flight information efficiently.
4. Manage passenger bookings.
5. Generate reservation invoices.
6. Manage airport staff-related information.
7. Demonstrate Java Object-Oriented Programming concepts.
8. Demonstrate file handling for persistent data storage.

## 🚀 Future Improvements

Possible future improvements include:

* Database integration using MySQL or PostgreSQL
* Online flight search and reservation
* Secure user authentication
* Payment integration
* Email/SMS booking notifications
* Improved UI/UX
* Seat selection
* Reservation cancellation and refund management
* Cloud-based data storage

## 📚 Academic Project

This project was developed as a **Java desktop application** to demonstrate programming, Object-Oriented Programming, GUI development, and file-handling concepts.



---

⭐ If you find this project useful, feel free to explore the repository and its source code.
