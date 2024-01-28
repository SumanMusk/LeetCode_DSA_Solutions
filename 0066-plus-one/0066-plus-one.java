class Solution {
    public int[] plusOne(int[] digits) {
        int temp=0;
        digits[digits.length-1]++;
        List<Integer> ls = new ArrayList<>();
        for(int i=digits.length-1;i>=0;i--){
            int val = (digits[i]+temp)/10;
            if(val != 0){
                ls.add((digits[i]+temp)%10);
                temp = val;
            }
            else{
                ls.add(digits[i]+temp);
                temp = 0;
            }
        }
        if(temp != 0)
            ls.add(temp);
        int[] ans = new int[ls.size()];
        for(int i=ans.length-1;i>=0;i--){
            ans[i] = ls.getFirst();
            ls.removeFirst();
        }
        return ans;
    }
}