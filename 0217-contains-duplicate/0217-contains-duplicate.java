class Solution {
    public boolean containsDuplicate(int[] nums) {
        if(nums.length == 1)
            return false;
        else{
            Set<Integer> set = new HashSet<>();
            for(int i: nums)
                set.add(i);
            if(set.size() == nums.length)
                return false;
            else
                return true;
        }
    }
}