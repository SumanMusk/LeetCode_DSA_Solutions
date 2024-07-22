class Solution {
    public String[] sortPeople(String[] names, int[] heights) {
        Map<Integer, String> map = new HashMap<>();
        for(int i=0;i<heights.length;i++)
            map.put(heights[i], names[i]);
        Arrays.sort(heights);
        int c=0;
        for(int i=heights.length-1;i>=0;i--) 
            names[c++] = map.get(heights[i]);
        return names;
    }
}