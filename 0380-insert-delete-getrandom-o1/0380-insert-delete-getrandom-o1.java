class RandomizedSet {
    Map<Integer, Integer> map;
    List<Integer> ls;
    int idx = 0;

    public RandomizedSet() {
        ls = new ArrayList<>();
        map = new HashMap<>();
    }
    
    public boolean insert(int val) {
        // Deleted value's indexes are updated with -1, so that value isn't exists into the main ArrayList and that checked with "map.get(val) != -1" condition
        if(map.containsKey(val) && map.get(val) != -1) return false;
        map.put(val, idx++);
        ls.add(val);
        return true;
    }
    
    public boolean remove(int val) {
        // Deleted value's indexes are updated with -1, so existing indexes are not considered and that checked with "map.get(val) == -1" condition
        if(!map.containsKey(val) || map.get(val) == -1) return false;
        // Swapping
        int temp = ls.getLast();
        ls.set(ls.size()-1, val);
        ls.set(map.get(val), temp);
        // Removing Element
        map.replace(temp, map.get(val));
        map.replace(val, -1);
        ls.removeLast();
        // Adjusting the global index "idx" value
        idx-=1;
        return true;
    }
    
    public int getRandom() {
        Random random = new Random();
        // 0 to idx range
        int ran = random.nextInt(idx)+0;
        return ls.get(ran);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */