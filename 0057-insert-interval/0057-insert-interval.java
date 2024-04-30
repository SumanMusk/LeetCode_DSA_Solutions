class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> ls = new ArrayList<>();
        int i=0;
        while(i < intervals.length) {
            // for the previous intervals, we just add those intervals into 'ls'
            if(intervals[i][1] < newInterval[0])
                ls.add(intervals[i]);
            // prefect position for inserting newInterval(after merging or without any merging) into the 'ls' list
            else if(intervals[i][0] > newInterval[1])
                break;
            // merge case
            else {
                newInterval[0] = Math.min(intervals[i][0], newInterval[0]);
                newInterval[1] = Math.max(intervals[i][1], newInterval[1]);
            }
            i++;
        }
        // inserting the merged or non-merged newInterval and then the rest of the intervals are added into the list 'ls'
        ls.add(newInterval);
        while(i < intervals.length) 
            ls.add(intervals[i++]);

        return ls.toArray(new int[ls.size()][]);
    }
}