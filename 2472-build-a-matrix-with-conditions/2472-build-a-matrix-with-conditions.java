class Solution {
    public int[][] buildMatrix(int k, int[][] rowConditions, int[][] colConditions) {        
        List<Integer> sortedRow = func(rowConditions, k);
        List<Integer> sortedCol = func(colConditions, k);
        if(sortedRow.size() == 0 || sortedCol.size() == 0)       
            return new int[0][0];

        Map<Integer, int[]> map = new HashMap<>();
        int[][] mat = new int[k][k];
        for(int x=1;x<=k;x++) 
            map.put(x, new int[2]);
        for(int x=0;x<sortedRow.size();x++) 
            map.get(sortedRow.get(x))[0] = x;
        for(int x=0;x<sortedCol.size();x++) 
            map.get(sortedCol.get(x))[1] = x;
        for(int x=1;x<=k;x++) 
            mat[map.get(x)[0]][map.get(x)[1]] = x;
        return mat;
    }
    public List<Integer> func(int[][] condi, int k) {
        Map<Integer, List<Integer>> adjLs = new HashMap<>();
        int indegree[] = new int[k+1];
        for(int i=1;i<=k;i++)
            adjLs.put(i, new ArrayList<>());
        for(int i=0;i<condi.length;i++) {
            int pre = condi[i][0];
            int post = condi[i][1];
            List<Integer> ls = adjLs.get(pre);
            ls.add(post);
            adjLs.put(pre, ls);
            indegree[post]++;
        }
        Queue<Integer> topoQue = new LinkedList<>();
        List<Integer> ls = new ArrayList<>();
        for(int i=1;i<indegree.length;i++) 
            if(indegree[i] == 0)
                topoQue.add(i);
        while(!topoQue.isEmpty()) {
            int node = topoQue.poll();
            ls.add(node);
            for(Integer i: adjLs.get(node)) {
                indegree[i]--;
                if(indegree[i] == 0)
                    topoQue.add(i);
            }
        }  
        if(ls.size() == k)
            return ls;
        return new ArrayList<>();
    }
}