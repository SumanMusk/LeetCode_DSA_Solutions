class Solution {
    public int trap(int[] height) {
        int left[] = new int[height.length];
        int right[] = new int[height.length];
        int ans[] = new int[height.length];
        int l=0,r=0;
        for(int i=0,j=height.length-1;i<height.length && j>=0;i++,j--){
            left[i] = Math.max(height[i], l);
            if(l<=height[i])
                l = height[i];
            right[j] = Math.max(height[j], r);
            if(r<=height[j])
                r = height[j];
        }
        for(int i=0;i<height.length;i++)
            ans[i] = Math.min(left[i], right[i]) - height[i];
        int s=0;
        for(int i: ans){
            if(i != 0)
                s+=i;
        }
        return s;
    }
}