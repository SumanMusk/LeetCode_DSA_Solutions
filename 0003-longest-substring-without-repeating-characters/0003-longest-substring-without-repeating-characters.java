import java.util.*;
class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() == 0)
            return 0;
        else{
            int ans=Integer.MIN_VALUE;
            Queue<Character> que = new LinkedList<>();
            for(int i=0;i<s.length();i++){
                if(que.contains(s.charAt(i))){
                    while(!que.isEmpty() && que.contains(s.charAt(i)))
                        que.remove();
                }
                que.add(s.charAt(i));
                if(ans < que.size())
                    ans = que.size();
            }       
            return ans;
        }
    }
}