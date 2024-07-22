class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> adjLs = new HashMap<>();
        for(int i=0;i<numCourses;i++) 
            adjLs.put(i, new ArrayList<>());
        for(int i=0;i<prerequisites.length;i++) 
            adjLs.get(prerequisites[i][0]).add(prerequisites[i][1]);
        // Generally we use a Stack for Topological Sorting, but for this case(for the answer array order) we're using a Queue 
        Queue<Integer> topoQue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        for(int i=0;i<numCourses;i++) 
            if(!visited.contains(i))
                if(!isCyclic(i, adjLs, visited))
                    return new int[]{};
        visited.clear();
        for(int i=0;i<numCourses;i++) 
            if(!visited.contains(i))
                helperDFS(i, adjLs, visited, topoQue);
        int res[] = new int[topoQue.size()];
        int c=0;
        while(!topoQue.isEmpty())
            res[c++] = topoQue.poll();
        return res;
    }
    public boolean isCyclic(int curr, Map<Integer, List<Integer>> adjLs, Set<Integer> visited) {
        if(visited.contains(curr))
            return false;
        visited.add(curr);
        for(int i=0;i<adjLs.get(curr).size();i++)
            if(!isCyclic(adjLs.get(curr).get(i), adjLs, visited))
                return false;
        visited.remove(curr);
        return true;
    }
    public void helperDFS(int curr, Map<Integer, List<Integer>> adjLs, Set<Integer> visited, Queue<Integer> topoQue) {
        if(visited.contains(curr))
            return;
        visited.add(curr);
        for(int i=0;i<adjLs.get(curr).size();i++)
            helperDFS(adjLs.get(curr).get(i), adjLs, visited, topoQue);
        topoQue.offer(curr);
    }
}
/*
// InEfficient Solution
class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> adjLs = new HashMap<>();
        int indegree[] = new int[numCourses];
        for(int i=0;i<numCourses;i++)
            adjLs.put(i, new ArrayList<>());
        for(int i=0;i<prerequisites.length;i++) {
            int pre = prerequisites[i][0];
            int post = prerequisites[i][1];
            List<Integer> ls = adjLs.get(pre);
            ls.add(post);
            adjLs.put(pre, ls);
            indegree[post]++;
        }
        Queue<Integer> topoQue = new LinkedList<>();
        List<Integer> ls = new ArrayList<>();
        int c=0;
        for(int i=0;i<indegree.length;i++) 
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
        Collections.reverse(ls);
        int res[] = ls.stream().mapToInt(i -> i).toArray();
        if(ls.size() == numCourses)
            return res;
        return new int[0];
    }
}
/*
// Merged the helperDFS and isCyclic method into only one dfs method, but for the contains method for inserting elements in topoQue, we're getting time limit exceeded error
class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> adjLs = new HashMap<>();
        for(int i=0;i<numCourses;i++) 
            adjLs.put(i, new ArrayList<>());
        for(int i=0;i<prerequisites.length;i++) 
            adjLs.get(prerequisites[i][0]).add(prerequisites[i][1]);
        // Generally we use a Stack for Topological Sorting, but for this case(for the answer array order) we're using a Queue 
        Queue<Integer> topoQue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        for(int i=0;i<numCourses;i++) 
            if(!visited.contains(i))
                if(helperDFS(i, adjLs, visited, topoQue))
                    return new int[]{};
        int res[] = new int[topoQue.size()];
        int c=0;
        while(!topoQue.isEmpty())
            res[c++] = topoQue.poll();
        return res;
    }
    public boolean helperDFS(int curr, Map<Integer, List<Integer>> adjLs, Set<Integer> visited, Queue<Integer> topoQue) {
        if(visited.contains(curr))
            return true;
        visited.add(curr);
        for(int i=0;i<adjLs.get(curr).size();i++)
            if(helperDFS(adjLs.get(curr).get(i), adjLs, visited, topoQue))
                return true;
        visited.remove(curr);
        if(!topoQue.contains(curr))
            topoQue.offer(curr);
        return false;
    }
}


    
*/