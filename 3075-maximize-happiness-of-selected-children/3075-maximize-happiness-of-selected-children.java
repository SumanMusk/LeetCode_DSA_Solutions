class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {
        Arrays.sort(happiness);
        int i=happiness.length-1, j=0;
        long ans=0;
        while(j < k) {
            long temp = (long)happiness[i--] - j++;
            ans += (temp <= 0) ? 0 : temp;
        }
        return ans;
    }
}