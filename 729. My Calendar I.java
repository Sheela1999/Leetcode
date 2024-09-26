class MyCalendar {
    // List to store the events as pairs of start and end times
    private List<int[]> calendar;

    // Constructor to initialize the calendar list
    public MyCalendar() {
        calendar = new ArrayList<>();
    }

    // Method to book an event if it doesn't cause a double booking
    public boolean book(int start, int end) {
        // Check if there is any overlap with existing events in the calendar
        for (int[] event : calendar) {
            // If the current event overlaps with the new event
            if (start < event[1] && end > event[0]) {
                return false; // Return false since it causes a double booking
            }
        }
        // If no overlap is found, add the event to the calendar
        calendar.add(new int[]{start, end});
        return true; // Return true indicating the event was booked successfully
    }
}

public class Main {
    public static void main(String[] args) {
        MyCalendar myCalendar = new MyCalendar();
        System.out.println(myCalendar.book(10, 20)); // Output: true
        System.out.println(myCalendar.book(15, 25)); // Output: false
        System.out.println(myCalendar.book(20, 30)); // Output: true
    }
}
