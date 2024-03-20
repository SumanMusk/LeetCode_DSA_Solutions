class Solution {
    public int firstUniqChar(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for(int i=0;i<s.length();i++) 
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
            
        for(int i=0;i<s.length();i++) {
            if(map.get(s.charAt(i)) == 1) return i;
        }
        return -1;
    }
}
/*if(!map.containsKey(s.charAt(i)))
    map.put(s.charAt(i), 0);
map.put(s.charAt(i), map.get(s.charAt(i))+1);*/
// we can reduce this lines of code by just using a HashMap method getOrDefault()
// map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);