class Solution {
    public int minimumDeletions(String s) {
        int dp[] = new int[s.length()];
        for(int i=s.length()-2;i>=0;i--) 
            dp[i] = dp[i+1] + (s.charAt(i+1) == 'a' ? 1 : 0);
        int b_count_left=0, res=s.length();
        for(int i=0;i<s.length();i++) {
            res = Math.min(res, (dp[i] + b_count_left));
            if(s.charAt(i) == 'b')
                b_count_left++;
        }
        return res;
    }
}