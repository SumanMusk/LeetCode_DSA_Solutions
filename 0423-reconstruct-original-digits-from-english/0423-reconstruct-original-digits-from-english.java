class Solution {
    public String originalDigits(String s) {
        int nums[] = new int[10];
        Map<Character, Integer> map = new HashMap<>();
        char arr[] = {'e','g','f','i','h','o','n','s','r','u','t','w','v','x','z'};
        for(char c: arr)
            map.put(c, 0);
        for(char c: s.toCharArray())
            map.put(c, map.get(c)+1);
        nums[0] = map.get('z'); // zero
        nums[2] = map.get('w'); // two
        nums[4] = map.get('u'); // four
        nums[6] = map.get('x'); // six
        nums[8] = map.get('g'); // eight
        nums[1] = map.get('o') - map.get('z') - map.get('w') - map.get('u'); // one
        nums[3] = map.get('t') - map.get('w') - map.get('g'); // three
        nums[5] = map.get('f') - map.get('u'); // five
        nums[7] = map.get('s') - map.get('x'); // seven
        nums[9] = map.get('i') - nums[5] - nums[6] - nums[8]; // nine

        String res = "";

        for(int i=0;i<nums.length;i++) {
            while(nums[i] > 0) {
                res += String.valueOf(i);
                nums[i]--;
            }
        }
        return res;
    }
}
