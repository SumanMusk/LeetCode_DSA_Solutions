class Solution {
    public boolean canPartition(int[] nums) {
        int sum=0;
        for(int i: nums)
            sum += i;
        if(nums.length > 1 && sum % 2 == 0){
            sum /= 2;
            Set<Integer> set = new HashSet<>();
            set.add(0);
            set.add(nums[0]);
            for(int i=1;i<nums.length;i++){
                Set<Integer> temp = new HashSet<>();
                for(Integer x: set)
                    temp.add(x);
                for(Integer j: temp)
                    set.add(nums[i] + j);
            }
            if(set.contains(sum)) return true;
            return false;
        }
        return false;
    }
}