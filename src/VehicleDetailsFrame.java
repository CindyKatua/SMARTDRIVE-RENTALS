import javax.swing.*;
import java.awt.*;

public class VehicleDetailsFrame extends JFrame {

    public VehicleDetailsFrame(String vehicleName) {

        setTitle(vehicleName);
        setSize(500, 400);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));

        JLabel title = new JLabel(vehicleName);
        title.setFont(new Font("Serif", Font.BOLD, 28));
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        JTextArea details = new JTextArea(
                "*****Great vehicle..."
        );

        details.setFont(new Font("Arial", Font.PLAIN, 14));
        details.setEditable(false);
        details.setLineWrap(true);
        details.setWrapStyleWord(true);
        details.setOpaque(false);

        panel.add(title);
        panel.add(Box.createVerticalStrut(20));
        panel.add(details);

        add(panel);
    }
}
