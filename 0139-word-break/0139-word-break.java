// Recursion + Memorization = DP - Top-Down Approach
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean dp[] = new boolean[s.length()+1];
        dp[0] = true;
        for(int i=1;i<=s.length();i++) {
            for(String word: wordDict) {
                int len = i-word.length();
                if(len >= 0 && s.substring(len, i).equals(word) && !dp[i])
                    dp[i] = dp[len];
            }
        }
        return dp[s.length()];
    }
}
/*
// Recursion
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        return solve(s, wordDict);
    }
    public boolean solve(String s, List<String> ls) {
        if(s.equals(""))
            return true;
        for(int i=1;i<=s.length();i++) 
            for(String word: ls)
                if(s.substring(0, i).equals(word))
                    if(solve(s.substring(i, s.length()), ls))
                        return true;
        return false;
    }
}

// Bottom-UP DP
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
*/