class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n = profits.length;
        Project[] projects = new Project[n];

        for(int i = 0; i < n; i++){
            projects[i] = new Project(profits[i], capital[i]);
        }

        Arrays.sort(projects, Comparator.comparingInt(p -> p.capital));

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        int projectIndex = 0;

        for (int i = 0; i < k; i++) {
            while (projectIndex < n && projects[projectIndex].capital <= w) {
                maxHeap.add(projects[projectIndex].profit);
                projectIndex++;
            }

            if (maxHeap.isEmpty()) {
                break;
            }
            w += maxHeap.poll();
        }

        return w;
    }

        static class Project {
        int profit;
        int capital;

        Project(int profit, int capital) {
            this.profit = profit;
            this.capital = capital;
        }
        
    }

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int num = scan.nextInt();
        int[] nums = new int[num];

        for(int i = 0; i < num; i++){
            nums[i] = scan.nextInt();
        }

        int[] caps = new int[num];
        for(int i = 0; i < num; i++){
            caps[i] = scan.nextInt();
        }

        int n1 = scan.nextInt();
        int n2 = scan.nextInt();

        Solution sol = new Solution();
        int result = sol.findMaximizedCapital(n1, n2, nums, caps);
        System.out.println(result);

        scan.close();
    }
}


public class MaximizeCapital {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of projects: ");
        int n = scanner.nextInt();

        System.out.print("Enter the number of projects you can complete (k): ");
        int k = scanner.nextInt();

        System.out.print("Enter the initial capital (w): ");
        int w = scanner.nextInt();

        int[] profits = new int[n];
        int[] capital = new int[n];

        System.out.println("Enter the profits of the projects: ");
        for (int i = 0; i < n; i++) {
            profits[i] = scanner.nextInt();
        }

        System.out.println("Enter the capital requirements of the projects: ");
        for (int i = 0; i < n; i++) {
            capital[i] = scanner.nextInt();
        }

        System.out.println("Maximized capital: " + findMaximizedCapital(k, w, profits, capital));
        scanner.close();
    }

    public static int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n = profits.length;
        Project[] projects = new Project[n];

        for (int i = 0; i < n; i++) {
            projects[i] = new Project(profits[i], capital[i]);
        }

        // Sort the projects by their capital requirements
        Arrays.sort(projects, Comparator.comparingInt(p -> p.capital));

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        int projectIndex = 0;

        for (int i = 0; i < k; i++) {
            // Add all the projects that can be started with the current capital
            while (projectIndex < n && projects[projectIndex].capital <= w) {
                maxHeap.add(projects[projectIndex].profit);
                projectIndex++;
            }

            // If there are no projects that can be started, break
            if (maxHeap.isEmpty()) {
                break;
            }

            // Select the most profitable project
            w += maxHeap.poll();
        }

        return w;
    }

    static class Project {
        int profit;
        int capital;

        Project(int profit, int capital) {
            this.profit = profit;
            this.capital = capital;
        }
    }
}