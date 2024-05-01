class Twitter {
    Map<Integer, List<int[]>> tweetMap;
    Map<Integer, Set<Integer>> folw_Map;
    int postTime;
    public Twitter() {
        this.postTime=0;
        this.tweetMap = new HashMap<>();
        this.folw_Map = new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        if(!tweetMap.containsKey(userId))
            tweetMap.put(userId, new ArrayList<>());
        List<int[]> ls = tweetMap.get(userId);
        ls.add(new int[]{postTime, tweetId});
        tweetMap.put(userId, ls);
        postTime++;
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> res = new ArrayList<>();
        Queue<int[]> maxHeap = new PriorityQueue<>((a,b) -> b[0]-a[0]);
        if(!folw_Map.containsKey(userId))
            folw_Map.put(userId, new HashSet<>());

        folw_Map.get(userId).add(userId);

        for(int user: folw_Map.get(userId)) {
            if(tweetMap.containsKey(user)) {
                int idx = tweetMap.get(user).size()-1;
                int data[] = tweetMap.get(user).get(idx);
                maxHeap.add(new int[]{data[0], data[1], user, --idx});
            }
        }
        while(!maxHeap.isEmpty() && res.size() < 10) {
            int data[] = maxHeap.poll();
            res.add(data[1]);
            if(data[3] >= 0) {
                int newData[] = tweetMap.get(data[2]).get(data[3]);
                maxHeap.add(new int[]{newData[0], newData[1], data[2], --data[3]});
            }
        }
        return res;
    }
    
    public void follow(int followerId, int followeeId) {
        if(!folw_Map.containsKey(followerId))
            folw_Map.put(followerId, new HashSet<>());
        Set<Integer> set = folw_Map.get(followerId);
        set.add(followeeId);
        folw_Map.put(followerId, set);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if(!folw_Map.containsKey(followerId))
            folw_Map.put(followerId, new HashSet<>());
        Set<Integer> set = folw_Map.get(followerId);
        if(set.contains(followeeId))
            set.remove(followeeId);
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */