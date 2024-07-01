class Solution {
    public boolean threeConsecutiveOdds(int[] arr) {
        int c=0;
        for(int i=0;i<arr.length;i++) {
            if(arr[i]%2 != 0) {
                c++;
                if(c == 3)
                    return true;
            }
            else c=0;
        }
        return false;
    }
}
/*class Solution {
    public boolean threeConsecutiveOdds(int[] arr) {
        for(int i=0;i<arr.length;i++) {
            if(arr[i]%2 != 0 && i+2 < arr.length) 
                if(arr[i+1]%2 != 0 && arr[i+2]%2 != 0)
                    return true;
        }
        return false;
    }
}*/