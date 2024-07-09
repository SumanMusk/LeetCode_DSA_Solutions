class Solution {
    public double averageWaitingTime(int[][] customers) {
        int endTime=0;
        double toTime=0;
        for(int arr[]: customers) {
            if(arr[0] > endTime)
                endTime = arr[0];
            endTime += arr[1];
            toTime += endTime-arr[0];
        }
        return toTime/customers.length;
    }
}