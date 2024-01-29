import java.util.*;
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> mp = new HashMap<>();
        for(String str: strs){
            char arr[] = str.toCharArray();
            Arrays.sort(arr);
            String s = String.valueOf(arr);
            if(!mp.containsKey(s))
                mp.put(s, new ArrayList<>());
            mp.get(s).add(str);
        }
        return new ArrayList<>(mp.values());
    }
}