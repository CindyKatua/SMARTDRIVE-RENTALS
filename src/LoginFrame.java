import java.awt.*;
import javax.swing.*;

public class LoginFrame extends JFrame {

    private JTextField usernameField;
    private JPasswordField passwordField;

    public LoginFrame() {

        setTitle("Login");
        setSize(600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Background Image Panel
        BackgroundPanel bg = new BackgroundPanel("/images/background.PNG");
        bg.setLayout(new BorderLayout());
        add(bg);

        // Title
        JLabel title = new JLabel("LOGIN PAGE", SwingConstants.CENTER);
        title.setFont(new Font("Algerian", Font.BOLD, 26));
        title.setForeground(Color.BLACK);
        bg.add(title, BorderLayout.NORTH);

        // Form Panel
        JPanel formPanel = new JPanel();
        formPanel.setOpaque(false);
        formPanel.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.anchor = GridBagConstraints.WEST;

        // USERNAME
        gbc.gridx = 0;
        gbc.gridy = 0;
        formPanel.add(new JLabel("Username:"), gbc);

        usernameField = new JTextField(15);
        gbc.gridx = 1;
        formPanel.add(usernameField, gbc);

        // PASSWORD
        gbc.gridx = 0;
        gbc.gridy = 1;
        formPanel.add(new JLabel("Password:"), gbc);

        passwordField = new JPasswordField(15);
        gbc.gridx = 1;
        formPanel.add(passwordField, gbc);

        // LOGIN BUTTON
        gbc.gridx = 1;
        gbc.gridy = 2;
        JButton loginBtn = new JButton("Login");
        formPanel.add(loginBtn, gbc);

        // Button Action
        loginBtn.addActionListener(e -> checkLogin());

        // Add form to background center
        bg.add(formPanel, BorderLayout.CENTER);
    }

    private void checkLogin() {
        String user = usernameField.getText();
        String pass = new String(passwordField.getPassword());

        if (user.equals("Smartdeals") && pass.equals("Rentacar123")) {
            JOptionPane.showMessageDialog(this, "Login Successful");
            this.dispose();
            new MainWindowFrame().setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "Invalid Login Details");
        }
    }

    public static void main(String[] args) {
        new LoginFrame().setVisible(true);
    }
}
