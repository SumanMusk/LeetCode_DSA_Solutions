class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> ls = new ArrayList<>();
        for(int i=0;i<numCourses;i++)
            ls.add(new ArrayList<>());
        for(int i=0;i<prerequisites.length;i++) {
            ls.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }
        int visited[] = new int[numCourses];
        for(int i=0;i<numCourses;i++) {
            if(visited[i] == 0) {
                if(isCyclic(ls, visited, i))
                    return false;
            }
        }
        return true;
    }
    public boolean isCyclic(List<List<Integer>> ls, int[] visited, int idx) {
        if(visited[idx] == 2) return true;
        visited[idx] = 2;
        for(int i=0;i<ls.get(idx).size();i++) {
            if(visited[ls.get(idx).get(i)] != 1) {
                if(isCyclic(ls, visited, ls.get(idx).get(i)))
                    return true;
            }
        }
        visited[idx] = 1;
        return false;
    }
}