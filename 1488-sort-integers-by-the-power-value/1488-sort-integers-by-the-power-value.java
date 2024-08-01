class Solution {
    public int getKth(int lo, int hi, int k) {
        Map<Integer, Integer> dp = new HashMap<>();
        dp.put(1, 0);
        int arrCount=0;
        Integer arr[] = new Integer[hi-lo+1];
        for(int i=lo;i<=hi;i++) {
            int val = i;
            int c=0;
            arr[arrCount++] = val;
            Queue<Integer> que = new LinkedList<>();
            while(val != 1) {
                que.add(val);
                if(dp.containsKey(val)) {
                    c += dp.get(val);
                    break;
                }
                if(val % 2 == 0)
                    val /= 2;
                else
                    val = (val*3)+1;
                c++;
            }
            while(c > 0) {
                int curr = que.poll();
                if(dp.containsKey(curr))
                    break;
                dp.put(curr, c);
                c--;
            }
        }
        Arrays.sort(arr, (a,b) -> dp.get(a)-dp.get(b));
        return arr[k-1];
    }
}