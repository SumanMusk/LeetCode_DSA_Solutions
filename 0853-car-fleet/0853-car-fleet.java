class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        Stack<Float> stk = new Stack<>();
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<position.length;i++)
            map.put(position[i], speed[i]);
        Arrays.sort(position);
        float arr[] = new float[position.length];
        int c=0;
        for(int i=position.length-1;i>=0;i--)
            arr[c++] = (float)(target - position[i]) / (float)map.get(position[i]);
        for(float i: arr){
            if(stk.isEmpty())
                stk.push(i);
            else{
                if(stk.lastElement() < i)
                    stk.push(i);
            }
        }
        return stk.size();
    }
}