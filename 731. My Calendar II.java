import java.util.ArrayList;
import java.util.List;

class MyCalendarTwo {

    private List<int[]> calendar;   // List to store all events
    private List<int[]> overlaps;   // List to store double-booked time ranges

    // Constructor to initialize the calendar and overlaps lists
    public MyCalendarTwo() {
        calendar = new ArrayList<>();
        overlaps = new ArrayList<>();
    }

    // Method to book an event if it doesn't cause a triple booking
    public boolean book(int start, int end) {
        // Check if the new event overlaps with any double-booked time range
        for (int[] overlap : overlaps) {
            if (start < overlap[1] && end > overlap[0]) {
                return false; // Triple booking detected, return false
            }
        }

        // Check for overlap with all existing events in the calendar
        for (int[] event : calendar) {
            if (start < event[1] && end > event[0]) {
                // If there's an overlap, store it in the overlaps list
                overlaps.add(new int[]{Math.max(start, event[0]), Math.min(end, event[1])});
            }
        }

        // Add the new event to the calendar
        calendar.add(new int[]{start, end});
        return true; // Event booked successfully
    }
}

public class Main {
    public static void main(String[] args) {
        MyCalendarTwo myCalendarTwo = new MyCalendarTwo();
        System.out.println(myCalendarTwo.book(10, 20)); // Output: true
        System.out.println(myCalendarTwo.book(50, 60)); // Output: true
        System.out.println(myCalendarTwo.book(10, 40)); // Output: true
        System.out.println(myCalendarTwo.book(5, 15));  // Output: false
        System.out.println(myCalendarTwo.book(5, 10));  // Output: true
        System.out.println(myCalendarTwo.book(25, 55)); // Output: true
    }
}
