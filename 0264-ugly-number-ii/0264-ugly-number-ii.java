/*class Solution {
    public int nthUglyNumber(int n) {
        Queue<Long> minHeap = new PriorityQueue<>();
        minHeap.add((long)1);

        Set<Long> visited = new HashSet<>();

        int c=1;
        long res=0;
        long factors[] = {2,3,5};

        while(c <= n) {
            res = minHeap.poll();
            c++;

            for(long i: factors) {
                long temp = res * i;
                if(!visited.contains(temp)) {
                    minHeap.add(temp);
                    visited.add(temp);
                }
            }
        }
        return (int)res;
    }
}*/

// Dp Approach
class Solution {
    public int nthUglyNumber(int n) {
        int dp[] = new int[n+1];
        int i2=1, i3=1, i5=1;
        dp[1] = 1;
        for(int idx=2;idx<=n;idx++) {
            int two_val = dp[i2] * 2;
            int three_val = dp[i3] * 3;
            int five_val = dp[i5] * 5;

            dp[idx] = Math.min(two_val, Math.min(three_val, five_val)); 

            if(dp[idx] == two_val)
                i2++;
            if(dp[idx] == three_val)
                i3++;
            if(dp[idx] == five_val)
                i5++;
        }
        return dp[n];
    }
}