import javax.swing.*;
import java.awt.*;

public class VehicleRenderer extends DefaultListCellRenderer {

    @Override
    public Component getListCellRendererComponent(
            JList<?> list,
            Object value,
            int index,
            boolean isSelected,
            boolean cellHasFocus) {

        JLabel label = (JLabel) super.getListCellRendererComponent(
                list, value, index, isSelected, cellHasFocus);

        String text = value.toString();

        if (text.contains("Available")) {
            label.setFont(label.getFont().deriveFont(Font.BOLD));
            label.setForeground(Color.BLACK);
        } else {
            label.setFont(label.getFont().deriveFont(Font.PLAIN));
            label.setForeground(Color.GRAY);
        }

        return label;
    }
}
