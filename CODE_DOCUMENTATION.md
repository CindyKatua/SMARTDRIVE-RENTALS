# SmartDrive Rentals - Code Documentation

## Table of Contents
1. [Car.java](#carjava)
2. [MainWindowFrame.java](#mainwindowframejava)
3. [Rental.java](#rentaljava)
4. [Customer.java](#customerjava)
5. [DBConnection.java](#dbconnectionjava)
6. [LoginFrame.java](#loginframejava)

---

## Car.java

```java
// Class representing a car in the rental system
public class Car {
    // Instance variables to store car properties
    private String brand;           // Brand of the car (e.g., Toyota, Honda)
    private String model;           // Model of the car (e.g., Camry, Civic)
    private int year;               // Manufacturing year
    private double pricePerDay;     // Rental cost per day
    private String registrationNumber;  // Unique identifier for the car
    private String colour;          // Color of the car
    private boolean isAvailable;     // Availability status (true if available for rent)

    // Constructor - creates a new Car instance with the specified properties
    public Car(String brand, String model, int year, double pricePerDay,
              String registrationNumber, String colour, boolean isAvailable) {
        this.brand = brand;  // Initialize brand
        this.model = model;  // Initialize model
        this.year = year;    // Initialize manufacturing year
        this.pricePerDay = pricePerDay;  // Set daily rental price
        this.registrationNumber = registrationNumber;  // Set registration number
        this.colour = colour;  // Set car color
        this.isAvailable = isAvailable;  // Set initial availability
    }

    // Getter methods for accessing private fields
    public String getBrand() {
        return brand;  // Returns the car's brand
    }

    public String getModel() {
        return model;  // Returns the car's model
    }

    public int getYear() {
        return year;  // Returns the manufacturing year
    }

    public double getPricePerDay() {
        return pricePerDay;  // Returns the daily rental price
    }

    public String getRegistrationNumber() {
        return registrationNumber;  // Returns the registration number
    }

    public String getColour() {
        return colour;  // Returns the car's color
    }

    public boolean isAvailable() {
        return isAvailable;  // Returns the availability status
    }
    
    // Method to rent the car
    public void rent() {
        if (isAvailable) {  // Check if car is available
            isAvailable = false;  // Mark as rented
        } else {
            // Throw exception if car is already rented
            throw new IllegalStateException("Car is not available for rent");
        }
    }
    
    // Method to calculate rental cost for a given number of days
    public double calculateRentalCost(int days) {
        if (days <= 0) {  // Validate number of days
            throw new IllegalArgumentException("Rental period must be at least 1 day");
        }
        return pricePerDay * days;  // Calculate total cost
    }
    
    // Method to return a rented car
    public void returnCar() {
        isAvailable = true;  // Mark as available again
    }
}
```

## MainWindowFrame.java

```java
// Import necessary Java Swing and AWT packages
import javax.swing.*;  // For GUI components
import java.awt.*;     // For layout managers and basic graphics
import java.awt.event.MouseAdapter;  // For handling mouse events
import java.awt.event.MouseEvent;    // For mouse event details

// Main application window class
public class MainWindowFrame extends JFrame {
    // Stores the list of registered cars (temporary storage for UI)
    private DefaultListModel<String> registeredCars = new DefaultListModel<>();

    // Form fields for car details
    private JTextField brandField, modelField, colourField,
            rateField, regNumberField, regDateField;
    private JComboBox<String> availabilityBox;  // Dropdown for availability status

    // Constructor - sets up the main window
    public MainWindowFrame() {
        // Basic window setup
        setTitle("SmartDrive Rentals");  // Window title
        setSize(950, 720);               // Window size (width, height)
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // Close behavior
        setLocationRelativeTo(null);      // Center the window on screen

        // Create background panel with image
        BackgroundPanel bg = new BackgroundPanel("/images/background.PNG");
        bg.setLayout(new BorderLayout());  // Use BorderLayout for main layout
        add(bg);  // Add background to frame

        // Create scrollable content panel
        JPanel content = new JPanel();
        content.setOpaque(false);  // Make transparent to show background
        content.setLayout(new BoxLayout(content, BoxLayout.Y_AXIS));  // Vertical layout
        content.setBorder(BorderFactory.createEmptyBorder(40, 80, 80, 80));  // Add padding

        // Set up scroll pane for the content
        JScrollPane scrollPane = new JScrollPane(content);
        scrollPane.setBorder(null);  // Remove default border
        scrollPane.getViewport().setOpaque(false);  // Make viewport transparent
        scrollPane.setOpaque(false);  // Make scroll pane transparent
        scrollPane.getVerticalScrollBar().setUnitIncrement(14);  // Set scroll speed

        // Add scroll pane to background
        bg.add(scrollPane, BorderLayout.CENTER);

        // [Rest of the UI setup code would be here...]
    }
    
    // [Other methods for event handling and business logic would be here...]
}
```

## Rental.java

```java
// Class representing a car rental transaction
public class Rental {
    private Car car;              // The car being rented
    private Customer customer;    // The customer renting the car
    private String startDate;     // Rental start date
    private String endDate;       // Expected return date
    private double totalCost;     // Total rental cost
    private boolean isActive;     // Whether the rental is currently active

    // Constructor - creates a new rental record
    public Rental(Car car, Customer customer, String startDate, String endDate) {
        this.car = car;          // Set the car being rented
        this.customer = customer; // Set the customer
        this.startDate = startDate; // Set start date
        this.endDate = endDate;   // Set end date
        this.isActive = true;     // New rentals are active by default
        
        // Calculate number of days between dates (simplified)
        // In a real application, you'd use a proper date parsing library
        int days = 1;  // Default to 1 day
        this.totalCost = car.calculateRentalCost(days);  // Calculate total cost
        
        car.rent();  // Mark the car as rented
    }

    // Method to complete the rental and return the car
    public void returnCar() {
        if (isActive) {
            car.returnCar();  // Mark car as available
            isActive = false; // Mark rental as completed
        }
    }

    // Getter methods for rental details
    public Car getCar() { return car; }
    public Customer getCustomer() { return customer; }
    public String getStartDate() { return startDate; }
    public String getEndDate() { return endDate; }
    public double getTotalCost() { return totalCost; }
    public boolean isActive() { return isActive; }
}
```

## Customer.java

```java
// Class representing a customer in the system
public class Customer {
    private String name;          // Customer's full name
    private String email;         // Email address
    private String phone;         // Contact number
    private String licenseNumber; // Driver's license number

    // Constructor - creates a new customer
    public Customer(String name, String email, String phone, String licenseNumber) {
        this.name = name;           // Set customer name
        this.email = email;         // Set email
        this.phone = phone;         // Set phone number
        this.licenseNumber = licenseNumber;  // Set license number
    }

    // Getter methods for customer details
    public String getName() { return name; }
    public String getEmail() { return email; }
    public String getPhone() { return phone; }
    public String getLicenseNumber() { return licenseNumber; }

    // Setter methods (for updating customer information)
    public void setEmail(String email) { this.email = email; }
    public void setPhone(String phone) { this.phone = phone; }
}
```

## DBConnection.java

```java
// Class for managing database connections
import java.sql.*;  // For database operations

public class DBConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/smartdrive_rentals";
    private static final String USER = "root";      // Database username
    private static final String PASSWORD = "";      // Database password

    // Method to establish a database connection
    public static Connection getConnection() throws SQLException {
        try {
            // Load MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Create and return connection
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException e) {
            // Handle case where JDBC driver is not found
            throw new SQLException("Database driver not found", e);
        }
    }

    // Method to close database resources
    public static void close(Connection conn, Statement stmt, ResultSet rs) {
        try {
            if (rs != null) rs.close();        // Close result set if not null
            if (stmt != null) stmt.close();    // Close statement if not null
            if (conn != null) conn.close();    // Close connection if not null
        } catch (SQLException e) {
            // Log any errors during resource cleanup
            e.printStackTrace();
        }
    }
}
```

## LoginFrame.java

```java
// Import required packages
import javax.swing.*;  // For GUI components
import java.awt.*;     // For layout and colors
import java.awt.event.*;  // For event handling

// Login window for user authentication
public class LoginFrame extends JFrame {
    private JTextField usernameField;  // Field for username input
    private JPasswordField passwordField;  // Field for password input

    // Constructor - sets up the login window
    public LoginFrame() {
        setTitle("Login - SmartDrive Rentals");  // Window title
        setSize(400, 300);  // Window size
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // Close behavior
        setLocationRelativeTo(null);  // Center on screen

        // Main panel with padding
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        
        // Constraints for layout
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);  // Add some padding
        gbc.fill = GridBagConstraints.HORIZONTAL;  // Make components fill their space

        // Add title label
        JLabel titleLabel = new JLabel("SmartDrive Rentals", JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        panel.add(titleLabel, gbc);

        // Add username components
        gbc.gridy++;
        gbc.gridwidth = 1;
        panel.add(new JLabel("Username:"), gbc);
        
        gbc.gridx++;
        usernameField = new JTextField(15);  // Create username field
        panel.add(usernameField, gbc);

        // Add password components
        gbc.gridx = 0;
        gbc.gridy++;
        panel.add(new JLabel("Password:"), gbc);
        
        gbc.gridx++;
        passwordField = new JPasswordField(15);  // Create password field
        panel.add(passwordField, gbc);

        // Add login button
        gbc.gridx = 0;
        gbc.gridy++;
        gbc.gridwidth = 2;
        JButton loginButton = new JButton("Login");
        loginButton.addActionListener(e -> attemptLogin());  // Add click handler
        panel.add(loginButton, gbc);

        // Add the panel to the frame
        add(panel);
    }

    // Method to handle login attempts
    private void attemptLogin() {
        String username = usernameField.getText();
        String password = new String(passwordField.getPassword());

        // Simple validation (in a real app, this would check against a database)
        if (username.equals("admin") && password.equals("admin")) {
            // Login successful
            JOptionPane.showMessageDialog(this, "Login successful!");
            // Open main application window
            new MainWindowFrame().setVisible(true);
            this.dispose();  // Close login window
        } else {
            // Login failed
            JOptionPane.showMessageDialog(this, 
                "Invalid username or password", 
                "Login Failed", 
                JOptionPane.ERROR_MESSAGE);
        }
    }

    // Main method to start the application
    public static void main(String[] args) {
        // Run the GUI on the Event Dispatch Thread (EDT)
        SwingUtilities.invokeLater(() -> {
            LoginFrame frame = new LoginFrame();
            frame.setVisible(true);
        });
    }
}
```

## How to Use This Documentation

1. **For Learning**: Read through each class to understand how different components work together.
2. **For Reference**: Use the detailed comments to understand specific methods and their purposes.
3. **For Modification**: The comments will help you understand where and how to make changes safely.

## Key Design Patterns Used

1. **MVC (Model-View-Controller)**:
   - Model: `Car.java`, `Customer.java`, `Rental.java`
   - View: `MainWindowFrame.java`, `LoginFrame.java`
   - Controller: Event handlers in the UI classes

2. **Singleton Pattern**: `DBConnection.java` uses a static method to manage a single database connection.

3. **Observer Pattern**: Used in Swing components for event handling.

## Common Issues and Solutions

1. **Database Connection Fails**:
   - Ensure MySQL server is running
   - Verify database credentials in `DBConnection.java`
   - Check if the database 'smartdrive_rentals' exists

2. **UI Not Displaying Correctly**:
   - Verify all image paths in the code
   - Check for missing font issues
   - Ensure all required components are properly initialized

3. **Rental Logic Errors**:
   - Verify date calculations in the `Rental` class
   - Check availability status before processing rentals

## Testing the Application

1. **Unit Tests**:
   - Test `Car` class methods (rent, return, cost calculation)
   - Test `Rental` class for proper date handling
   - Test database connection and queries

2. **Integration Tests**:
   - Test complete rental workflow
   - Verify UI interactions with the business logic

## Performance Considerations

1. **Database**:
   - Use connection pooling for better performance
   - Add indexes to frequently queried columns

2. **Memory Management**:
   - Close database resources properly
   - Use pagination for large data sets

3. **UI Responsiveness**:
   - Perform long-running tasks in background threads
   - Update UI components on the Event Dispatch Thread (EDT)
