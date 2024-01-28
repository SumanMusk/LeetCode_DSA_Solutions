class Solution {
    public int countSubstrings(String s) {
        boolean dp[][] = new boolean[s.length()][s.length()];            
        int count=0;
        for(int x=0;x<s.length();x++){
            int j=x;
            for(int i=0;i<s.length();i++){
                if(j < s.length() && i < s.length()){
                    if(i == j)
                        dp[i][j] = true;
                    else if(j-i == 1){
                        if(s.charAt(i) == s.charAt(j)){
                            count++;
                            dp[i][j] = true;
                        }
                    }
                    else{
                        if(s.charAt(i) == s.charAt(j)){
                            if(dp[++i][--j]){
                                count++;
                                i--;
                                dp[i][++j] = true;
                            }
                            else{
                                i--;
                                j++;
                            }
                        }
                    }
                    j++;
                }
            }
        }
        return (count + s.length());
    }
}