class Solution {
    public String longestCommonPrefix(String[] strs) {
        char x;
        int l = strs[0].length();
        for(int i=0;i<strs.length;i++){
            if(strs[i].length() <= l) 
                l = strs[i].length();
        }
        int c=0,i=0,f=0;
        String s = "";
        while(c<l){
            x = strs[0].charAt(c);
            for(int j=1;j<strs.length;j++){
                if(x!=strs[j].charAt(c)) {f=1; break;}
            }
            if(f == 0) {s = s+x; c++;}
            else break;
        }
        return s;
    }
}