class Solution {
    public int characterReplacement(String s, int k) {
        int ans=0, l=0, r=0, maxFreq=0, f=0;
        Map<Character, Integer> map = new HashMap<>();
        while(r<s.length()){
            if(f == 0)
                map.put(s.charAt(r), map.getOrDefault(s.charAt(r), 0)+1);
            maxFreq = Math.max(maxFreq, map.get(s.charAt(r)));

            if(((r-l+1) - maxFreq) <= k) {
                ans = Math.max(ans, (r-l+1));
                f = 0;
                r++;
            }
            else {
                map.put(s.charAt(l), map.get(s.charAt(l))-1);
                f = 1;
                l++;
            }
        }
        return ans;
    }
}
/*class Solution {
    public int characterReplacement(String s, int k) {
        int ans=0,l=0,r=0;
        while(r<s.length()){
            int maxFreq = Integer.MIN_VALUE;
            Map<Character, Integer> map = new HashMap<>();
            for(int i=l;i<=r;i++) {
                map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0)+1);
                maxFreq = Math.max(maxFreq, map.get(s.charAt(i)));
            }

            if(((r-l+1) - maxFreq) <= k) {
                ans = Math.max(ans, (r-l+1));
                r++;         
            }
            else l++;
        }
        return ans;
    }
}*/