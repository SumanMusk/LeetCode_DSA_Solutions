class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int l=0, r=people.length-1, count=0;
        while(r >= l) {
            if(people[l]+people[r] <= limit) 
                l++;
            count++;
            r--;
        }
        return count;
    }
}
/*class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        boolean visited[] = new boolean[people.length];
        int r=people.length-1, count=0;
        while(r >= 1) {
            if(people[r] == limit) {
                count++;
                r--;
            }
            else {
                int l=0, f=0;
                while(r > l) {
                    if(!visited[l] && !visited[r] && (people[r] + people[l]) <= limit) {
                        visited[l] = true;
                        visited[r] = true;
                        count++;
                        f=1;
                        break;
                    }
                    l++;
                }
                if(f == 0 && !visited[r])
                    count++;
                r--;
            }
        }
        return !visited[r] ? count+1 : count;
    }
}*/