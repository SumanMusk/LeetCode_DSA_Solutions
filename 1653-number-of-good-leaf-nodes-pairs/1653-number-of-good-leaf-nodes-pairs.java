class Solution {
    int count=0;
    public int countPairs(TreeNode root, int distance) {
        dfs(root, distance);
        return count;
    }
    public List<Integer> dfs(TreeNode root, int distance) {
        if(root.left == null && root.right == null) 
            return new ArrayList<>(Arrays.asList(1));
        List<Integer> leftList;
        List<Integer> rightList;
        leftList = (root.left == null) ? new ArrayList<>() : dfs(root.left, distance);
        rightList = (root.right == null) ? new ArrayList<>() : dfs(root.right, distance);
        if(leftList.size() <= rightList.size())
            chkDist(leftList, rightList, distance);
        if(leftList.size() > rightList.size())
            chkDist(rightList, leftList, distance);
        return increment(leftList, rightList);
    }
    public void chkDist(List<Integer> small, List<Integer> big, int dist) {
        if(small.size() == 0 || big.size() == 0)
            return;
        for(int i: small)
            for(int j: big)
                if(i+j <= dist)
                    count++;
    }
    public List<Integer> increment(List<Integer> ls) {
        for(int i=0;i<ls.size();i++)
            ls.set(i, ls.get(i)+1);
        return ls;
    }
    public List<Integer> increment(List<Integer> one, List<Integer> two) {
        List<Integer> res = new ArrayList<>();
        for(int i: one)
            res.add(i+1);
        for(int i: two)
            res.add(i+1);
        return res;
    }
}