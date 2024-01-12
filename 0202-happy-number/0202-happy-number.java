class Solution {
    public boolean isHappy(int n) {
        int f=0;
        for(int i=0;i<100;i++){
            int res = 0;
            while(n!=0){
                int x = n%10;
                x = x*x;
                res += x;
                n = n/10;
            }
            if(res == 1){
                f=1;
                break;
            }
            else{
                n = res;
                res = 0;
            }
        }
        if(f == 1) return true;
        else return false;
    }
}