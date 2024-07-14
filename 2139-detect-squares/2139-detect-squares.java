class DetectSquares {
    List<int[]> ls;
    Map<String, Integer> map;
    public DetectSquares() {
        ls = new ArrayList<>();
        map = new HashMap<>();
    }
    
    public void add(int[] point) {
        ls.add(point);
        map.put(Arrays.toString(point), map.getOrDefault(Arrays.toString(point), 0)+1);
    }
    // this method 
    public int count(int[] point) {
        int x=point[0];
        int y=point[1];
        int ans=0;
        for(int arr[]: ls) {
            if(arr[0] == x || arr[1] == y || Math.abs(arr[0]-x) != Math.abs(arr[1]-y)) 
                continue;
            ans += map.getOrDefault(Arrays.toString(new int[]{x, arr[1]}), 0) * map.getOrDefault(Arrays.toString(new int[]{arr[0], y}), 0);
        }
        return ans;
    }
}

/**
 * Your DetectSquares object will be instantiated and called as such:
 * DetectSquares obj = new DetectSquares();
 * obj.add(point);
 * int param_2 = obj.count(point);
 */