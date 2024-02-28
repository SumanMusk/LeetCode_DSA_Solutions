class Solution {
    public int numDistinct(String s, String t) {
        if(s.length() < t.length()) return 0;
        int dp[][] = new int[s.length()][t.length()];
        if(s.charAt(s.length()-1) == t.charAt(t.length()-1)) dp[s.length()-1][t.length()-1] = 1;
        for(int i=s.length()-2;i>=0;i--){
            for(int j=t.length()-1;j>=0;j--){
                // if both current indexed characters are same
                if(s.charAt(i) == t.charAt(j)){
                    if(j+1 == t.length()) dp[i][j] = 1 + dp[i+1][j];
                    else dp[i][j] = dp[i+1][j] + dp[i+1][j+1];
                }
                // if both current indexed characters are not same
                else dp[i][j] = dp[i+1][j];
            }
        }
        return dp[0][0];
    }
}