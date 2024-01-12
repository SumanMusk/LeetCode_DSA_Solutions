class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int arr[] = new int[(matrix.length * matrix[0].length)];
        int c=0;
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++)
                arr[c++] = matrix[i][j];
        }

        int l=0,r=arr.length-1,f=0;

        while(l<=r){
            int mid = (l+r)/2;
            if(arr[mid] == target){
                f=1;
                break;
            }
            else if(arr[mid] > target)
                r = mid - 1;
            else
                l = mid + 1;
        }
        if(f == 1) return true;
        else return false;
    }
}