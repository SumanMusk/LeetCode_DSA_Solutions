class Solution {
    public int[] sortJumbled(int[] mapping, int[] nums) {
        Map<Integer, Integer[]> map = new HashMap<>();
        for(int i=0;i<nums.length;i++) {
            int num = nums[i];
            StringBuilder str = new StringBuilder();
            if(num != 0) {
                while(num != 0) {
                    str.append(mapping[num%10]);
                    num /= 10;
                }
            }
            else
                str.append(mapping[num]);
            map.put(nums[i], new Integer[]{Integer.parseInt(str.reverse().toString()), i});
        }
        Integer arr[] = new Integer[nums.length];
        for(int i=0;i<nums.length;i++) 
            arr[i] = Integer.valueOf(nums[i]);
        Arrays.sort(arr, (a,b) -> {
            if(map.get(a)[0] == map.get(b)[0]) {
                return map.get(a)[1] - map.get(b)[1];
            }
            return map.get(a)[0] - map.get(b)[0];
        });
        for(int i=0;i<nums.length;i++) 
            nums[i] = arr[i];
        return nums;
    }
}