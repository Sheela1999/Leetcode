import java.util.*;

class Solution {
    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        int n = positions.length;

        // Array to store indices of robots
        Integer[] indices = new Integer[n];
        for (int i = 0; i < n; i++) {
            indices[i] = i;
        }
        
        // Sort indices based on positions
        Arrays.sort(indices, Comparator.comparingInt(i -> positions[i]));

        // Stack to handle collisions
        Deque<Integer> stack = new ArrayDeque<>();
        int[] finalHealths = Arrays.copyOf(healths, n);

        // Process robots in order of their positions
        for (int i = 0; i < n; i++) {
            int index = indices[i];
            if (directions.charAt(index) == 'R') {
                stack.push(index);
            } else {
                while (!stack.isEmpty() && directions.charAt(stack.peek()) == 'R') {
                    int rIndex = stack.pop();
                    if (finalHealths[rIndex] > finalHealths[index]) {
                        finalHealths[rIndex] -= 1;
                        finalHealths[index] = 0;
                        stack.push(rIndex);
                        break;
                    } else if (finalHealths[rIndex] < finalHealths[index]) {
                        finalHealths[index] -= 1;
                        finalHealths[rIndex] = 0;
                    } else {
                        finalHealths[index] = 0;
                        finalHealths[rIndex] = 0;
                        break;
                    }
                }
            }
        }

        // Collecting the survivors
        List<Integer> survivors = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (finalHealths[i] > 0) {
                survivors.add(finalHealths[i]);
            }
        }

        return survivors;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input reading
        System.out.println("Enter the number of robots:");
        int n = scanner.nextInt();
        
        int[] positions = new int[n];
        int[] healths = new int[n];
        String directions;

        System.out.println("Enter the positions:");
        for (int i = 0; i < n; i++) {
            positions[i] = scanner.nextInt();
        }

        System.out.println("Enter the healths:");
        for (int i = 0; i < n; i++) {
            healths[i] = scanner.nextInt();
        }

        System.out.println("Enter the directions:");
        directions = scanner.next();

        Solution solution = new Solution();
        List<Integer> result = solution.survivedRobotsHealths(positions, healths, directions);
        System.out.println("Survivors' healths: " + result);
    }
}
