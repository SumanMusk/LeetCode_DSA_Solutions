class Solution {
    public int[] sortedSquares(int[] nums) {
        int arr[] = new int[nums.length];
        int c=nums.length-1,l=0,r=nums.length-1;
        while(l<=r){
            if(Math.abs(nums[l]) < Math.abs(nums[r]))
                arr[c--] = (int)Math.pow(nums[r--], 2);
            else if(l == r){
                arr[c--] = (int)Math.pow(nums[r--], 2);
                break;
            }
            else if(Math.abs(nums[l]) == Math.abs(nums[r])){
                arr[c--] = (int)Math.pow(nums[l++], 2);
                arr[c--] = (int)Math.pow(nums[r--], 2);
            }
            else if(Math.abs(nums[l]) > Math.abs(nums[r]))
                arr[c--] = (int)Math.pow(nums[l++], 2);
        }
        return arr;
    }
}