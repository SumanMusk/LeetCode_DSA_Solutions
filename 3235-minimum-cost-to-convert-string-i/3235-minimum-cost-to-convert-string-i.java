class Solution {
    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        Map<Character, List<Pair<Character, Long>>> adjLs = new HashMap<>();
        for(int i=0;i<original.length;i++) 
            adjLs.computeIfAbsent(original[i], k -> new ArrayList<>()).add(new Pair<>(changed[i], (long)cost[i]));
        long res = 0;
        Map<Character, Map<Character, Long>> map = new HashMap<>();
        Set<Character> set = new HashSet<>();
        for(int i=0;i<source.length();i++) {
            if(!set.contains(source.charAt(i))) {
                map.put(source.charAt(i), dijkstra(source.charAt(i), target.charAt(i), adjLs));
                set.add(source.charAt(i));
            }
        }
        for(int i=0;i<source.length();i++) {
            char src = source.charAt(i);
            char dst = target.charAt(i);
            if(!map.get(src).containsKey(dst)) 
                return -1;
            res += map.get(src).get(dst);
        }
        return res;
    }
    public Map<Character, Long> dijkstra(char src, char des, Map<Character, List<Pair<Character, Long>>> adjLs) {
        Map<Character, Long> visited = new HashMap<>();
        Queue<Pair<Character, Long>> minHeap = new PriorityQueue<>((a,b) -> Long.compare(a.getValue(), b.getValue()));
        minHeap.add(new Pair<>(src, (long)0));
        while(!minHeap.isEmpty()) {
            char node = minHeap.peek().getKey();
            long node_dist = minHeap.peek().getValue();
            minHeap.poll();
            if(visited.containsKey(node))
                continue;
            visited.put(node, node_dist);
            if(adjLs.containsKey(node)) {
                for(Pair<Character, Long> pair: adjLs.get(node)) {
                    char curr = pair.getKey();
                    long curr_dist = pair.getValue();
                    long total = node_dist + curr_dist;
                    minHeap.add(new Pair<>(curr, total));
                }
            }
        }
        return visited;
    }
}