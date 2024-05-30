public class Solution {
    public int mySqrt(int x) {
        if (x == 0) {
            return 0;
        }
        
        int left = 1, right = x, result = 0;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            // To avoid overflow, use mid <= x / mid instead of mid * mid <= x
            if (mid <= x / mid) {
                result = mid;  // mid is a candidate for the result
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return result;
    }
	public static void main(String args[]){
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        Solution solution = new Solution();
        int result = solution.mySqrt(n);
        System.out.println(result);
        
        scan.close();
    }
}