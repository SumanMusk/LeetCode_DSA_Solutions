class Solution {
    public int numDecodings(String s) {
        int dp[] = new int[s.length()+1];
        dp[s.length()] = 1;
        for(int i=s.length()-1;i>=0;i--){
            if(s.charAt(i)!='0'){
                dp[i] = dp[i+1];
                if(i < s.length()-1){
                    int val = (s.charAt(i)-'0')*10 + s.charAt(i+1)-'0';
                    if(val <= 26 && val >=10)
                        dp[i] = dp[i] + dp[i+2];
                }
            }
        }
        return dp[0];
    }
}