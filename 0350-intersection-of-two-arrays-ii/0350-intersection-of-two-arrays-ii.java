class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        if(nums1.length < nums2.length)
            return intersect(nums2, nums1);
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i=0,j=0,k=0;
        while(i<nums1.length && j<nums2.length) {            
            if(nums1[i] == nums2[j]) {
                nums1[k++] = nums2[j++];
                i++;
            }
            else if(nums1[i] > nums2[j])
                j++;
            else i++;
        }
        return Arrays.copyOfRange(nums1, 0, k);
    }
}
/*
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
*/