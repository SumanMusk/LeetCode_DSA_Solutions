class Solution {
    Map<String, List<Integer>> dp = new HashMap<>();
    public List<Integer> diffWaysToCompute(String expression) {
        return solve(expression);
    }
    public List<Integer> solve(String s) {
        int count=0;
        for(int i=0;i<s.length();i++) 
            if(Character.isDigit(s.charAt(i)))        
                count++;
        if((s.charAt(0) == '-' && count+1 == s.length()) || count == s.length())
            return new ArrayList<>(Arrays.asList(Integer.parseInt(s)));
        int z=0;
        List<Integer> ls = new ArrayList<>();
        if(dp.containsKey(s)) 
            return dp.get(s);            
        for(int i=0;i<s.length();i++) {
            char c = s.charAt(i);
            if(c == '-' || c == '*' || c == '+') {
                List<Integer> leftLs = solve(s.substring(0, i));
                List<Integer> rightLs = solve(s.substring(i+1, s.length()));         
                for(int x: leftLs) {
                    for(int y: rightLs) {
                        if(c == '-')
                            z = x-y;
                        if(c == '*')
                            z = x*y;
                        if(c == '+')
                            z = x+y; 
                        ls.add(z);
                        dp.put(s, ls);
                    }
                }                                
            }
        }
        return ls;
    }
}