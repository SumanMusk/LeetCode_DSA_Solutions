// 2D Dynamic Programming(Most Optiamal)
class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        boolean dp[][] = new boolean[s1.length()+1][s2.length()+1];
        dp[0][0] = true;
        if(s1.length()+s2.length() != s3.length()) return false;
        for(int i=1;i<=s1.length();i++){
            if(s1.charAt(i-1) == s3.charAt(i-1)) dp[i][0] = dp[i-1][0];
        }
        for(int i=1;i<=s2.length();i++){
            if(s2.charAt(i-1) == s3.charAt(i-1)) dp[0][i] = dp[0][i-1];
        }
        for(int i=1;i<=s1.length();i++){
            for(int j=1;j<=s2.length();j++){
                int x = i+j-1;
                if(s1.charAt(i-1) == s3.charAt(i+j-1))
                    dp[i][j] = dp[i-1][j];
                if(s2.charAt(j-1) == s3.charAt(i+j-1) && !dp[i][j])
                    dp[i][j] = dp[i][j-1];
            }
        }
        return dp[s1.length()][s2.length()];
    }
}
/*
// With Recursion(Least Optiamal)
class Solution {
    public boolean findTargetSumWays(String s1, String s2, String s3, int idxS1, int idxS2, int idxS3) {
        if(idxS3 == s3.length()){
            if(idxS1 == s1.length() && idxS2 == s2.length()) return true;
            return false;
        }
        else{
            boolean res = false;
            if(idxS1 < s1.length() && idxS3 < s3.length() && s1.charAt(idxS1) == s3.charAt(idxS3)) res = findTargetSumWays(s1, s2, s3, idxS1+1, idxS2, idxS3+1);
            if(idxS2 < s2.length() && idxS3 < s3.length() && s2.charAt(idxS2) == s3.charAt(idxS3) && !res) res = findTargetSumWays(s1, s2, s3, idxS1, idxS2+1, idxS3+1);
            return res;
        }
    }
    public boolean isInterleave(String s1, String s2, String s3) {
        boolean result = false;
        if(s1.length() + s2.length() == s3.length())
            result = findTargetSumWays(s1, s2, s3, 0, 0, 0);
        return result;
    }
}

// Recursion with Memorization
class Solution {
    public boolean findTargetSumWays(Map<String, Boolean> map, String s1, String s2, String s3, int idxS1, int idxS2, int idxS3) {
        if(idxS3 == s3.length()){
            if(idxS1 == s1.length() && idxS2 == s2.length()) return true;
            return false;
        }
        else{
            String str = s1.substring(0, idxS1)+"*"+s2.substring(0, idxS2)+"*"+s3.substring(0, idxS3);
            if(map.containsKey(str)) return map.get(str);
            else{
                boolean res = false;
                if(idxS1 < s1.length() && idxS3 < s3.length() && s1.charAt(idxS1) == s3.charAt(idxS3)) res = findTargetSumWays(map, s1, s2, s3, idxS1+1, idxS2, idxS3+1);
                if(idxS2 < s2.length() && idxS3 < s3.length() && s2.charAt(idxS2) == s3.charAt(idxS3) && !res) res = findTargetSumWays(map, s1, s2, s3, idxS1, idxS2+1, idxS3+1);
                map.put(str, res);
                return res;
            }
        }
    }
    public boolean isInterleave(String s1, String s2, String s3) {
        Map<String, Boolean> map = new HashMap<>();
        boolean res = findTargetSumWays(map, s1, s2, s3, 0, 0, 0);
        return res;
    }
}*/