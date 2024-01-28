class Solution {
    public String longestPalindrome(String s) {
        boolean dp[][] = new boolean[s.length()][s.length()];            
        int arr[] = new int[2];
        arr[1] = 1;
        for(int x=0;x<s.length();x++){
            int j=x;
            for(int i=0;i<s.length();i++){
                if(j < s.length() && i < s.length()){
                    if(i == j)
                        dp[i][j] = true;
                    else if(j-i == 1){
                        if(s.charAt(i) == s.charAt(j)){
                            arr[0] = i;
                            arr[1] = j+1;
                            dp[i][j] = true;
                        }
                    }
                    else{
                        if(s.charAt(i) == s.charAt(j)){
                            if(dp[++i][--j]){
                                arr[0] = --i;
                                arr[1] = j+2;
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
        return s.substring(arr[0], arr[1]);
    }
}