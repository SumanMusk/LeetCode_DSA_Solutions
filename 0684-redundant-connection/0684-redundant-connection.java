class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int parent[] = new int[edges.length+1];
        int rank[] = new int[edges.length+1];
        int res[] = new int[2];
        Arrays.fill(rank, 1);
        for(int i=1;i<parent.length;i++)
            parent[i] = i;
        for(int arr[]: edges) {
            int prOne = find(arr[0], parent);
            int prTwo = find(arr[1], parent);
            if(prOne == prTwo)
                res = Arrays.copyOf(arr, 2);
            else if(prOne > prTwo)
                parent[prTwo] = prOne;
            else
                parent[prOne] = prTwo;
        }
        return res;
    }
    public int find(int curr, int parent[]) {
        if(parent[curr] == curr)
            return curr;
        return find(parent[curr], parent);
    }
}