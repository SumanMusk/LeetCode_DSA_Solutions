class Solution {
    public boolean lemonadeChange(int[] bills) {
        int inHand_5_Bill=0;
        int inHand_10_Bill=0;
        int inHand_20_Bill=0;
        int tenFlag=0, fiveFlag=0;
        for(int i: bills) {
            if(i > 5) {
                int temp = i-5;
                while(temp != 0) {
                    if(inHand_10_Bill > 0 && temp-10 >= 0) {
                        temp -= 10;
                        inHand_10_Bill--;
                        tenFlag=1;
                    }
                    else if(inHand_5_Bill > 0 && temp-5 >= 0) {
                        temp -= 5;
                        inHand_5_Bill--;
                        fiveFlag=1;
                    }
                    if(tenFlag == 0 && fiveFlag == 0)
                        return false;
                    tenFlag=0;
                    fiveFlag=0;
                }
                if(i == 10)
                    inHand_10_Bill++;
            }
            else
                inHand_5_Bill++;
        }
        return true;
    }
}