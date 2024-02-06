class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans;
        Set<List<Integer>> s= new HashSet<>();
        Arrays.sort(nums);
        for(int i=0;i<nums.length-2;i++){
            int l = i+1;
            int r = nums.length-1;
            while(l < r){
                int x = nums[i] + nums[l] + nums[r];
                if(x == 0){          
                    List<Integer> temp= new ArrayList();
                    temp.add(nums[i]);
                    temp.add(nums[l]);
                    temp.add(nums[r]);          
                    s.add(temp);
                    l++;
                }
                else if(x < 0)
                    l++;
                else if(x > 0)
                    r--;
            }
        }
        ans= new ArrayList<>(s);
        return ans;
    }
}