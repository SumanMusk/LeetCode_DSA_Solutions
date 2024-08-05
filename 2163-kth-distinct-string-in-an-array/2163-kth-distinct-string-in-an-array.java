class Solution {
    public String kthDistinct(String[] arr, int k) {
        Map<String, Integer> map = new HashMap<>();
        List<String> ls = new ArrayList<>();
        for(String s: arr) 
            map.put(s, map.getOrDefault(s, 0)+1);
        for(String s: arr) {
            if(map.get(s) == 1)
                k--;
            if(k == 0)
                return s;
        }        
        return "";
    }
}
/*
class Solution {
    public String kthDistinct(String[] arr, int k) {
        Map<String, Integer> map = new HashMap<>();
        List<String> ls = new ArrayList<>();
        for(String s: arr) {
            if(map.containsKey(s))
                map.put(s, map.get(s)+1);
            else {
                map.put(s, 1);
                ls.add(s);
            }
        }
        Collections.sort(ls, (a,b) -> map.get(a)-map.get(b));
        if(k-1 >= ls.size())
            return "";
        return ls.get(k-1);
    }
}
*/