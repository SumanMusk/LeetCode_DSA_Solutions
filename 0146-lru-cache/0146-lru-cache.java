class LRUCache {
    int len;
    Map<Integer, Integer> map;
    Queue<Integer> que;
    public LRUCache(int capacity) {
        map = new HashMap<>();
        que = new LinkedList<>();
        len = capacity;
    }
    
    public int get(int key) {
        if(!map.containsKey(key))
            return -1;
        que.remove(key);
        que.add(key);
        return map.get(key);
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)) {
            que.remove(key);
            que.add(key);
            map.put(key, value);
        }
        else {
            if(que.size() == len) {
                int k = que.poll();
                map.remove(k);
            }
            que.add(key);
            map.put(key, value);
        }
    }
}

// Solved by Using Queue

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */