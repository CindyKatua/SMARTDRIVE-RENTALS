# SmartDrive Rentals - Project Documentation

## Overview
SmartDrive Rentals is a Java-based car rental management system with a graphical user interface (GUI) built using Java Swing. The application allows users to manage car rentals, track vehicle availability, and handle customer information.

## Project Structure

### Core Classes

1. **MainWindowFrame.java**
   - The main application window
   - Handles the user interface and user interactions
   - Displays available cars and rental options

2. **Car.java**
   - Represents a car in the system
   - Contains car details: brand, model, year, price, registration number, color, and availability status

3. **Customer.java**
   - Manages customer information
   - Stores customer details like name, contact information, and rental history

4. **Rental.java**
   - Handles rental transactions
   - Manages the relationship between customers and rented cars

5. **CarDatabase.java**
   - Manages the database of available cars
   - Handles CRUD (Create, Read, Update, Delete) operations for cars

6. **DBConnection.java**
   - Manages database connections
   - Handles the connection to the underlying database

### UI Components

1. **LoginFrame.java**
   - Handles user authentication
   - Validates user credentials

2. **WelcomeFrame.java**
   - Displays a welcome screen
   - Provides navigation to different parts of the application

3. **VehicleDetailsFrame.java**
   - Shows detailed information about selected vehicles
   - Displays car specifications and availability

4. **VehicleRenderer.java**
   - Custom renderer for vehicle display in lists
   - Controls how cars are displayed in the UI

5. **BackgroundPanel.java**
   - Custom panel that can display a background image
   - Used for creating visually appealing interfaces

## How to Run the Application

1. **Prerequisites**
   - Java Development Kit (JDK) 8 or later
   - MySQL Database (if using database functionality)

2. **Running the Application**
   ```bash
   # Navigate to the src directory
   cd src
   
   # Compile all Java files
   javac *.java
   
   # Run the application
   java WelcomeFrame
   ```

## Key Features

1. **User Authentication**
   - Secure login system
   - User session management

2. **Car Management**
   - Add new cars to the system
   - Update car details
   - Remove cars from the system
   - View all available cars

3. **Rental Management**
   - Create new rentals
   - Track rental duration
   - Calculate rental costs
   - Manage returns

4. **User Interface**
   - Intuitive graphical interface
   - Responsive design
   - Visual feedback for user actions

## Database Schema

The application uses a relational database to store information. Here's a basic overview of the database structure:

- **cars**
  - id (Primary Key)
  - brand
  - model
  - year
  - price_per_day
  - registration_number
  - colour
  - is_available

- **customers**
  - id (Primary Key)
  - name
  - email
  - phone
  - address

- **rentals**
  - id (Primary Key)
  - car_id (Foreign Key)
  - customer_id (Foreign Key)
  - start_date
  - end_date
  - total_cost
  - status

## Common Operations

### Adding a New Car
1. Navigate to the 'Add Car' section
2. Fill in the car details (brand, model, year, etc.)
3. Click 'Add' to save the car to the database

### Renting a Car
1. Select a car from the available list
2. Click 'Rent'
3. Enter customer details
4. Specify rental period
5. Confirm the rental

### Returning a Car
1. Go to 'Active Rentals'
2. Select the rental to complete
3. Click 'Return'
4. Confirm the return

## Troubleshooting

1. **Database Connection Issues**
   - Verify database server is running
   - Check connection credentials in DBConnection.java
   - Ensure the database schema exists

2. **UI Rendering Problems**
   - Verify Java version compatibility
   - Check for missing image resources
   - Ensure all UI components are properly initialized

## Future Enhancements

1. Add user roles (Admin, Staff, Customer)
2. Implement payment processing
3. Add reporting features
4. Include vehicle maintenance tracking
5. Add support for additional vehicle types

## Dependencies

- Java Swing (included in Java SE)
- MySQL Connector/J (for database connectivity)

## License
[Specify License Here]
