import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class CinemaTicketSystem {
    private int[] seats = new int[10];

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new CinemaTicketSystem().createAndShowGUI());
    }

    // Recursive technique
    public static int factorial(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        return n * factorial(n - 1);
    }

    // Array data structure (1D array)
    public void initializeSeats() {
        for (int i = 0; i < seats.length; i++) {
            seats[i] = 0; // 0 for available, 1 for booked
        }
    }

    // Search method (linear search)
    public int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1; // Element not found
    }

    // Search method (binary search)
    public int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1; // Element not found
    }

    // Sort method (insertion sort)
    public void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }

    // GUI with Java Swing
    public void createAndShowGUI() {
        initializeSeats();

        JFrame frame = new JFrame("Cinema Ticket System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());

        for (int i = 0; i < seats.length; i++) {
            JButton seatButton = new JButton("Seat " + (i + 1));
            seatButton.addActionListener(new SeatBookingActionListener(i, seatButton));
            frame.add(seatButton);
        }

        frame.pack();
        frame.setVisible(true);
    }

    private void bookSeat(int seatNumber, JButton seatButton) {
        if (seats[seatNumber] == 0) {
            seats[seatNumber] = 1;
            seatButton.setText("Booked");
            JOptionPane.showMessageDialog(null, "Booking Confirmed!\nYou have successfully booked Seat " + (seatNumber + 1));
        } else {
            JOptionPane.showMessageDialog(null, "Booking Failed\nSeat " + (seatNumber + 1) + " is already booked.");
        }
    }

    private void showAlert(String title, String message) {
        JOptionPane.showMessageDialog(null, message, title, JOptionPane.INFORMATION_MESSAGE);
    }

    class SeatBookingActionListener implements ActionListener {
        private int seatNumber;
        private JButton seatButton;

        public SeatBookingActionListener(int seatNumber, JButton seatButton) {
            this.seatNumber = seatNumber;
            this.seatButton = seatButton;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            bookSeat(seatNumber, seatButton);
        }
    }
}
