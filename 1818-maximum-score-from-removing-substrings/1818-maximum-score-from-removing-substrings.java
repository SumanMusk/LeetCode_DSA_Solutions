class Solution {
    public int maximumGain(String s, int x, int y) {
        String chkStr = (x < y) ? "ba" : "ab";
        int res = 0, cNum = (x < y) ? y : x;
        Stack<Character> stk = new Stack<>();
        res = helper(s, stk, chkStr, cNum, 0);
        cNum = (x+y)-cNum;
        chkStr = (chkStr.equals("ba")) ? "ab" : "ba";
        s = new StringBuilder(stk.stream().map(String::valueOf).collect(Collectors.joining())).toString();
        return res + helper(s, stk, chkStr, cNum, 0);
    }
    public int helper(String s, Stack<Character> stk, String chkStr, int x, int res) {
        if(s.length() == 0) return 0;
        stk.push(s.charAt(0));
        for(int i=1;i<s.length();i++) {
            if(s.charAt(i) == chkStr.charAt(1) && !stk.isEmpty() && stk.peek() == chkStr.charAt(0)) {
                stk.pop();
                res += x;
            }
            else stk.push(s.charAt(i));
        }
        return res;
    }
}