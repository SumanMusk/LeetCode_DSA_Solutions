class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean dp[] = new boolean[s.length()+1];
        dp[s.length()] = true;
        for(int i=s.length()-1;i>=0;i--){
            for(String temp: wordDict){
                if((i + temp.length()) <= s.length()){
                    if(temp.equals(s.substring(i, (i + temp.length()))) && !dp[i])
                        dp[i] = dp[i + temp.length()];
                }
            }
        }
        return dp[0];
    }
}