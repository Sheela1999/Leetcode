class Solution {
    public boolean isHappy(int n) {
        Set<Integer> seenNumbers = new HashSet<>();
        
        while (n != 1 && !seenNumbers.contains(n)) {
            seenNumbers.add(n);
            n = getNextNumber(n);
        }
        return n == 1;
    }

    private static int getNextNumber(int n) {
        int sum = 0;
        while (n > 0) {
            int digit = n % 10;
            sum += digit * digit;
            n /= 10;
        }
        return sum;   
    }

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        Solution sol = new Solution();
        boolean result = sol.isHappy(n);
        System.out.println(result);

        scan.close();
    }
}