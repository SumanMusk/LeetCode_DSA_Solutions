// With an Extra Space
class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> a[1]-b[1]);
        int count=0;
        int intFir[] = intervals[0];
        for(int i=1;i<intervals.length;i++) {
            if(intervals[i][0] < intFir[1]) 
                count++;
            else 
                intFir = intervals[i];
        }
        return count;
    }
}
// Without an Extra Space
/*class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> a[1]-b[1]);
        List<int[]> ls = new ArrayList<>();
        int count=0;
        int intFir[] = intervals[0];
        for(int i=1;i<intervals.length;i++) {
            if(intervals[i][0] < intFir[1]) 
                count++;
            else 
                intFir = intervals[i];
        }
        return count;
    }
}*/