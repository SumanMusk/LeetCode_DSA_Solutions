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
        leftList.addAll(rightList);
        for(int i=0;i<leftList.size();i++)
            leftList.set(i, leftList.get(i)+1);
        return leftList;
    }
}