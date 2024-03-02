class TimeMap {
    Map<String, List<Pair<String, Integer>>> map;
    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if(!map.containsKey(key)) map.put(key, new ArrayList<>());
        map.get(key).add(new Pair(value, timestamp));
    }
    
    public String get(String key, int timestamp) {
        String res = "";
        if(!map.containsKey(key)) return res;
        List<Pair<String, Integer>> ls = map.get(key);
        int l=0,r=ls.size()-1;
        while(l<=r){
            int mid = (l+r)/2;
            if(ls.get(mid).getValue() <= timestamp){
                res = ls.get(mid).getKey();
                l = mid+1;
            }
            else r = mid-1;
        }
        return res;
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */