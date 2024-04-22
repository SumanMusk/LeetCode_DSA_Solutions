class Solution {
    public boolean isValid(String s) {
        Stack<Character> stk = new Stack<>();
        for(int i=0;i<s.length();i++) {
            if(s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[') {
                if(s.charAt(i) == '(')
                    stk.push(')');
                else if(s.charAt(i) == '{')
                    stk.push('}');
                else if(s.charAt(i) == '[')
                    stk.push(']');
            }
            else if(stk.isEmpty() || stk.peek() != s.charAt(i)) 
                return false;
            else stk.pop();
        }
        return stk.isEmpty();
    }
}
/*class Solution {
    public boolean isValid(String s) {
        char arr[] = new char[s.length()];
        int f=0,p=-1;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[')
                arr[++p] = s.charAt(i);
            else{
                if(s.charAt(i) == ')'){
                    if(p == -1) arr[++p] = s.charAt(i);
                    else if(arr[p] == '(') p--;
                    else arr[++p] = s.charAt(i);
                }
                else if(s.charAt(i) == '}'){
                    if(p == -1) arr[++p] = s.charAt(i);
                    else if(arr[p] == '{') p--;
                    else arr[++p] = s.charAt(i);
                }
                else if(s.charAt(i) == ']'){
                    if(p == -1) arr[++p] = s.charAt(i);
                    else if(arr[p] == '[') p--;
                    else arr[++p] = s.charAt(i);
                }
            }
        }
        if(p == -1)
            return true;
        else
            return false;        
    }
}*/