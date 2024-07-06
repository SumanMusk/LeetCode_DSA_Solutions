class Solution {
    public int passThePillow(int n, int time) {
        int com = time/(n-1);
        int rem = time % (n-1);
        if(com % 2 != 0)
            return n - rem;
        else return rem + 1;
    }
}