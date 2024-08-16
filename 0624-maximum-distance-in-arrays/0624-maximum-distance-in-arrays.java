class Solution {
    public int maxDistance(List<List<Integer>> arrays) {
        int minVal = arrays.get(0).get(0);
        int maxVal = arrays.get(0).get(arrays.get(0).size()-1);
        int res=0;
        for(int i=1;i<arrays.size();i++) {
            int curr_min = arrays.get(i).get(0);
            int curr_max = arrays.get(i).get(arrays.get(i).size()-1);
            int first_substract_val = Math.abs(maxVal - curr_min);
            int second_substract_val = Math.abs(curr_max - minVal);
            res = Math.max(res, Math.max(first_substract_val, second_substract_val));
            minVal = Math.min(minVal, curr_min);
            maxVal = Math.max(maxVal, curr_max);
        }
        return res;
    }
}