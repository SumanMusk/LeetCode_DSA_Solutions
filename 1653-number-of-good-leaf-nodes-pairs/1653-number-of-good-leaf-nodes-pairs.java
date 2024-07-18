class Solution {
    int count=0;
    public int countPairs(TreeNode root, int distance) {
        dfs(root, distance);
        return count;
    }
    public List<Integer> dfs(TreeNode root, int distance) {
        if(root.left == null && root.right == null) 
            return new ArrayList<>(Arrays.asList(1));
        List<Integer> leftList = (root.left == null) ? new ArrayList<>() : dfs(root.left, distance);
        List<Integer> rightList = (root.right == null) ? new ArrayList<>() : dfs(root.right, distance);
        for(int i: leftList)
            for(int j: rightList)
                if(i+j <= distance)
                    count++;
        return increment(leftList, rightList);
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