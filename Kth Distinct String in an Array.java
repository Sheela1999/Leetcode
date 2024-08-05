import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Scanner;

public class KthDistinctString {

    public static String kthDistinct(String[] arr, int k) {
        Map<String, Integer> countMap = new HashMap<>();
        LinkedHashSet<String> distinctStrings = new LinkedHashSet<>();

        // Count occurrences of each string
        for (String str : arr) {
            countMap.put(str, countMap.getOrDefault(str, 0) + 1);
        }

        // Add distinct strings to LinkedHashSet (maintains insertion order)
        for (String str : arr) {
            if (countMap.get(str) == 1) {
                distinctStrings.add(str);
            }
        }

        // Iterate through the LinkedHashSet to find the k-th distinct string
        int index = 0;
        for (String str : distinctStrings) {
            index++;
            if (index == k) {
                return str;
            }
        }

        // If there are fewer than k distinct strings, return an empty string
        return "";
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read the number of elements in the array
        System.out.print("Enter the number of elements in the array: ");
        int n = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        // Read the elements of the array
        String[] arr = new String[n];
        System.out.println("Enter the elements of the array: ");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextLine();
        }

        // Read the value of k
        System.out.print("Enter the value of k: ");
        int k = scanner.nextInt();

        // Find the k-th distinct string
        String result = kthDistinct(arr, k);

        // Print the result
        System.out.println("The " + k + "-th distinct string is: " + result);
    }
}
