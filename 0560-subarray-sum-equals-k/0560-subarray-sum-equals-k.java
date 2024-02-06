class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> prefixSum = new HashMap<>();
        prefixSum.put(0, 1);
        int sum=0,count=0;
        for(int i=0;i<nums.length;i++){
            sum += nums[i];
            int temp = sum - k;
            if(prefixSum.containsKey(temp)){
                int x = prefixSum.get(temp);
                count+=x;
            }
            if(prefixSum.containsKey(sum)){
                int x = prefixSum.get(sum);
                x++;
                prefixSum.put(sum, x);
            }
            else 
                prefixSum.put(sum, 1);
        }
        return count;
    }
}