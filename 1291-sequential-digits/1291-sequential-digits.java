class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        int increVal = 11, ans = 12, temp = 3, f = 0;
        List<Integer> ls = new ArrayList<>();
        if(high == low){
            int val = low, chk = Integer.MIN_VALUE, x;
            int flag = 0;
            while(val != 0){
                x = val % 10;
                if(chk != Integer.MIN_VALUE){
                    if((chk - 1) == x) flag = 1;
                    chk = x;
                } else chk = x;
                val = val/10;
            }
            if(flag == 1)
                ls.add(low);
            return ls;
        } 
        int updateVal = ans;
        while(ans < high){
            if(ans < low){
                if(ans%10 == 9){
                    ans = (updateVal*10) + temp++;
                    updateVal = ans;
                    increVal = (10*increVal) + 1;
                }
                else
                    ans += increVal;
                if(ans >= low && ans <= high && f == 0){
                    ls.add(ans);
                    f = 1;
                }
            }
            else if(ans == 123456789) break;
            else if(ans%10 == 9){
                ans = (updateVal*10) + temp++;
                updateVal = ans;
                increVal = (10*increVal) + 1;
                if(ans <= high)
                    ls.add(ans);
            }
            else{
                if(ans >= low && ans <= high && f == 0){
                    ls.add(ans);
                    f = 1;
                }
                ans += increVal;
                if(ans <= high)
                    ls.add(ans);
            }
        }
        return ls;
    }
}