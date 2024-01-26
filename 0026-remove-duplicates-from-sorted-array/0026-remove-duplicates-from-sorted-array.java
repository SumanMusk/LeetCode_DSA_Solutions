class Solution {
    public int removeDuplicates(int[] nums) {
        List<Integer> set = new ArrayList<>();
        for(int i: nums){
            if(!set.contains(i))
                set.add(i);
        }
        if(set.size() == nums.length)
            return nums.length;
        else{
            int x=0;
            for(Integer i: set)            
                nums[x++] = i;
            return set.size();
        }
    }
}