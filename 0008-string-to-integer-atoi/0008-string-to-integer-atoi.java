class Solution {
    public int myAtoi(String s) {
        s = s.trim();
        if(s.length() == 0)
            return 0;
        else if(s.length() == 1) {
            return !Character.isDigit(s.charAt(0)) ? 0 : Integer.parseInt(String.valueOf(s.charAt(0)));
        }
        else {
            boolean sign = (s.charAt(0) == '-') ? false : true;
            if(sign && s.charAt(0) != '+' && !Character.isDigit(s.charAt(0))) return 0;
            if(s.charAt(0) == '+' && !Character.isDigit(s.charAt(1))) return 0;
            if(!sign && !Character.isDigit(s.charAt(1))) return 0;
            int ans=0;
            int i = !sign ? 1 : 0;
            for(;i<s.length();i++) {
                if(s.charAt(i) == '+') {
                    if(i == 0) continue;
                    else break;
                }
                if(!Character.isDigit(s.charAt(i))) break;
                if(ans > Integer.MAX_VALUE / 10 || (ans == Integer.MAX_VALUE / 10 && (s.charAt(i) - '0') > Integer.MAX_VALUE % 10))
                    return !sign ? Integer.MIN_VALUE : Integer.MAX_VALUE;
                ans = ans*10 + (s.charAt(i) - '0');
            }
            return !sign ? (ans*-1) : ans;
        }
    }
}