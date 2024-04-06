class Solution {
    public String reverseWords(String s) {
        if(s.charAt(s.length()-1) != ' ') s += " ";
        List<String> ls = new ArrayList<>();
        int l=0;
        while(l < s.length()) {
            if(s.charAt(l) != ' ') {
                int r=l;
                while(s.charAt(r) != ' ') r++;
                ls.add(s.substring(l, r));
                l=r;
            }
            else l++;
        }
        s="";
        for(int i=ls.size()-1;i>=0;i--) {
            s += ls.get(i);
            s += " ";
        }
        return s.substring(0, s.length()-1);
    }
}
/*
class Solution {
    public String reverseWords(String s) {
        s = s.trim();
        String strs[] = s.split(" ");
        s="";
        String temp = " ";
        System.out.println(Arrays.toString(strs));
        for(int i=strs.length-1;i>=0;i--) {
            if(!strs[i].equals("")) {
                s += strs[i];
                s += " ";
            }
        }
        return s.substring(0, s.length()-1);
    }
}
*/