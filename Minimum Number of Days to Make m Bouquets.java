class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int n = bloomDay.length;

        // If the total flowers needed is more than available flowers, return -1
        if (m * k > n) return -1;

        // Find the minimum and maximum days
        int left = Integer.MAX_VALUE;
        int right = Integer.MIN_VALUE;

        for (int day : bloomDay) {
            left = Math.min(left, day);
            right = Math.max(right, day);
        }

        // Perform binary search to find the minimum day
        while (left < right) {
            int mid = (left + right) / 2;
            if (canMakeBouquets(bloomDay, m, k, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        // After the loop, left == right, we need to confirm if it can make m bouquets
        return canMakeBouquets(bloomDay, m, k, left) ? left : -1;
    }

    private boolean canMakeBouquets(int[] bloomDay, int m, int k, int day) {
        int bouquets = 0;
        int flowers = 0;

        for (int bloom : bloomDay) {
            if (bloom <= day) {
                flowers++;
                if (flowers == k) {
                    bouquets++;
                    flowers = 0;
                }
            } else {
                flowers = 0;
            }
        }

        return bouquets >= m;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of flowers: ");
        int n = scanner.nextInt();

        int[] bloomDay = new int[n];
        System.out.print("Enter the bloom days: ");
        for (int i = 0; i < n; i++) {
            bloomDay[i] = scanner.nextInt();
        }

        System.out.print("Enter the number of bouquets needed (m): ");
        int m = scanner.nextInt();

        System.out.print("Enter the number of flowers per bouquet (k): ");
        int k = scanner.nextInt();

        Solution solution = new Solution();
        int result = solution.minDays(bloomDay, m, k);
        System.out.println("Minimum number of days: " + result);

        scanner.close();
    }
}