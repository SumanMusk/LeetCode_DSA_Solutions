class Solution {
    public boolean threeConsecutiveOdds(int[] arr) {
        int f=0;
        List<Integer> ls = new ArrayList<>();
        for(int i=0;i<arr.length;i++) {
            if(arr[i]%2 != 0 && i+2 < arr.length) 
                if(arr[i+1]%2 != 0 && arr[i+2]%2 != 0)
                    return true;
        }
        return false;
    }
}