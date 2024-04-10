class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        for(int i=0;i<flowerbed.length && n > 0;i++) {
            int f=0;
            if(flowerbed[i] == 0) {
                if(i-1 < 0) f++;
                else if(i-1 >= 0 && flowerbed[i-1] == 0) f++;
                
                if(i+1 == flowerbed.length) f++;
                else if(i+1 < flowerbed.length && flowerbed[i+1] == 0) f++;
            }
            if(f == 2) {
                n--;
                flowerbed[i] = 1;
            }
        }
        return (n == 0) ? true : false;
    }
}