class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int sumGas=0, sumCost=0;
        for(int i=0;i<gas.length;i++) {
            sumGas += gas[i];
            sumCost += cost[i];
        }
        if(sumGas < sumCost) return -1;
        if(gas.length == 1) return 0;
        int diff[] = new int[gas.length];
        for(int i=0;i<gas.length;i++) 
            diff[i] = gas[i] - cost[i];
        int total=0, idx=-1, f=0;
        for(int i=0;i<gas.length;i++) {
            total += diff[i];
            if(total > 0 && f == 0) {
                idx = i;
                f=1;
            }
            else if(total < 0) {
                total=0;
                f=0;
            }
        }
        return idx;
    }
}