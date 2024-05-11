class Solution {
    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        List<Pair<Double, Integer>> costLs = new ArrayList<>();
        Queue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0;i<wage.length;i++) 
            costLs.add(new Pair<>((double)wage[i]/quality[i], quality[i]));
        Collections.sort(costLs, (a,b) -> Double.compare(a.getKey(), b.getKey()));
        double totalCost=0, res=Double.POSITIVE_INFINITY;
        for(Pair<Double, Integer> pair: costLs) {
            double currCostRatio = pair.getKey();
            int currQulty = pair.getValue();
            totalCost += currQulty;
            maxHeap.add(currQulty);
            if(maxHeap.size() > k)
                totalCost -= maxHeap.poll();
            if(maxHeap.size() == k)            
                res = Math.min(res, (totalCost*currCostRatio));
        }
        return res;
    }
}