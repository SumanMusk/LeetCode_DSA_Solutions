class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        List<String> ls = new ArrayList<>();
        int ans=0;
        ls.add("+");
        ls.add("-");
        ls.add("*");
        ls.add("/");
        for(String str: tokens){
            if(!ls.contains(str)){
                stack.push(Integer.parseInt(str));
                ans = stack.peek();
            }
            else{
                stack.pop();
                int x = stack.pop();
                switch(str){
                    case "+":
                        ans = x + ans;
                        break;
                    case "-":
                        ans = x - ans;
                        break;
                    case "*":
                        ans = x * ans;
                        break;
                    case "/":
                        ans = x / ans;
                        break;
                }
                stack.push(ans);
            }
        }
        return ans;
    }
}