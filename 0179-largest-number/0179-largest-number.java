class Solution {
    public String largestNumber(int[] nums) {
        if(nums.length == 1) return String.valueOf(nums[0]);
        int f=0;
        for(int i: nums) 
            if(i != 0)
                f=1;
        if(f == 0)
            return "0";
        for(int i=0;i<nums.length-1;i++) {
            for(int j=(i+1);j<nums.length;j++) {
                String one = String.valueOf(nums[i]);
                String two = String.valueOf(nums[j]);
                String asc = one + two;
                String dsc = two + one;
                if(dsc.compareTo(asc) > 0) {
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }
        }
        String s = "";
        for(int i: nums)
            s += String.valueOf(i);
        return s;
    }
}