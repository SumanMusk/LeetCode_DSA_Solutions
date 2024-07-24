class Solution {
    public int[] sortJumbled(int[] mapping, int[] nums) {
        Map<Integer, Integer[]> map = new HashMap<>();
        for(int i=0;i<nums.length;i++) {
            int num = nums[i];
            Stack<Integer> stk = new Stack<>();
            if(num != 0) {
                while(num != 0) {
                    stk.push(mapping[num%10]);
                    num /= 10;
                }
            }
            else
                stk.push(mapping[num]);
            int res=0;
            while(!stk.isEmpty()) 
                res = res*10 + stk.pop();            
            map.put(nums[i], new Integer[]{res, i});
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