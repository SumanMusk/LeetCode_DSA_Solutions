class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> ls = new ArrayList<>();
        Map<Character, Integer> map = new HashMap<>();
        for(int i=0;i<s.length();i++)
            map.put(s.charAt(i), i);
        int l=0, r=0;
        while(l < s.length()) {
            int leftMost = l;
            r = Math.max(r, map.get(s.charAt(l)));
            while(l <= r) {
                r = Math.max(r, map.get(s.charAt(l)));
                l++;
            }
            ls.add(l-leftMost);
        }
        return ls;
    }
}
/*class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> ls = new ArrayList<>();
        Map<Character, Integer> map = new HashMap<>();
        for(char c: s.toCharArray())
            map.put(c, map.getOrDefault(c, 0)+1);
        int l=0, r=0;
        while(r < s.length()) {
            Map<Character, Integer> winFreq = new HashMap<>();
            for(int i=l;i<=r;i++)
                winFreq.put(s.charAt(i), winFreq.getOrDefault(s.charAt(i), 0)+1);
            int f=0;
            Iterator<Character> itr = winFreq.keySet().iterator();
            while(itr.hasNext()) {
                char key = itr.next();
                if(winFreq.get(key) < map.get(key))
                    f=1;
            }
            if(f == 0) {
                ls.add((r+1)-l);
                l = r+1;
            }
            r++;
        }
        return ls;
    }
}*/