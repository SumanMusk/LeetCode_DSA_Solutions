import java.util.*;

public class Top_K_Frequent_Elements {
    public static void main(String[] args) {
        int nums[] = {1,1,1,2,2,2,3,3,3};        
        int k=3;

        int count[] = new int[nums.length]; 
        Set<Integer> set = new HashSet<>();
        for(int i=0;i<nums.length;i++){
            for(int j=0;j<nums.length;j++){
                if(nums[j] == nums[i] && !set.contains(nums[i]))
                    count[i]++;
            }
            set.add(nums[i]);
        }
        
        List<List<Integer>> ls = new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            if(count[i] != 0){
                List<Integer> p = new ArrayList<>();
                p.add(count[i]);
                p.add(nums[i]);
                ls.add(p);
            }
        }
        // System.out.println(ls);
        Arrays.sort(count);
        int l=0,r=count.length-1;
        while(l<r){
            int z = count[l];
            count[l] = count[r];
            count[r] = z;
            l++;
            r--;
        }
        // System.out.println(Arrays.toString(count));

        int ans[] = new int[k];
        int s=0;
        for(int i=0;i<k;i++){
            for(int a=0;a<ls.size();a++){
                if(ls.get(a).get(0) == count[i]){
                    ans[s++] = ls.get(a).get(1);
                    ls.remove(a);
                }
            }
        }
        System.out.println(Arrays.toString(ans));
    }
}
