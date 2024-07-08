class Solution {
    public int findTheWinner(int n, int k) {
        /*int arr[] = new int[n];
        for(int i=1;i<=n;i++) 
            arr[i-1] = i;
        int idx=0, c=0;
        if(arr.length == 1)
            return 1;
        while(c < n) {
            for(int i=0;i<k;i++) {
                idx++;
                while(idx < arr.length && arr[idx] == Integer.MAX_VALUE)
                    idx++;
                if(idx == arr.length)
                    idx=0;
            }
            arr[idx]=Integer.MAX_VALUE;
            c++;
        }
        return arr[0];*/
        List<Integer> arr = new ArrayList<>(){{for(int i=1;i<=n;i++) add(i);}};
        int idx=0;
        while(arr.size() > 1) {
            for(int i=1;i<=k-1;i++) {
                idx++;
                if(arr.size() == idx)
                    idx=0;
            }
            arr.remove(idx);
            if(arr.size() == idx)
                idx=0;
        }
        return arr.get(0);
    }
}