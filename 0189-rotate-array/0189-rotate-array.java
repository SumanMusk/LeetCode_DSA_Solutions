class Solution {
    public void rotate(int[] nums, int k) {        
        if(nums.length != 1 && nums.length != 0 && k != 0 && (k % nums.length) != 0){
            k = k % nums.length;
            int r=nums.length-1;
            for(int i=0;i<nums.length/2;i++){
                int temp = nums[i];
                nums[i] = nums[r];
                nums[r] = temp;
                r--;
            }
            // first part
            r = k-1;
            int start = 0;
            while(start < r){
                int temp = nums[start];
                nums[start] = nums[r];
                nums[r] = temp;
                start++;
                r--;
            }
            // rest of the part
            r = nums.length-1;
            int i=k;
            while(i<r){
                int temp = nums[i];
                nums[i] = nums[r];
                nums[r] = temp;
                r--;
                i++;
            }
        }
    }
}