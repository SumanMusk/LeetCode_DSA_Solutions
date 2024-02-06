class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> ranMap= new HashMap<>();
        Map<Character, Integer> magMap= new HashMap<>();
        for(int i=0;i<ransomNote.length();i++){
            if(ranMap.containsKey(ransomNote.charAt(i))){
                int temp = ranMap.get(ransomNote.charAt(i));
                temp++;
                ranMap.put(ransomNote.charAt(i), temp);
            }
            else
                ranMap.put(ransomNote.charAt(i), 1);
            
        }
        for(int j=0;j<magazine.length();j++){
            if(magMap.containsKey(magazine.charAt(j)) && j<magazine.length()){
                int temp = magMap.get(magazine.charAt(j));
                temp++;
                magMap.put(magazine.charAt(j), temp);
            }
            else
                magMap.put(magazine.charAt(j), 1);
        }
        int f=0;
        for(Map.Entry<Character, Integer> set: ranMap.entrySet()){
            if(magMap.containsKey(set.getKey())){
                if(magMap.get(set.getKey()) < set.getValue()){
                    f=1;
                    break;
                }
            }
            else{
                f=1;
                break;
            }
        }
        if(f == 1) return false;
        return true;
    }
}