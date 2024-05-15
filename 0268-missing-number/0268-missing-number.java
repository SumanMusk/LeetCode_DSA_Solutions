class Solution {
    public int missingNumber(int[] nums) {
        int allXOR=0, numsXOR=0;
        for(int i=0;i<=nums.length;i++) {
            if(i < nums.length) 
                numsXOR = numsXOR ^ nums[i];
            allXOR = allXOR ^ i;
        }
        return allXOR ^ numsXOR;
    }
}
/*
class Solution {
    public int missingNumber(int[] nums) {
        Arrays.sort(nums);
        int i = 0;
        while(i<nums.length){
            if(i != nums[i]) break;
            i++;
        }
        return i;
    }
}
*/