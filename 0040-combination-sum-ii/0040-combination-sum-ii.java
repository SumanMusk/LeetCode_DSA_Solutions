class Solution {
    public void comb(int arr[], int tar, List<List<Integer>> ans, List<Integer> temp, int amtSfr, int i){
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
            for(int x=i;x<arr.length;x++){
                if(x > i && arr[x-1] == arr[x]) continue;
                temp.add(arr[x]);
                amtSfr += arr[x];
                comb(arr, tar, ans, temp, amtSfr, x+1);
                amtSfr -= arr[x];
                temp.remove(temp.size()-1);
            }
        }
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ls = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        comb(candidates, target, ls, temp, 0, 0);
        return ls;
    }
}