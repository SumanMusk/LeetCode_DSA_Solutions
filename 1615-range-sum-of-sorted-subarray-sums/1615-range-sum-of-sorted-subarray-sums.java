class Solution {
    public int rangeSum(int[] nums, int n, int left, int right) {
        List<Integer> ls = new ArrayList<>();
        for(int i=0;i<nums.length;i++) {
            int sum=0;
            for(int j=i;j<nums.length;j++) {
                sum += nums[j];
                ls.add(sum);
            }
        }
        Collections.sort(ls);
        int sum=0, mod=1000000007;
        for(int i=left-1;i<right;i++) 
            sum = (sum + ls.get(i)) % mod;
        return sum;
    }
}