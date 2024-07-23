import java.util.*;

public class FrequencySort {
    public static void main(String[] args) {
        // Create a Scanner object for reading input
        Scanner scanner = new Scanner(System.in);
        
        // Read the size of the array
        System.out.print("Enter the number of elements in the array: ");
        int n = scanner.nextInt();
        
        // Initialize the array
        int[] nums = new int[n];
        
        // Read the elements of the array
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        
        // Close the scanner
        scanner.close();
        
        // Sort the array based on the frequency of values
        int[] sortedArray = frequencySort(nums);
        
        // Print the sorted array
        System.out.println("Sorted array based on frequency:");
        for (int num : sortedArray) {
            System.out.print(num + " ");
        }
    }
    
    public static int[] frequencySort(int[] nums) {
        // Create a map to store the frequency of each element
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        
        // Populate the frequency map
        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }
        
        // Create a custom comparator for sorting
        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                // Compare based on frequency
                int freqA = frequencyMap.get(a);
                int freqB = frequencyMap.get(b);
                
                if (freqA != freqB) {
                    // Sort by increasing frequency
                    return freqA - freqB;
                } else {
                    // If frequencies are the same, sort by decreasing value
                    return b - a;
                }
            }
        };
        
        // Convert the array to a list for sorting
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            list.add(num);
        }
        
        // Sort the list using the custom comparator
        Collections.sort(list, comparator);
        
        // Convert the list back to an array
        int[] sortedArray = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            sortedArray[i] = list.get(i);
        }
        
        // Return the sorted array
        return sortedArray;
    }
}
