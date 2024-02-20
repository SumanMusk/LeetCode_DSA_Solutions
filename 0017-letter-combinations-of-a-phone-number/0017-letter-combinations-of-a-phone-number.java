class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> ls = new ArrayList<>();
        List<String> temp = new ArrayList<>();
        Map<Integer, String> map = new HashMap<>();
        map.put(2, "abc");
        map.put(3, "def");
        map.put(4, "ghi");
        map.put(5, "jkl");
        map.put(6, "mno");
        map.put(7, "pqrs");
        map.put(8, "tuv");
        map.put(9, "wxyz");        
        if(digits.equals("")) return ls;    
        letComb(digits, map, ls, temp, 0);
        return ls;
    }
    public void letComb(String s, Map<Integer, String> map, List<String> ls, List<String> temp, int idx){
        if(idx == s.length()){
            String res = "";
            for(String str: temp)
                res += str;
            ls.add(res);
            return;
        }
        else{
            for(int i=0;i<map.get((s.charAt(idx)-'0')).length();i++){
                temp.add(Character.toString(map.get(s.charAt(idx)-'0').charAt(i)));
                letComb(s, map, ls, temp, idx+1);
                temp.removeLast();
            }
        }
    }
}