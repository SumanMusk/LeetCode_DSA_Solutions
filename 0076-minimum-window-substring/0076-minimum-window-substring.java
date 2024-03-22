class Solution {
    public String minWindow(String s, String t) {
        String ans = "";
        if(t.length() > s.length()) return ans;
        int l=0,r=0,slen=0,Len=Integer.MAX_VALUE;
        Map<Character, Integer> map = new HashMap<>();
        for(int i=0;i<t.length();i++)
            map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0)+1);
        while(r<s.length()) {
            int f=0;
            if(map.containsKey(s.charAt(r))) {
                map.put(s.charAt(r), map.getOrDefault(s.charAt(r), 0)-1);
                f=1;
                if(map.get(s.charAt(r)) == 0)
                    slen++;
            }
            else r++;
            while(slen == map.size() && l <= r) {
                if(r-l+1 < Len) {
                    Len = r-l+1;
                    ans = s.substring(l, r+1);
                }
                if(map.containsKey(s.charAt(l))) {
                    map.put(s.charAt(l), map.get(s.charAt(l))+1);
                    if(map.get(s.charAt(l)) > 0) slen--;
                }
                l++;
            }
            if(f == 1) r++;
        }
        return ans;
    }
}