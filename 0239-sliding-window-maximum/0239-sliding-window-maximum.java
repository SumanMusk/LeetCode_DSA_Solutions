class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int l=0,r=k-1,c=0,f=0;
        int ans[] = new int[nums.length-k+1];
        Deque<Integer> que = new LinkedList<>();
        while(r < nums.length) {
            // for the first window, checking the full window with a loop
            if(f == 0) {
                for(int x=l;x<=r;x++) {
                    while(!que.isEmpty() && que.peekLast() < nums[x])
                        que.removeLast();
                    que.add(nums[x]);
                }
                f=1;
            }
            // for the rest of the windows, just because the window is sliding with only one value, so checking only the rightmost value of the current window
            else {
                while(!que.isEmpty() && que.peekLast() < nums[r])
                    que.removeLast();
                que.add(nums[r]);
            }
            // If the max value is in the leftmost position of the current window, then we dont need that value into the Deque, but if the value is not in the leftmost position of the current window, that means for the next window, the previous max value could be the next max value for the curret window.
            if(nums[l] == que.peekFirst()) 
                ans[c++] = que.pollFirst();
            else
                ans[c++] = que.peekFirst();
            l++;
            r++;
        }
        return ans;
    }
}