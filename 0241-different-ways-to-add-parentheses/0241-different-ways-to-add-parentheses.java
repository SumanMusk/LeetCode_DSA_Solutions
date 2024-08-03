class Solution {
    public List<Integer> diffWaysToCompute(String expression) {
        int f=0;
        for(int i=0;i<expression.length();i++) {
            if(expression.charAt(i) == '-' || expression.charAt(i) == '*' || expression.charAt(i) == '+') {
                f=1;
                break;
            }
        }
        if(f == 0)
            return new ArrayList<>(Arrays.asList(Integer.parseInt(expression)));
        return solve(expression, 0);
    }
    public List<Integer> solve(String s, int depth) {
        int count=0;
        for(int i=0;i<s.length();i++) 
            if(Character.isDigit(s.charAt(i)))        
                count++;
        if((s.charAt(0) == '-' && count+1 == s.length()) || count == s.length())
            return new ArrayList<>(Arrays.asList(Integer.parseInt(s)));
        int z=0;
        List<Integer> ls = new ArrayList<>();
        for(int i=0;i<s.length();i++) {
            char c = s.charAt(i);
            if(c == '-' || c == '*' || c == '+') {
                List<Integer> leftLs = solve(s.substring(0, i), ++depth);
                depth--;
                List<Integer> rightLs = solve(s.substring(i+1, s.length()), ++depth);
                depth--;                
                for(int x: leftLs) {
                    for(int y: rightLs) {
                        int a = x;
                        int b = y;
                        if(c == '-')
                            z = a-b;
                        if(c == '*')
                            z = a*b;
                        if(c == '+')
                            z = a+b;
                        ls.add(z);
                    }
                }                                
            }
        }
        return ls;
    }
}