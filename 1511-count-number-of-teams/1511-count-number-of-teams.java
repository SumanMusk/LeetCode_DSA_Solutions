class Solution {
    public int numTeams(int[] rating) {
        int count=0;
        for(int i=1;i<rating.length-1;i++) {
            int low_vals=0, high_vals=0;
            int j=i;
            while(j >= 0) {
                if(rating[i] > rating[j])
                    low_vals++;
                j--;
            }
            j=i;
            while(j < rating.length) {
                if(rating[i] < rating[j])
                    high_vals++;
                j++;
            }
            count += low_vals * high_vals;
            int high_bakup = high_vals;
            high_vals = i-low_vals;
            low_vals = rating.length-1-i-high_bakup;
            count += low_vals * high_vals;
        }
        return count;
    }
}