class Solution {
    public int largestRectangleArea(int[] heights) {
        int ans=Integer.MIN_VALUE;
        Stack<List<Integer>> stk = new Stack<>();
        for(int i=0;i<heights.length;i++) {
            int curr = i;
            while(!stk.isEmpty() && heights[i] < stk.peek().get(0)) {
                List<Integer> ls = stk.pop();
                ans = Math.max(ans, (ls.get(0) * (i - ls.get(1))));
                curr = ls.get(1);
            }
            stk.push(new ArrayList<>(Arrays.asList(heights[i], curr)));
        }
        while(!stk.isEmpty()) {
            List<Integer> ls = stk.pop();
            ans = Math.max(ans, (ls.get(0) * (heights.length - ls.get(1))));
        }
        return ans;
    }
}
// Using Previous lagre element and Next large element approach
/*class Solution {
    public int largestRectangleArea(int[] heights) {
        int ans=Integer.MIN_VALUE;
        for(int i=0;i<heights.length;i++){
            int l=i;
            int r=i;
            while(l>=0 && heights[l] >= heights[i])
                l--;
            while(r<=heights.length-1 && heights[r] >= heights[i])
                r++;
            ans = Math.max(ans, (heights[i] * ((r-l)-1)));
        }
        return ans;
    }
}*/