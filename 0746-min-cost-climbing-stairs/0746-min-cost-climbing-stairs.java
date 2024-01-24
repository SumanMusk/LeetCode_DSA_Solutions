class Solution {
    public int minCostClimbingStairs(int[] cost) {
        if(cost.length == 1)
            return cost[0];
        else{
            if(cost.length != 2){
                for(int i=cost.length-3;i>=0;i--){
                    int x = cost[i+1] + cost[i];
                    int y = cost[i+2] + cost[i];
                    cost[i] = Math.min(x,y);
                }
                int min = Integer.MAX_VALUE;
            }
            return Math.min(cost[0],cost[1]);
        }
    }
}