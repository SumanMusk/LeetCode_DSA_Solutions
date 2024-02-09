class Solution {
    public void comb(int arr[], int tar, List<List<Integer>> ans, List<Integer> temp, int amtSfr){
        if(amtSfr > tar)
            return;
        else if(amtSfr == tar){
            List<Integer> x = new ArrayList<>(temp);
            x.sort(null);
            if(!ans.contains(x))
                ans.add(x);
            return;
        }
        else{
            for(int x=0;x<arr.length;x++){
                temp.add(arr[x]);
                amtSfr += arr[x];
                comb(arr, tar, ans, temp, amtSfr);
                amtSfr -= arr[x];
                temp.remove(temp.size()-1);
            }
        }
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        comb(candidates, target, ans, temp, 0);
        return ans;
    }
}