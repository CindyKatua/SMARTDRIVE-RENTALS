import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MainWindowFrame extends JFrame {

    // Stores registered cars (temporary, UI-only)
    private DefaultListModel<String> registeredCars = new DefaultListModel<>();

    // Form fields
    private JTextField brandField, modelField, colourField,
            rateField, regNumberField, regDateField;
    private JComboBox<String> availabilityBox;

    public MainWindowFrame() {

        setTitle("SmartDrive Rentals");
        setSize(950, 720);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        BackgroundPanel bg = new BackgroundPanel("/images/background.PNG");
        bg.setLayout(new BorderLayout());
        add(bg);

        // ================= SCROLL ENABLE =================
        JPanel content = new JPanel();
        content.setOpaque(false);
        content.setLayout(new BoxLayout(content, BoxLayout.Y_AXIS));
        content.setBorder(BorderFactory.createEmptyBorder(40, 80, 80, 80));

        JScrollPane scrollPane = new JScrollPane(content);
        scrollPane.setBorder(null);
        scrollPane.getViewport().setOpaque(false);
        scrollPane.setOpaque(false);
        scrollPane.getVerticalScrollBar().setUnitIncrement(14);

        bg.add(scrollPane, BorderLayout.CENTER);

        // ****** TITLE ******
        JLabel title = new JLabel("Drive Without Limits");
        title.setFont(new Font("Serif", Font.BOLD, 36));
        title.setForeground(new Color(15, 40, 90));

        JLabel line1 = new JLabel("No commitments.");
        line1.setFont(new Font("Arial", Font.BOLD, 18));
        line1.setForeground(new Color(40, 40, 40));

        JLabel line2 = new JLabel("For as long as you like.");
        line2.setFont(new Font("Arial", Font.BOLD, 18));
        line2.setForeground(new Color(40, 40, 40));

        content.add(title);
        content.add(Box.createVerticalStrut(10));
        content.add(line1);
        content.add(line2);
        content.add(Box.createVerticalStrut(40));

        // _____VEHICLE GRID ______
        JPanel vehicleGrid = new JPanel(new GridLayout(0, 2, 30, 30));
        vehicleGrid.setOpaque(false);

        vehicleGrid.add(createVehicleCard("Toyota Corolla", true));
        vehicleGrid.add(createVehicleCard("Honda Civic", false));
        vehicleGrid.add(createVehicleCard("Range Rover Sport", true));
        vehicleGrid.add(createVehicleCard("BMW X5", true));
        vehicleGrid.add(createVehicleCard("Hyundai Elantra", false));
        vehicleGrid.add(createVehicleCard("Mercedes C-Class", true));

        content.add(vehicleGrid);
        content.add(Box.createVerticalStrut(50));

        // ================= REGISTRATION FORM =================
        JPanel formPanel = new JPanel(new GridBagLayout());
        formPanel.setBackground(new Color(255, 255, 255, 210));
        formPanel.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(Color.GRAY),
                "Register new Vehicle"));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8, 10, 8, 10);
        gbc.anchor = GridBagConstraints.WEST;

        Font labelFont = new Font("Arial", Font.BOLD, 14);

        brandField = createField();
        modelField = createField();
        colourField = createField();
        rateField = createField();
        regNumberField = createField();
        regDateField = createField();

        availabilityBox = new JComboBox<>(new String[] { "Available", "Unavailable" });

        addRow(formPanel, gbc, 0, "Brand:", brandField, labelFont);
        addRow(formPanel, gbc, 1, "Model:", modelField, labelFont);
        addRow(formPanel, gbc, 2, "Colour:", colourField, labelFont);
        addRow(formPanel, gbc, 3, "Daily Rate:", rateField, labelFont);
        addRow(formPanel, gbc, 4, "Availability:", availabilityBox, labelFont);
        addRow(formPanel, gbc, 5, "Registration No:", regNumberField, labelFont);
        addRow(formPanel, gbc, 6, "Registered Date:", regDateField, labelFont);

        // ================= BUTTONS =================
        JButton registerBtn = new JButton("Register Car");
        registerBtn.setFont(new Font("Arial", Font.BOLD, 16));
        registerBtn.setPreferredSize(new Dimension(170, 35));

        JButton viewCarsBtn = new JButton("View Registered Cars");
        viewCarsBtn.setFont(new Font("Arial", Font.BOLD, 14));
        viewCarsBtn.setPreferredSize(new Dimension(200, 30));

        gbc.gridx = 0;
        gbc.gridy = 7;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        formPanel.add(registerBtn, gbc);

        gbc.gridy = 8;
        formPanel.add(viewCarsBtn, gbc);

        content.add(formPanel);
        content.add(Box.createVerticalStrut(40));

        // ____BUTTON ACTIONS_____
        registerBtn.addActionListener(e -> showRegisteredCar());
        viewCarsBtn.addActionListener(e -> showRegisteredCarsPopup());

        // FOOTER
        JLabel footer = new JLabel(
                "SmartDrive Rentals | Contact: +234 800 123 456 | Address: Main Street, City",
                SwingConstants.CENTER);
        footer.setFont(new Font("Arial", Font.PLAIN, 12));
        footer.setForeground(new Color(50, 50, 50));

        bg.add(footer, BorderLayout.SOUTH);
    }

    // VEHICLE CARD
    private JPanel createVehicleCard(String name, boolean available) {

        JPanel card = new JPanel(new BorderLayout());
        card.setPreferredSize(new Dimension(320, 140));
        card.setBorder(BorderFactory.createEmptyBorder(18, 18, 18, 18));
        card.setBackground(available ? new Color(245, 245, 245) : new Color(230, 230, 230));

        JLabel vehicleName = new JLabel(name);
        vehicleName.setFont(new Font("Arial", Font.BOLD, 18));
        vehicleName.setForeground(
                available ? new Color(30, 30, 30) : new Color(160, 160, 160));

        JLabel status = new JLabel(available ? "Available" : "Unavailable");
        status.setFont(new Font("Arial", Font.ITALIC, 13));
        status.setForeground(
                available ? new Color(0, 130, 0) : new Color(160, 160, 160));

        card.add(vehicleName, BorderLayout.NORTH);
        card.add(status, BorderLayout.SOUTH);

        if (available) {
            card.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            card.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    JOptionPane.showMessageDialog(
                            card,
                            name + " is available for rental.",
                            "Vehicle Info",
                            JOptionPane.INFORMATION_MESSAGE);
                }
            });
        }

        return card;
    }

    // Supporting methods
    private JTextField createField() {
        JTextField field = new JTextField(15);
        field.setFont(new Font("Arial", Font.PLAIN, 14));
        return field;
    }

    private void addRow(JPanel panel, GridBagConstraints gbc, int y,
            String labelText, JComponent field, Font font) {
        gbc.gridx = 0;
        gbc.gridy = y;
        JLabel label = new JLabel(labelText);
        label.setFont(font);
        panel.add(label, gbc);

        gbc.gridx = 1;
        panel.add(field, gbc);
    }

    private void showRegisteredCar() {
    try {
        // 1) Read values from the form
        String brand = brandField.getText().trim();
        String model = modelField.getText().trim();
        String colour = colourField.getText().trim();
        String regNo = regNumberField.getText().trim();
        String rateText = rateField.getText().trim();

        boolean available = availabilityBox.getSelectedItem().toString().equalsIgnoreCase("Available");

        // 2) Basic validation
        if (brand.isEmpty() || model.isEmpty() || colour.isEmpty() || regNo.isEmpty() || rateText.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill all fields.");
            return;
        }

        // 3) Convert rate to number
        double rate = Double.parseDouble(rateText);

        // 4) Choose year (simple: current year)
        int year = java.time.LocalDate.now().getYear();

        // 5) Create Car object
        Car car = new Car(brand, model, year, rate, regNo, colour, available);

        // 6) Save to database
        CarDatabase.insertCar(car);

        // 7) Save to UI list 
        String carInfo = brand + " | " +
                model + " | " +
                colour + " | " +
                "Rate: " + rate + " | " +
                (available ? "Available" : "Unavailable") + " | " +
                "Reg No: " + regNo + " | " +
                regDateField.getText();

        registeredCars.addElement(carInfo);

        JOptionPane.showMessageDialog(
                this,
                "Vehicle registered successfully!",
                "Success",
                JOptionPane.INFORMATION_MESSAGE
        );

    } catch (NumberFormatException ex) {
        JOptionPane.showMessageDialog(this, "Daily Rate must be a number.");
    } catch (RuntimeException ex) {
        JOptionPane.showMessageDialog(this, "DB Error: " + ex.getMessage());
    }
}


    private void showRegisteredCarsPopup() {

        JList<String> carList = new JList<>(registeredCars);
        carList.setFont(new Font("Monospaced", Font.PLAIN, 13));

        JScrollPane pane = new JScrollPane(carList);
        pane.setPreferredSize(new Dimension(520, 300));

        JOptionPane.showMessageDialog(
                this,
                pane,
                "Registered Vehicles",
                JOptionPane.INFORMATION_MESSAGE);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MainWindowFrame().setVisible(true));
    }
}