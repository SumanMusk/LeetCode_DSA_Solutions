class Solution {
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
}