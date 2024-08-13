class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int res = numBottles;
        while(numBottles != 0) {
            int newFullBottles = numBottles / numExchange;
            int remEmptyBottles = numBottles % numExchange;
            res += newFullBottles;
            if(newFullBottles == 0)
                break;
            numBottles = newFullBottles + remEmptyBottles;
        }
        return res;
    }
}