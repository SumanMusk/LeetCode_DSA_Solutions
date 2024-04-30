class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> ls = new ArrayList<>();
        Arrays.sort(intervals, (a,b) -> a[0]-b[0]);
        ls.add(intervals[0]);
        for(int i=1;i<intervals.length;i++) {
            if(ls.getLast()[1] >= intervals[i][0]) {
                int arr[] = ls.removeLast();
                ls.add(new int[]{arr[0], Math.max(arr[1], intervals[i][1])});
            }
            else 
                ls.add(intervals[i]);
        }
        return ls.toArray(new int[ls.size()][]);
    }
}