class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int start=0, end=k-1,f=0;
        double ans = Integer.MIN_VALUE;
        double sum=0;
        while(end<nums.length){
            double avg = 0;
            if(f == 0){
                for(int i=start;i<=end;i++)
                    sum += nums[i];
                avg = sum / k;
                f=1;
                end++;
            }
            else{
                sum -= nums[start++];
                sum += nums[end++];
                avg = sum / k;
            }
            ans = Math.max(avg, ans);
        }
        return ans;
    }
}