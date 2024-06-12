class Solution {
    public void sortColors(int[] nums) {
        int low = 0, mid = 0, high = nums.length - 1;

        while(mid <= high){
            if(nums[mid] == 0){
                swap(nums, low, mid);
                low++;
                mid++;
            }else if(nums[mid] == 1){
                mid++;
            }else{
                swap(nums, high, mid);
                high--;
            }
        }    
    }

    private static void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        int[] number = new int[n];
        for(int i=0; i<n; i++){
            number[i] = scan.nextInt();
        } 

        Solution sol = new Solution();
        sol.sortColors(number);

        // for(int num : number){
        //     System.out.println(num);
        // } with this it is working and without also

        scan.close();
    }
}