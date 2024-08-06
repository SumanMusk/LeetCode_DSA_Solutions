class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>(wordList);
        if(!wordList.contains(endWord))
            return 0;
        Queue<String> que = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        int level=1;
        que.add(beginWord);        
        while(!que.isEmpty()) {
            int len = que.size();
            for(int x=0;x<len;x++) {
                String curr = que.poll();
                if(visited.contains(curr))
                    continue;
                visited.add(curr);
                if(curr.equals(endWord))
                    return level;
                for(int i=0;i<curr.length();i++) {
                    for(int j='a';j<='z';j++) {
                        char arr[] = curr.toCharArray();
                        arr[i] = (char)j;
                        String strArr = String.valueOf(arr);
                        if(set.contains(strArr)) 
                            que.add(strArr);
                    }
                }
            }
            level++;
        }
        return 0;
    }
}