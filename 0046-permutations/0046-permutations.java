class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ls = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        if(nums.length == 1) {
            temp.add(nums[0]);
            ls.add(temp);
            return ls;
        }
        helper(1, nums, ls);
        return ls;
    }
    // For this question, because every List<Integer> of res will be the same length of arr.length, so we can just put every possible "arr" after swapping elements can be added after pre-existing checking in res List of list. Amdr base case satisfy hobar por base case r moddhe result array add na korleo cholbe
    public void helper(int idx, int arr[], List<List<Integer>> res) {
        if(idx == arr.length)
            return;
        for(int i=0;i<arr.length;i++) {
            swap(i, idx, arr);
            List<Integer> temp = new ArrayList<>(){{for(int i: arr) add(i);}};
            if(!res.contains(temp))
                res.add(temp);
            helper(idx+1, arr, res);
            swap(i, idx, arr);
        }
    }
    public void swap(int i, int j, int arr[]) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}