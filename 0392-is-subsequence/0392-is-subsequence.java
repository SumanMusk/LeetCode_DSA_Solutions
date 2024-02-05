class Solution {
    public boolean isSubsequence(String s, String t) {
        if(s.length() !=0){
            int i=0,j=0;
            while(i<t.length()){
                if(j == s.length())
                    break;
                else if(t.charAt(i) == s.charAt(j)){
                    i++;j++;
                }
                else i++;
            }
            if(j < s.length()) return false;
            return true;
        }
        else return true;
    }
}