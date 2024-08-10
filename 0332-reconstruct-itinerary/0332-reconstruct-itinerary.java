class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, PriorityQueue<String>> adjLs = new HashMap<>();
        for(List<String> ls: tickets) 
            adjLs.computeIfAbsent(ls.get(0), k -> new PriorityQueue<>()).add(ls.get(1));
        List<String> res = new ArrayList<>();
        helperDFS(adjLs, res, "JFK");
        return res;
    }
    public void helperDFS(Map<String, PriorityQueue<String>> adjLs, List<String> res, String s) {
        PriorityQueue<String> minHeap = adjLs.get(s);
        while(minHeap != null && !minHeap.isEmpty()) 
            helperDFS(adjLs, res, minHeap.poll());
        res.addFirst(s);
    }
}