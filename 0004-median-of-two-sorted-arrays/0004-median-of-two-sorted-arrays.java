class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1.length < nums2.length) return findMedianSortedArrays(nums2, nums1);
        int half = (nums1.length + nums2.length + 1)/2;
        int l=0,r=nums2.length;
        double res=0;
        while(l<=r){
            int mid1 = l+((r-l)/2);
            int mid2 = half - mid1;
            int l1 = (mid1 > 0) ? nums2[mid1-1] : Integer.MIN_VALUE;
            int l2 = (mid2 > 0) ? nums1[mid2-1] : Integer.MIN_VALUE;
            int r1 = (mid1 <= nums2.length-1) ? nums2[mid1] : Integer.MAX_VALUE;
            int r2 = (mid2 <= nums1.length-1) ? nums1[mid2] : Integer.MAX_VALUE;
            if(l1 <= r2 && l2 <= r1){
                if((nums1.length+nums2.length)%2 == 0)
                    return (double)(Math.max(l1, l2)+Math.min(r1, r2))/2;
                else
                    return (double)Math.max(l1, l2);
            }
            else if(l1 > r2) r = mid1-1;
            else l = mid1+1;
        }
        return -1;
    }
}
/*class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int arr[] = new int[nums1.length + nums2.length];
        int i=0,j=0,c=0;
        while(i<nums1.length || j<nums2.length) {
            if(i < nums1.length && j < nums2.length) {
                if(nums1[i] < nums2[j]) 
                    arr[c++] = nums1[i++];
                else if(nums1[i] > nums2[j]) 
                    arr[c++] = nums2[j++];
                else {
                    arr[c++] = nums1[i++];
                    arr[c++] = nums2[j++];        
                }
            }
            else {
                while(i < nums1.length)
                    arr[c++] = nums1[i++];
                while(j < nums2.length)
                    arr[c++] = nums2[j++];
            }
        }        
        return (arr.length % 2 == 0) ? (double)(arr[(arr.length/2)-1] + arr[arr.length/2]) / 2 : (double)arr[arr.length/2];
    }
}*/