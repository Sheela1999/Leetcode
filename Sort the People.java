import java.util.*;

public class SortNamesByHeights {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input number of elements
        System.out.print("Enter the number of people: ");
        int n = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        // Input names
        String[] names = new String[n];
        System.out.println("Enter the names:");
        for (int i = 0; i < n; i++) {
            names[i] = scanner.nextLine();
        }

        // Input heights
        int[] heights = new int[n];
        System.out.println("Enter the heights:");
        for (int i = 0; i < n; i++) {
            heights[i] = scanner.nextInt();
        }

        // Sort names by heights in descending order
        String[] sortedNames = sortNamesByHeights(names, heights);

        // Output the sorted names
        System.out.println("Names sorted by heights in descending order:");
        for (String name : sortedNames) {
            System.out.println(name);
        }

        scanner.close();
    }

    public static String[] sortNamesByHeights(String[] names, int[] heights) {
        int n = names.length;
        Person[] people = new Person[n];

        // Create Person objects to pair names and heights
        for (int i = 0; i < n; i++) {
            people[i] = new Person(names[i], heights[i]);
        }

        // Sort the Person objects by height in descending order
        Arrays.sort(people, (a, b) -> b.height - a.height);

        // Extract sorted names
        String[] sortedNames = new String[n];
        for (int i = 0; i < n; i++) {
            sortedNames[i] = people[i].name;
        }

        return sortedNames;
    }
}

// Helper class to pair names and heights
class Person {
    String name;
    int height;

    Person(String name, int height) {
        this.name = name;
        this.height = height;
    }
}
