class Solution {
    public int minimumPushes(String word) {
        Map<Character, Integer> freqMap = new HashMap<>();
        Character keysArr[] = new Character[26];
        int c=0;
        for(char letter: word.toCharArray()) {
            if(!freqMap.containsKey(letter)) {
                freqMap.put(letter, 1);
                keysArr[c++] = letter;
            }
            else
                freqMap.put(letter, freqMap.get(letter)+1);
        }
        Arrays.sort(keysArr, 0, c, (a,b) -> freqMap.get(b)-freqMap.get(a));
        int level=1, res=0, range=8, currSize=0;
        for(int i=0;i<c;i++) {
            if(currSize == 8) {
                level++;
                currSize=0;
            }
            currSize++;
            res += level * freqMap.get(keysArr[i]);
        }
        return res;
    }
}
/*
// Using ArrayList to store the key Characters and sorting purpose
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
*/