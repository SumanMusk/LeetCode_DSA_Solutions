class Solution {
    public int strStr(String haystack, String needle) {
        int l=0,r=needle.length()-1;
        while(r < haystack.length()) {
            if(haystack.substring(l, r+1).equals(needle)) return l;
            l++;
            r++;
        }
        return -1;
    }
}