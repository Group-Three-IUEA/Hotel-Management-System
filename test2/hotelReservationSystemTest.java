import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

public class hotelReservationSystemTest {

    private hotelReservationSystem system;

    @BeforeEach
    void setUp() {
        system = new hotelReservationSystem();
    }

    // --- Guest Information Tests ---

    @Test
    void testGuestInformationLabels() {
        JPanel panel = system.createFormPanel(
                new String[]{"Name:", "Phone:", "Email:"}
        );

        JLabel nameLabel = (JLabel) panel.getComponent(0);
        JLabel phoneLabel = (JLabel) panel.getComponent(2);
        JLabel emailLabel = (JLabel) panel.getComponent(4);

        assertEquals("Name:", nameLabel.getText());
        assertEquals("Phone:", phoneLabel.getText());
        assertEquals("Email:", emailLabel.getText());
    }

    @Test
    void testGuestInformationLayout() {
        JPanel panel = system.createFormPanel(
                new String[]{"Name:", "Phone:", "Email:"}
        );

        LayoutManager layout = panel.getLayout();

        assertTrue(layout instanceof GridLayout);

        GridLayout gridLayout = (GridLayout) layout;

        assertEquals(3, gridLayout.getRows());
        assertEquals(2, gridLayout.getColumns());
    }

    // --- Room Selection Tests ---

    @Test
    void testRoomTypes() {
        JPanel panel = system.createRoomSelectionPanel();

        JComboBox<?> roomType =
                (JComboBox<?>) panel.getComponent(1);

        assertEquals("Single", roomType.getItemAt(0));
        assertEquals("Double", roomType.getItemAt(1));
        assertEquals("Suite", roomType.getItemAt(2));
    }

    @Test
    void testNumberOfGuests() {
        JPanel panel = system.createRoomSelectionPanel();

        JSpinner guestSpinner =
                (JSpinner) panel.getComponent(3);

        SpinnerNumberModel model =
                (SpinnerNumberModel) guestSpinner.getModel();

        assertEquals(1, model.getValue());
        assertEquals(1, model.getMinimum());
        assertEquals(10, model.getMaximum());
        assertEquals(1, model.getStepSize());
    }

    // --- Booking Date Tests ---

    @Test
    void testBookingDateFields() {
        JPanel panel = system.createFormPanel(
                "Booking Dates",
                new String[]{"Check-in Date:", "Check-out Date:"},
                new String[]{"YYYY-MM-DD", "YYYY-MM-DD"}
        );

        JTextField checkIn =
                (JTextField) panel.getComponent(1);

        JTextField checkOut =
                (JTextField) panel.getComponent(3);

        assertEquals("YYYY-MM-DD", checkIn.getText());
        assertEquals("YYYY-MM-DD", checkOut.getText());
    }

    // --- Payment Tests ---

    @Test
    void testPaymentFields() {
        JPanel panel = system.createFormPanel(
                "Payment Details",
                new String[]{"Card Number:", "Expiry Date:", "CVV:"},
                new String[]{"", "MM/YY", ""}
        );

        JTextField cardNumber =
                (JTextField) panel.getComponent(1);

        JTextField expiryDate =
                (JTextField) panel.getComponent(3);

        JTextField cvv =
                (JTextField) panel.getComponent(5);

        assertEquals("", cardNumber.getText());
        assertEquals("MM/YY", expiryDate.getText());
        assertEquals("", cvv.getText());
    }

    // --- Summary Tests ---

    @Test
    void testReservationSummary() {
        JPanel panel = system.createSummaryPanel();

        JScrollPane scrollPane =
                (JScrollPane) panel.getComponent(0);

        JTextArea summary =
                (JTextArea) scrollPane.getViewport().getView();

        assertEquals(
                "Reservation details will appear here...",
                summary.getText()
        );

        assertFalse(summary.isEditable());
    }

    // --- Action Tests ---

    @Test
    void testReservationButtons() {
        JPanel panel = system.createActionPanel();

        JButton confirmButton =
                (JButton) panel.getComponent(0);

        JButton cancelButton =
                (JButton) panel.getComponent(1);

        assertEquals(
                "Confirm Reservation",
                confirmButton.getText()
        );

        assertEquals(
                "Cancel",
                cancelButton.getText()
        );
    }
}