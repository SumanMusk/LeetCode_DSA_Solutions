class Solution {
    public int minSwaps(int[] nums) {
        int no_1s=0;
        for(int i: nums)
            if(i == 1)
                no_1s++;
        if(no_1s == 0)
            return 0;
        int[] mirrorArr = new int[nums.length*2];
        int i=0, j=0, r=no_1s-1, res=Integer.MAX_VALUE;
        Map<Integer, Integer> map = new HashMap<>();
        for(i=0;i<nums.length;i++) {
            mirrorArr[i] = nums[i];
            if(i < no_1s-1) 
                map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
        }
        while(i < nums.length*2) 
            mirrorArr[i++] = nums[j++];
        i=0;
        while(r < mirrorArr.length) {
            map.put(mirrorArr[r], map.getOrDefault(mirrorArr[r], 0)+1);
            r++;
            res = Math.min(res, map.getOrDefault(0, 0));
            map.put(mirrorArr[i], map.get(mirrorArr[i])-1);
            i++;
        }
        return res;
    }
}