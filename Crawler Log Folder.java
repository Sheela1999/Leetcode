import java.util.Scanner;

public class FileSystemLog {

    public static int minOperations(String[] logs) {
        int depth = 0; // This variable tracks the current depth of the folder

        for (String log : logs) {
            // If the log is "../", we move up a folder, if we're not already in the main folder
            if (log.equals("../")) {
                if (depth > 0) {
                    depth--;
                }
            }
            // If the log is "./", we stay in the same folder, so no action needed
            else if (log.equals("./")) {
                continue;
            }
            // If the log is "x/", we move into the child folder, increasing the depth
            else {
                depth++;
            }
        }

        // The depth variable now contains the number of operations needed to return to the main folder
        return depth;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Reading the number of logs
        System.out.println("Enter the number of logs:");
        int n = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        String[] logs = new String[n];
        System.out.println("Enter the logs:");
        for (int i = 0; i < n; i++) {
            logs[i] = scanner.nextLine();
        }

        int result = minOperations(logs);
        System.out.println("Minimum number of operations to return to the main folder: " + result);
    }
}
