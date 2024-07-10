class Solution {
    public int minOperations(String[] logs) {
        Stack<String> stk = new Stack<>();
        for(String str: logs) {
            if(!(str.equals("../") || str.equals("./")))
                stk.push(str);
            else if(str.equals("../") && !stk.isEmpty()) 
                stk.pop();
        }
        return stk.size();
    }
}