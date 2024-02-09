class Solution {
    public void swap(int a, int b, int arr[]){
        int x = arr[a];
        arr[a] = arr[b];
        arr[b] = x;
    }
    public void permu(int arr[], int idx, List<List<Integer>> ls){
        if(idx == arr.length) return;
        else{
            for(int i=0;i<arr.length-1;i++){
                swap(i, idx, arr);
                List<Integer> d = new ArrayList<>(){{for(int i: arr) add(i);}};
                if(!ls.contains(d))
                    ls.add(d);
                permu(arr, idx+1, ls);
                swap(i, idx, arr);
            }
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        permu(nums, 1, ans);
        if(ans.isEmpty()){
            if(nums.length == 1)
                ans.add(new ArrayList<>(){{for(int i: nums) add(i);}});
        }
        else{
            if(nums.length == 2)
                ans.add(new ArrayList<>(){{for(int i: nums) add(i);}});
        }
        return ans;
    }
}