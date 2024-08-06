class Solution {
    public int minimumPushes(String word) {
        Map<Character, Integer> freqMap = new HashMap<>();
        for(char c: word.toCharArray()) 
            freqMap.put(c, freqMap.getOrDefault(c, 0)+1);
        List<Character> keyLs = new ArrayList<>(freqMap.keySet());
        Collections.sort(keyLs, (a,b) -> freqMap.get(b)-freqMap.get(a));
        List<Character> visited = new ArrayList<>();
        int level=1, res=0, range=8;
        for(char c: keyLs) {
            if(visited.size() == range) {
                level++;
                range += 8;
            }
            visited.add(c);
            res += level * freqMap.get(c);
        }
        return res;
    }
}