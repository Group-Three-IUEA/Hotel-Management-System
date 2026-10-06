import javax.swing.*;
import java.awt.*;

public class hotelReservationSystem extends JFrame {

    public hotelReservationSystem() {
        setTitle("Hotel Reservation System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 800);
        setLayout(new GridLayout(3, 2, 10, 10));

        // Add panels
        add(createFormPanel(new String[]{"Name:", "Phone:", "Email:"}));
        add(createRoomSelectionPanel());
        add(createFormPanel("Booking Dates", new String[]{"Check-in Date:", "Check-out Date:"}, new String[]{"IVA-MM-DD", "IVA-MM-DD"}));
        add(createFormPanel("Payment Details", new String[]{"Card Number:", "Expiry Date:", "CVV:"}, new String[]{"", "MM/YY", ""}));
        add(createSummaryPanel());
        add(createActionPanel());

        setVisible(true);
    }

    private JPanel createFormPanel(String[] labels) {
        return createFormPanel("Guest Information", labels, new String[labels.length]);
    }

    private JPanel createFormPanel(String title, String[] labels, String[] defaults) {
        JPanel panel = new JPanel(new GridLayout(labels.length, 2, 5, 5));
        panel.setBorder(BorderFactory.createTitledBorder(title));
        for (int i = 0; i < labels.length; i++) {
            panel.add(new JLabel(labels[i]));
            panel.add(new JTextField(defaults[i]));
        }
        return panel;
    }
    private JPanel createRoomSelectionPanel() {
        JPanel panel = new JPanel(new GridLayout(2, 2, 5, 5));
        panel.setBorder(BorderFactory.createTitledBorder("Room Selection"));
        panel.add(new JLabel("Room Type:"));
        panel.add(new JComboBox<>(new String[]{"Single", "Double", "Suite"}));
        panel.add(new JLabel("Number of Guests:"));
        panel.add(new JSpinner(new SpinnerNumberModel(1, 1, 10, 1)));
        return panel;
    }


    private JPanel createSummaryPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(BorderFactory.createTitledBorder("Reservation Summary"));
        JTextArea summaryArea = new JTextArea("Reservation details will appear here...");
        summaryArea.setEditable(false);
        panel.add(new JScrollPane(summaryArea), BorderLayout.CENTER);
        return panel;
    }


    private JPanel createActionPanel() {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        panel.setBorder(BorderFactory.createTitledBorder("Actions"));
        panel.add(new JButton("Confirm Reservation"));
        panel.add(new JButton("Cancel"));
        return panel;
    }
}
