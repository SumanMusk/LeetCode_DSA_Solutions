class Solution {
    public String[] findRelativeRanks(int[] score) {
        Queue<int[]> maxHeap = new PriorityQueue<>((a,b) -> b[0]-a[0]);
        for(int i=0;i<score.length;i++)
            maxHeap.add(new int[]{score[i], i});
        String res[] = new String[score.length];
        int f=1;
        while(!maxHeap.isEmpty()) {
            int data[] = maxHeap.poll();
            if(f == 1) 
                res[data[1]] = "Gold Medal";
            else if(f == 2) 
                res[data[1]] = "Silver Medal";
            else if(f == 3) 
                res[data[1]] = "Bronze Medal";
            else
                res[data[1]] = String.valueOf(f);
            f++;
        }
        return res;
    }
}
/*
// Slightly Optimizing with using a HashMap
class Solution {
    public String[] findRelativeRanks(int[] score) {
        int arr[] = Arrays.copyOf(score, score.length);
        Arrays.sort(arr);
        String res[] = new String[score.length];
        Map<Integer, String> map = new HashMap<>();
        for(int i=score.length-1,f=1;i>=0;i--,f++) {
            if(f == 1) 
                map.put(arr[i], "Gold Medal");
            else if(f == 2) 
                map.put(arr[i], "Silver Medal");
            else if(f == 3) 
                map.put(arr[i], "Bronze Medal");
            else
                map.put(arr[i], String.valueOf(f));
        }
        for(int i=0;i<score.length;i++) 
            res[i] = map.get(score[i]);
        return res;
    }
}
// Brute-force
class Solution {
    public String[] findRelativeRanks(int[] score) {
        int arr[] = Arrays.copyOf(score, score.length);
        Arrays.sort(arr);
        String res[] = new String[score.length];
        int f=1;
        for(int i=score.length-1;i>=0;i--) {
            for(int j=0;j<score.length;j++) {
                if(arr[i] == score[j]) {
                    if(f == 1) 
                        res[j] = "Gold Medal";
                    else if(f == 2) 
                        res[j] = "Silver Medal";
                    else if(f == 3) 
                        res[j] = "Bronze Medal";
                    else
                        res[j] = String.valueOf(f);
                    f++;
                }
            }
        }
        return res;
    }
}
*/