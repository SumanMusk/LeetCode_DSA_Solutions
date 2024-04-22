import java.util.*;
class Solution {
    public boolean isAnagram(String s, String t) {
        char arr1[] = s.toCharArray();
        char arr2[] = t.toCharArray();
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        if(Arrays.equals(arr1, arr2))
            return true;
        else
            return false;
    }
}