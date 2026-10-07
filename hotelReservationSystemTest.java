import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class hotelReservationSystemTest {

    private hotelReservationSystem system;

    @BeforeEach
    void setUp() {
        system = new hotelReservationSystem();
    }

    // 1. Test that the system initializes without crashing
    @Test
    @DisplayName("1. assertDoesNotThrow: Verify system initialization")
    void testInitializationDoesNotThrow() {
        assertDoesNotThrow(hotelReservationSystem::new);
    }

    // 2. Test the required 3x2 GridLayout
    @Test
    @DisplayName("2. assertEquals: Verify required 3x2 GridLayout")
    void testGridLayoutConfiguration() {

        assertInstanceOf(GridLayout.class, system.getContentPane().getLayout());

        GridLayout layout =
                (GridLayout) system.getContentPane().getLayout();

        assertEquals(3, layout.getRows());
        assertEquals(2, layout.getColumns());
        assertEquals(10, layout.getHgap());
        assertEquals(10, layout.getVgap());
    }

    // 3. Test the room type options
    @Test
    @DisplayName("3. assertArrayEquals: Verify room type options")
    void testRoomTypeOptions() {

        JPanel roomPanel = system.createRoomSelectionPanel();

        JComboBox<String> roomComboBox =
                (JComboBox<String>) roomPanel.getComponent(1);

        String[] actualOptions =
                new String[roomComboBox.getItemCount()];

        for (int i = 0; i < roomComboBox.getItemCount(); i++) {
            actualOptions[i] = roomComboBox.getItemAt(i);
        }

        String[] expectedOptions = {
                "Single", "Double", "Suite"
        };

        assertArrayEquals(expectedOptions, actualOptions);
    }

    // 4. Test invalid null input
    @Test
    @DisplayName("4. assertThrows: Verify null labels cause an exception")
    void testNullLabelsThrowsException() {

        assertThrows(
                NullPointerException.class,
                () -> system.createFormPanel(null)
        );
    }

    // 5. Test that Confirm and Cancel are different objects
    @Test
    @DisplayName("5. assertNotSame: Verify action buttons are separate objects")
    void testActionButtonsAreNotSame() {

        JPanel actionPanel = system.createActionPanel();

        JButton confirmButton =
                (JButton) actionPanel.getComponent(0);

        JButton cancelButton =
                (JButton) actionPanel.getComponent(1);

        assertNotSame(confirmButton, cancelButton);
    }

    // 6. Test that six independent panels are added
    @Test
    @DisplayName("6. assertEquals & assertTrue: Verify six independent panels")
    void testMainFrameContainsSixPanels() {

        Component[] components =
                system.getContentPane().getComponents();

        assertEquals(6, components.length);

        for (Component component : components) {
            assertInstanceOf(JPanel.class, component);
        }
    }

    // 7. Test that the Reservation Summary panel exists
    @Test
    @DisplayName("7. assertEquals & assertTrue: Verify Reservation Summary panel")
    void testSummaryPanel() {

        JPanel panel = system.createSummaryPanel();

        assertEquals(1, panel.getComponentCount());

        assertInstanceOf(JScrollPane.class, panel.getComponent(0));
    }

    // 8. Test the Action Panel button labels
    @Test
    @DisplayName("8. assertEquals: Verify Action Panel button labels")
    void testActionButtonLabels() {

        JPanel actionPanel = system.createActionPanel();

        JButton confirmButton =
                (JButton) actionPanel.getComponent(0);

        JButton cancelButton =
                (JButton) actionPanel.getComponent(1);

        assertEquals("Confirm Reservation", confirmButton.getText());
        assertEquals("Cancel", cancelButton.getText());
    }
}