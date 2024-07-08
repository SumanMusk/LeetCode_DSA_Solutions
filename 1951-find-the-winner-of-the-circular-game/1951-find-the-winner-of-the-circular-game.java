class Solution {
    public int findTheWinner(int n, int k) {
        Queue<Integer> que = new LinkedList<>();
        for(int i=1;i<=n;i++)
            que.add(i);
        while(que.size() > 1) {
            for(int i=1;i<=k-1;i++) {
                int temp = que.poll();
                que.add(temp);
            }
            que.poll();
        }
        return que.poll();
    }
}
// Brute Force
/*class Solution {
    public int findTheWinner(int n, int k) {
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
}*/