class Solution {
    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        Map<Integer, String> map = new HashMap<>();
        for(int i=0;i<positions.length;i++)
            map.put(positions[i], Integer.toString(i) + Character.toString(directions.charAt(i)));
        Arrays.sort(positions);
        Stack<String> stk = new Stack<>();
        for(int i=0;i<positions.length;i++) {
            if(!stk.isEmpty()) {
                char currDir = map.get(positions[i]).charAt(map.get(positions[i]).length()-1);
                char prevDir = stk.peek().charAt(stk.peek().length()-1);
                int currHealth = Integer.parseInt(map.get(positions[i]).substring(0, map.get(positions[i]).length()-1));
                int prevHealth = Integer.parseInt(stk.peek().substring(0, stk.peek().length()-1));
                if(currDir == 'L' && prevDir == 'R') {
                    while(!stk.isEmpty() && healths[currHealth] != 0) {
                        if(healths[currHealth] == healths[prevHealth] && currDir == 'L' && prevDir == 'R') {
                            healths[prevHealth] = 0;
                            healths[currHealth] = 0;
                            stk.pop();
                        }
                        else if(healths[currHealth] > healths[prevHealth] && currDir == 'L' && prevDir == 'R') {
                            healths[prevHealth] = 0;
                            stk.pop();
                            healths[currHealth]--;
                            if(stk.isEmpty())
                                break;
                            prevDir = stk.peek().charAt(stk.peek().length()-1);
                            prevHealth = Integer.parseInt(stk.peek().substring(0, stk.peek().length()-1));                            
                        }
                        else if(healths[currHealth] < healths[prevHealth] && currDir == 'L' && prevDir == 'R'){
                            healths[prevHealth]--;
                            healths[currHealth] = 0;
                        }
                        else break;
                    }
                }
                else stk.push(map.get(positions[i]));
            }
            else stk.push(map.get(positions[i]));
        }
        List<Integer> ls = new ArrayList<>();
        for(int i: healths)
            if(i > 0)
                ls.add(i);
        return ls;
    }
}