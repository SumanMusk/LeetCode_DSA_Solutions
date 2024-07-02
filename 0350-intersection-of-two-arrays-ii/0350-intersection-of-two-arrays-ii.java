class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        if(nums1.length < nums2.length)
            return intersect(nums2, nums1);
        List<Integer> idxs = new ArrayList<>();
        List<Integer> ls = new ArrayList<>();
        for(int i: nums2) {
            for(int j=0;j<nums1.length;j++)
                if(i == nums1[j] && !idxs.contains(j)) {
                    ls.add(i);
                    idxs.add(j);
                    break;
                }
        }
        return ls.stream().mapToInt(i -> i).toArray();
    }
}