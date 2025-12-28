import java.awt.*;
import javax.swing.*;

public class WelcomeFrame extends JFrame {

    private JProgressBar loadingBar;

    public WelcomeFrame() {

        setTitle("Global Car Rental System");
        setSize(600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        BackgroundPanel panel = new BackgroundPanel("/images/welcome.PNG");
        panel.setLayout(new GridBagLayout());

        // proceed button
        JButton proceedButton = new JButton("PROCEED");
        proceedButton.setFont(new Font("Arial", Font.BOLD, 16));

        // loading bar
        loadingBar = new JProgressBar(0, 100);
        loadingBar.setPreferredSize(new Dimension(200, 30));
        loadingBar.setStringPainted(true);
        loadingBar.setVisible(false); // hides until clicked

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(30, 20, 10, 20);
        gbc.anchor = GridBagConstraints.SOUTH;

        gbc.gridy = 2;
        panel.add(proceedButton, gbc);

        gbc.gridy = 1;
        gbc.insets = new Insets(10, 20, 20, 20);
        panel.add(loadingBar, gbc);

        add(panel);

        // click event
        proceedButton.addActionListener(e -> startLoading());
    }

    // progress bar animation method
    private void startLoading() {
        loadingBar.setVisible(true);

        // background loading thread
        new Thread(() -> {
            try {
                for (int i = 0; i <= 100; i++) {
                    loadingBar.setValue(i);
                    Thread.sleep(25); // change speed if needed
                }

                dispose();  // close welcome
                new LoginFrame().setVisible(true);

            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }).start();
    }

    public static void main(String[] args) {
        new WelcomeFrame().setVisible(true);
    }
}


