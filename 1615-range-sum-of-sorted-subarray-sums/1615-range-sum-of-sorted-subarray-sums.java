// Using int array
class Solution {
    public int rangeSum(int[] nums, int n, int left, int right) {
        int arr[] = new int[(n*(n+1))/2];
        for(int i=0,c=0;i<nums.length;i++) {
            int sum=0;
            for(int j=i;j<nums.length;j++) {
                sum += nums[j];
                arr[c++] = sum;
            }
        }
        Arrays.sort(arr);
        int sum=0, mod=1000000007;
        for(int i=left-1;i<right;i++) 
            sum = (sum + arr[i]) % mod;
        return sum;
    }
}

/*
// Using an ArrayList
class Solution {
    public int rangeSum(int[] nums, int n, int left, int right) {
        List<Integer> ls = new ArrayList<>();
        for(int i=0;i<nums.length;i++) {
            int sum=0;
            for(int j=i;j<nums.length;j++) {
                sum += nums[j];
                ls.add(sum);
            }
        }
        Collections.sort(ls);
        int sum=0, mod=1000000007;
        for(int i=left-1;i<right;i++) 
            sum = (sum + ls.get(i)) % mod;
        return sum;
    }
}
*/