class Solution {
    public int numIdenticalPairs(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for(int i: nums) 
            map.put(i, map.getOrDefault(i, 0)+1);
            
        for(int i: nums) {
            count += map.get(i)-1;
            map.put(i, map.get(i)-1);
        }
        return count;
    }
}