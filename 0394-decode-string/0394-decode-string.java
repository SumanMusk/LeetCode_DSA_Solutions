class Solution {
    public String decodeString(String s) {
        Stack<Integer> digits = new Stack<>();
        Stack<String> strs = new Stack<>();
        int i=0, num=0;
        while(i < s.length()) {
            if(Character.isDigit(s.charAt(i))) 
                num = (num*10) + Character.getNumericValue(s.charAt(i));
            else if(s.charAt(i) != ']') {
                if(!Character.isAlphabetic(s.charAt(i))) {
                    digits.push(num);
                    num=0;
                }
                strs.push(String.valueOf(s.charAt(i)));
            }
            else if(s.charAt(i) == ']') {
                String temp = "";
                while(!strs.peek().equals("["))
                    temp = strs.pop() + temp;
                int itrNo = digits.pop();
                String main="";
                for(int j=0;j<itrNo;j++) 
                    main += temp;
                strs.pop();
                strs.push(main);
            }
            i++;
        }
        String ans="";
        while(!strs.isEmpty()) 
            ans = strs.pop() + ans;
        return ans;
    }
}