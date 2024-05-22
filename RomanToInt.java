class Solution {
    public int romanToInt(String s) {

        Map<Character, Integer> romanMap = new HashMap<Character, Integer>();

        romanMap.put('I', 1);
        romanMap.put('V', 5);
        romanMap.put('X', 10);
        romanMap.put('L', 50);
        romanMap.put('C', 100);
        romanMap.put('D', 500);
        romanMap.put('M', 1000);

        int total = 0;

        for(int i=0; i<s.length(); i++){
            int currentValue = romanMap.get(s.charAt(i));
            if (i < s.length() - 1 && currentValue < romanMap.get(s.charAt(i + 1))) {
                total -=currentValue;
            }else{
                total +=currentValue;
            }
        }
        return total;
    }
    
    public static void main(String args[]){
        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();
        Solution sol = new Solution();
        sol.romanToInt(str);
    }
}