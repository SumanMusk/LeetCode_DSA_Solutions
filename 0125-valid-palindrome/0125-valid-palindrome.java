class Solution {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        StringBuilder str = new StringBuilder();
        for(int i=0;i<s.length();i++) {
            //if(Character.isAlphabetic(s.charAt(i)) || Character.isDigit(s.charAt(i)))
            if(Character.isLetterOrDigit(s.charAt(i)))
                str.append(s.charAt(i));
        }
        s = str.toString();
        String rev = str.reverse().toString();
        return rev.equals(s);
    }
}