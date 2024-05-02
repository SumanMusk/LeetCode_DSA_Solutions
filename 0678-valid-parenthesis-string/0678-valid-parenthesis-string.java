// Using Stacks
class Solution {
    public boolean checkValidString(String s) {
        Stack<Integer> brkts = new Stack<>();
        Stack<Integer> stars = new Stack<>();
        for(int i=0;i<s.length();i++) {
            if(s.charAt(i) == '(')
                brkts.push(i);
            else if(s.charAt(i) == '*') 
                stars.push(i);
            else {
                if(!brkts.isEmpty())
                    brkts.pop();
                else if(!stars.isEmpty()) 
                    stars.pop();
                else return false;
            }
        }
        while(!brkts.isEmpty()) {
            if(stars.isEmpty()) return false;
            else {
                if(brkts.peek() > stars.peek())
                    return false;
                else {
                    brkts.pop();
                    stars.pop();
                }
            }
        }
        return true;
    }
}
/*
// Using Recursion
class Solution {
    public boolean checkValidString(String s) {
        return helper(0, 0, s, s.length());
    }

    public boolean helper(int idx, int openCount, String s, int n) {
        if(idx == n)
            return (openCount == 0) ? true : false;
        else {
            boolean isValid = false;
            if(s.charAt(idx) == '(')
                isValid |= helper(idx+1, openCount+1, s, n);
            else if(s.charAt(idx) == '*') {
                isValid |= helper(idx+1, openCount+1, s, n) // '*' considered as '('
                || helper(idx+1, openCount, s, n) // '*' considered as ' '
                || ((openCount > 0) && helper(idx+1, openCount-1, s, n)); // '*' considered as ')'
            }
            // for the case if(s.charAt(idx) == ')')
            else isValid |= ((openCount > 0) && helper(idx+1, openCount-1, s, n));
            return isValid;
        }
    }
}
*/