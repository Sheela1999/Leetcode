class Solution {
    public boolean isValid(String s) {
        if(s.length() % 2 != 0){
            return false;// Closing bracket with no corresponding opening bracket
        }

        char[] cha = new char[s.length()];
        int top = -1;// Pointer to the top of the "stack"

        for(char c : s.toCharArray()){
            if(c == '(' || c == '{' || c == '['){
                cha[++top] = c; //Push onto the "stack"
            }else{
                if(top == -1){
                    return false;// Closing bracket with no corresponding opening bracket
                }
                char topChar = cha[top--];
                if((c == ')' && topChar != '(') || (c == '}' && topChar != '{') || (c == ']' && topChar != '[')){
                    return false;// Mismatched opening and closing brackets
                }
            }
        }
        return top == -1;// If stack is empty, it's valid  
    }

    public static void main(String args[]){
        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();
        Solution sol = new Solution();
        System.out.println(sol.isValid(str));
    }
}
