class Solution {
    public int[] frequencySort(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i: nums)
            map.put(i, map.getOrDefault(i, 0)+1);
        Integer arr[] = new Integer[map.size()];
        int c=0;
        for(Integer i: map.keySet())
            arr[c++] = i;
        Arrays.sort(arr, new Comparator<Integer>(){
            public int compare(Integer a, Integer b) {
                if(map.get(a) == map.get(b)) 
                    return b-a;
                return map.get(a) - map.get(b);
            }
        });
        /*
        // Can be done like that as well
        Arrays.sort(arr, (a,b) -> {
            if(map.get(a) == map.get(b))
                return b-a;
            return map.get(a) - map.get(b);
        });
        */
        c=0;
        for(int i: arr) {
            for(int j=0;j<map.get(i);j++)
                nums[c++] = i;
        }
        return nums;
    }
}