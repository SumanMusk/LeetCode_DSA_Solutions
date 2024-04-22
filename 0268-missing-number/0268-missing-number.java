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
/*
class Solution {
    public int missingNumber(int[] nums) {
        Arrays.sort(nums);
        int chk = 0;
        for(int i=0;i<nums.length;i++){
            if(chk != nums[i]) break;
            else chk++;
        }
        return chk;
    }
}
*/