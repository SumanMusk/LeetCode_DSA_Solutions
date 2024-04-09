class Solution {
    public int[][] kClosest(int[][] points, int k) {
        Map<Double, List<int[]>> map = new HashMap<>();
        PriorityQueue<Double> minHeap = new PriorityQueue<>();
        for(int i=0;i<points.length;i++) {
            double temp = distance(points[i]);
            minHeap.add(temp);
            List<int[]> ls = map.getOrDefault(temp, new ArrayList<>());
            ls.add(points[i]);
            map.put(temp, ls);
        }
        int count=0;
        while(k != 0) {
            points[count++] = map.get(minHeap.poll()).removeFirst();
            k--;
        }
        return Arrays.copyOf(points, count);
    }
    public double distance(int arr[]) {
        return Math.sqrt((Math.pow(arr[0], 2) + Math.pow(arr[1], 2)));
    }
}