class Solution {
    public int minOperations(String[] logs) {
        Stack<String> stk = new Stack<>();
        for(String str: logs) {
            if(!(str.equals("../") || str.equals("./")))
                stk.push(str);
            else if(str.equals("../") && !stk.isEmpty()) 
                stk.pop();
        }
        int c=0;
        while(!stk.isEmpty()) {
            stk.pop();
            c++;
        }
        return c;
    }
}