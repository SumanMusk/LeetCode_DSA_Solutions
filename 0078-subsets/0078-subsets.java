class Solution {
    public void allSubset(int[] nums, List<List<Integer>> ls, List<Integer> temp, int i) {
        ls.add(new ArrayList<>(temp));
        for(int x=i;x<nums.length;x++){
            temp.add(nums[x]);
            allSubset(nums, ls, temp, x+1);
            temp.remove(temp.size()-1);
        }
    }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ls = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        Solution obj = new Solution();
        obj.allSubset(nums, ls, temp, 0);
        return ls;
    }
}