class Solution {
    public String reverseParentheses(String s) {
        Stack<Character> stk = new Stack<>();
        String res = "";
        for(int i=0;i<s.length();i++) {
            if(s.charAt(i) == ')') {
                while(stk.peek() != '(')
                    res += Character.toString(stk.pop());
                    /// res = Character.toString(stk.pop()) + res;
                stk.pop();
                for(int j=0;j<res.length();j++)
                    stk.push(res.charAt(j));
                res = "";
            }
            else 
                stk.push(s.charAt(i));
        }
        while(!stk.isEmpty()) 
            res = Character.toString(stk.pop()) + res;
        return res;
    }
}