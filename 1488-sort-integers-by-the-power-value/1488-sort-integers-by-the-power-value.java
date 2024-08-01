class Solution {
    public int getKth(int lo, int hi, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(1, 0);
        int arrCount=0;
        Integer arr[] = new Integer[(hi-lo)+1];
        for(int i=lo;i<=hi;i++) {
            int val = i;
            int c=0;
            arr[arrCount++] = val;
            Queue<Integer> que = new LinkedList<>();
            while(val != 1) {
                que.add(val);
                if(map.containsKey(val)) {
                    c += map.get(val);
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
                if(map.containsKey(curr))
                    break;
                map.put(curr, c);
                c--;
            }
        }
        Arrays.sort(arr, (a,b) -> map.get(a)-map.get(b));
        return arr[k-1];
    }
}