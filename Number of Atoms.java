import java.util.*;
import java.util.regex.*;

public class ChemicalFormulaParser {
    
    public static String countOfAtoms(String formula) {
        // TreeMap to store atom counts in sorted order by atom name
        Map<String, Integer> map = new TreeMap<>();
        // Stack to handle nested parentheses
        Deque<Map<String, Integer>> stack = new ArrayDeque<>();
        // Variables to traverse the formula string
        int i = 0, n = formula.length();
        
        // Loop through the formula
        while (i < n) {
            char c = formula.charAt(i);
            
            if (c == '(') {
                // If we encounter '(', push current map onto the stack
                stack.push(map);
                // Reset the map to handle the sub-formula inside parentheses
                map = new TreeMap<>();
                i++;
            } else if (c == ')') {
                // If we encounter ')', determine the multiplicity (if any)
                int iStart = ++i;
                while (i < n && Character.isDigit(formula.charAt(i))) i++;
                int multiplicity = iStart < i ? Integer.parseInt(formula.substring(iStart, i)) : 1;
                
                // Pop the previous map from the stack
                if (!stack.isEmpty()) {
                    Map<String, Integer> top = stack.pop();
                    // Merge the current map with the popped map, considering the multiplicity
                    for (String key : map.keySet()) {
                        top.put(key, top.getOrDefault(key, 0) + map.get(key) * multiplicity);
                    }
                    // Update the current map to the merged map
                    map = top;
                }
            } else {
                // Parse the element name (starting with uppercase and may have lowercase letters)
                int iStart = i++;
                while (i < n && Character.isLowerCase(formula.charAt(i))) i++;
                String name = formula.substring(iStart, i);
                
                // Parse the count of the element (if any)
                iStart = i;
                while (i < n && Character.isDigit(formula.charAt(i))) i++;
                int multiplicity = iStart < i ? Integer.parseInt(formula.substring(iStart, i)) : 1;
                
                // Update the count of the element in the map
                map.put(name, map.getOrDefault(name, 0) + multiplicity);
            }
        }
        
        // Build the result string from the sorted map
        StringBuilder sb = new StringBuilder();
        for (String key : map.keySet()) {
            sb.append(key);
            if (map.get(key) > 1) sb.append(map.get(key));
        }
        return sb.toString();
    }
    
    public static void main(String[] args) {
        // Scanner to read input from the user
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the chemical formula: ");
        // Read the formula from the user
        String formula = scanner.nextLine();
        // Call the countOfAtoms method and print the result
        System.out.println("Output: " + countOfAtoms(formula));
    }
}
