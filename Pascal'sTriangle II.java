import java.util.*;

class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> row = new ArrayList<>();//Initializes an empty list to store the row.
        
        // Initialize the first element
        row.add(1); // Adds the first element 1 to the row since each row starts with 1.
        
        // Calculate each element in the row using the previous elements
        for (int i = 1; i <= rowIndex; i++) {
            // We update the row from the back to avoid overwriting the values we need to compute the next ones
            for (int j = i - 1; j > 0; j--) {
                row.set(j, row.get(j) + row.get(j - 1));//Updates the current element by adding the two elements directly above it from the previous state of the list
            }
            // Add the last element which is always 1
            row.add(1);
        }
        
        return row;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int rowIndex = scan.nextInt();

        Solution sol = new Solution();
        List<Integer> result = sol.getRow(rowIndex);
        System.out.println(result);

        scan.close();
    }
}