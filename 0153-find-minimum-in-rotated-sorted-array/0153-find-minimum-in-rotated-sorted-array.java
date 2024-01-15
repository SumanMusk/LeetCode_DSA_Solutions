class Solution {
    public int findMin(int[] nums) {
        int l=0,r=nums.length-1,ans=Integer.MIN_VALUE,f=0;
        while(l<=r){
            if(l == r){
                ans = nums[l];
                break;
            }
            else{
                f=0;
                int mid = (l+r)/2;
                int left = nums[mid] - nums[l];
                int right = nums[r] - nums[mid];
                if(left >= 0 && right >= 0)
                    r = mid;
                else if(left >= 0 && right < 0)
                    l = mid+1;
                else if(left < 0 && right >= 0)
                    r = mid;
            }
        }
        return ans;
    }
}