class Solution {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        // Create job list with difficulty and profit pairs
        List<int[]> jobs = new ArrayList<>();
        for (int i = 0; i < difficulty.length; i++) {
            jobs.add(new int[]{difficulty[i], profit[i]});
        }

        // Sort jobs by difficulty
        jobs.sort((a, b) -> a[0] - b[0]);

        // Sort worker by their ability
        Arrays.sort(worker);

        int maxProfit = 0;
        int bestProfit = 0;
        int jobIndex = 0;

        for (int ability : worker) {
            // Find the best job for the current worker ability
            while (jobIndex < jobs.size() && jobs.get(jobIndex)[0] <= ability) {
                bestProfit = Math.max(bestProfit, jobs.get(jobIndex)[1]);
                jobIndex++;
            }
            maxProfit += bestProfit;
        }

        return maxProfit;
    }
	
	public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        int[] diff = new int[n];
        for(int i = 0; i < n; i++){
            diff[i] = scan.nextInt();
        }

        int[] profits = new int[n];
        for(int i = 0; i < n; i++){
            profits[i] = scan.nextInt();
        }

        int[] workers = new int[n];
        for(int i = 0; i < n; i++){
            workers[i] = scan.nextInt();
        }

        Solution solution = new Solution();
        int result = solution.maxProfitAssignment(diff, profits, workers);
        System.out.println(result);

        scan.close();
    }
}

// or we can use this main method also

public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Reading inputs
        System.out.println("Enter difficulties: ");
        String[] diffStr = scanner.nextLine().split(",");
        int[] difficulty = new int[diffStr.length];
        for (int i = 0; i < diffStr.length; i++) {
            difficulty[i] = Integer.parseInt(diffStr[i].trim());
        }

        System.out.println("Enter profits: ");
        String[] profitStr = scanner.nextLine().split(",");
        int[] profit = new int[profitStr.length];
        for (int i = 0; i < profitStr.length; i++) {
            profit[i] = Integer.parseInt(profitStr[i].trim());
        }

        System.out.println("Enter worker abilities: ");
        String[] workerStr = scanner.nextLine().split(",");
        int[] worker = new int[workerStr.length];
        for (int i = 0; i < workerStr.length; i++) {
            worker[i] = Integer.parseInt(workerStr[i].trim());
        }

        System.out.println("Maximum profit: " + maxProfitAssignment(difficulty, profit, worker));
    }