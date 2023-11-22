class Solution {
    public static Map<Character, Integer> func(String s1){
        Map<Character, Integer> map = new HashMap<>();
        for(int i=0;i<s1.length();i++){
            if(map.containsKey(s1.charAt(i))){
                int x = map.get(s1.charAt(i));
                x++;
                map.put(s1.charAt(i), x);
            }
            else map.put(s1.charAt(i), 1);
        }
        return map;
    }
    public boolean checkInclusion(String s1, String s2) {
        Map<Character, Integer> str1 = func(s1);
        int l=0,r=s1.length()-1;
        int f=0;
        while(r<s2.length()){
            String s = s2.substring(l, r+1);
            Map<Character, Integer> str2 = func(s);
            if(str1.equals(str2)){
                f=1;
                break;
            }
            l++;
            r++;
        }
        if(f == 1) return true;
        else return false;
    }
}