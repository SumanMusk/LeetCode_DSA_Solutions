class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i: arr){
            if(map.containsKey(i)) map.put(i, map.get(i)+1);
            else map.put(i, 1);
        }
        Set<Integer> set = new HashSet<>();
        Iterator<Integer> itr = map.keySet().iterator();
        int f=0;
        while(itr.hasNext()){
            Integer key = itr.next();
            if(set.contains(map.get(key))){
                f=1;
                break;
            }
            else set.add(map.get(key));
        }
        if(f == 1) return false;
        return true;
    }
}