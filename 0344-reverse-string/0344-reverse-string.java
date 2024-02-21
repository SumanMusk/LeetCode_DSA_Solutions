class Solution {
    public void reverseString(char[] s) {
        int start=0, end=s.length-1;
        while(start < end){
            char x = s[start];
            s[start] = s[end];
            s[end] = x;
            start++;
            end--;
        }
        System.out.println(Arrays.toString(s));
    }
}