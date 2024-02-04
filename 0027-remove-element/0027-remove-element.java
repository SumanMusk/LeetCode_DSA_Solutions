class Solution {
    public int removeElement(int[] nums, int val) {
        List<Integer> ls = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        for(int i: nums)
            ls.add(i);
        temp.add(val);
        ls.removeAll(temp);
        int ans = ls.size();
        for(int i=0;i<nums.length;i++){
            if(!ls.isEmpty()){
                nums[i] = ls.getFirst();
                ls.removeFirst();
            }
        }
        return ans;
    }
}