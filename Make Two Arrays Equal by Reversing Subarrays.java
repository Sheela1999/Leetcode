import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MakeArrayEqual {
    public static boolean canBeEqual(int[] target, int[] arr) {
        // Use a HashMap to count the frequency of elements in target
        Map<Integer, Integer> targetCount = new HashMap<>();
        for (int num : target) {
            targetCount.put(num, targetCount.getOrDefault(num, 0) + 1);
        }

        // Use another HashMap to count the frequency of elements in arr
        Map<Integer, Integer> arrCount = new HashMap<>();
        for (int num : arr) {
            arrCount.put(num, arrCount.getOrDefault(num, 0) + 1);
        }

        // Compare the frequency maps of target and arr
        return targetCount.equals(arrCount);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read the length of the arrays
        System.out.print("Enter the length of the arrays: ");
        int n = scanner.nextInt();

        // Read the target array
        int[] target = new int[n];
        System.out.print("Enter the elements of the target array: ");
        for (int i = 0; i < n; i++) {
            target[i] = scanner.nextInt();
        }

        // Read the arr array
        int[] arr = new int[n];
        System.out.print("Enter the elements of the arr array: ");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        // Check if arr can be made equal to target
        boolean result = canBeEqual(target, arr);
        System.out.println("Can arr be made equal to target? " + result);
    }
}
