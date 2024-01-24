class Solution {
    public int divisorSubstrings(int num, int k) {
        int[] digits = Integer.toString(num).chars().map((c) -> {c = c-'0'; return c;}).toArray();
        int l=0,r=k-1,ans=0;
        if(digits.length == 1 && k != 0)
            return 1;
        else{
            while(r < digits.length){
                String str = "";
                for(int i=l;i<=r;i++)
                    str += digits[i];
                int part = Integer.parseInt(str);
                if(part != 0){
                    if(num % part == 0)
                        ans++;
                }
                str = "";
                l++;
                r++;
            }
            return ans;
        }
    }
}