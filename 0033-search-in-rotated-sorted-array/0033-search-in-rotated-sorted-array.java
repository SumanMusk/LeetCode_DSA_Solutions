class Solution {
    public int search(int[] nums, int target) {
        int f=0,l=0,r=nums.length-1,ans=-1,pivot=0;
        // check if the given array is actually sorted or rotated sorted array
        for(int i=1;i<nums.length;i++){
            if(nums[i] < nums[i-1]){
                f=1;
                break;
            }
        }
        // the array is rotated sorted array
        if(f == 1){
            // finding the pivot position
            while(l<=r){
                int mid = (l+r)/2;
                if(nums[mid+1] < nums[mid]){
                    pivot = mid;
                    break;
                }
                else if(nums[l] <= nums[mid]) l = mid+1;
                else r = mid-1;
            }
            // searching in first portion with pivot element
            l=0;
            r=pivot;
            while(l<=r){
                int mid = (l+r)/2;
                if(nums[mid] == target) return mid;
                else if(nums[mid] > target) r = mid-1;                
                else l = mid+1;
            }
            // searching in second portion
            l=pivot+1;
            r=nums.length-1;
            while(l<=r){
                int mid = (l+r)/2;
                if(nums[mid] == target) return mid;
                else if(nums[mid] > target) r = mid-1;                
                else l = mid+1;
            }
        }
        // the given array is an actual sorted array, so normal binary-search performed
        else{
            while(l<=r){
                int mid = (l+r)/2;
                if(nums[mid] == target) return mid;
                else if(nums[mid] > target) r = mid-1;                
                else l = mid+1;
            }
        }
        return -1;
    }
}
/*
Map<Integer, Integer> map = new HashMap<>();
for(int i=0;i<nums.length;i++) map.put(nums[i], i);
if(map.containsKey(target)) return map.get(target);
else return -1;
*/