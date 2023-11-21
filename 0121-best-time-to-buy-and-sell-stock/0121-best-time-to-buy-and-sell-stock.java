class Solution {
    public int maxProfit(int[] prices) {
        int ans = Integer.MIN_VALUE;
        int l=0, r=1, f=0;
        while(l<prices.length-1 && r<prices.length){
            if(prices[l] < prices[r]){
                int temp = prices[r] - prices[l];
                if(temp > ans)
                    ans = temp;
                r++;
                f=1;
            }
            else{
                l++;
                r = l+1;
            }
        }
        if(f == 1)
            return ans;
        else
            return 0;
    }
}