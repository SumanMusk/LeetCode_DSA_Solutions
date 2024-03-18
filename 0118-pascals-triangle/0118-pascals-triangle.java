class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ls = new ArrayList<>();
        int count=1;
        for(int i=0;i<numRows;i++) {
            List<Integer> temp = new ArrayList<>();
            for(int j=0;j<count;j++) {
                if(j == 0 || j == count-1) temp.add(1);
                else temp.add(ls.get(i-1).get(j-1) + ls.get(i-1).get(j));
            }
            count++;
            ls.add(temp);
        }
        return ls;
    }
}