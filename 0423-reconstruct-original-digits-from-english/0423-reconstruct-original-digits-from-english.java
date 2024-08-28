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
/*
class Solution {
    public String originalDigits(String s) {
        Map<Character, Integer> map = new HashMap<>();
        char arr[] = {'e','g','f','i','h','o','n','s','r','u','t','w','v','x','z'};
        for(char c: arr)
            map.put(c, 0);
        for(char c: s.toCharArray())
            map.put(c, map.get(c)+1);
        int nums[] = new int[10];
        String res = "";
        int flag=0;

        while(true) {
            int e = map.get('e');
            int g = map.get('g');
            int f = map.get('f');
            int i = map.get('i');
            int h = map.get('h');
            int o = map.get('o');
            int n = map.get('n');
            int s_freq = map.get('s');
            int r = map.get('r');
            int u = map.get('u');
            int t = map.get('t');
            int w = map.get('w');
            int v = map.get('v');
            int x = map.get('x');
            int z = map.get('z');
            if(z >= 1 && e >= 1 && r >= 1 && o >= 1) {
                nums[0]++;
                map.put('z', map.get('z')-1);
                map.put('e', map.get('e')-1);
                map.put('r', map.get('r')-1);
                map.put('o', map.get('o')-1);
            }
            if(o >= 1 && n >= 1 && e >= 1) {
                nums[1]++;
                map.put('o', map.get('o')-1);
                map.put('n', map.get('n')-1);
                map.put('e', map.get('e')-1);
            }
            if(t >= 1 && w >= 1 && o >= 1) {
                nums[2]++;
                map.put('t', map.get('t')-1);
                map.put('w', map.get('w')-1);
                map.put('o', map.get('o')-1);
            }
            if(t >= 1 && h >= 1 && r >= 1 && e >= 2) {
                nums[3]++;
                map.put('t', map.get('t')-1);
                map.put('h', map.get('h')-1);
                map.put('r', map.get('r')-1);
                map.put('e', map.get('e')-2);
            }
            if(f >= 1 && o >= 1 && u >= 1 && r >= 1) {
                nums[4]++;
                map.put('f', map.get('f')-1);
                map.put('o', map.get('o')-1);
                map.put('u', map.get('u')-1);
                map.put('r', map.get('r')-1);
            }
            if(f >= 1 && i >= 1 && v >= 1 && e >= 1) {
                nums[5]++;
                map.put('f', map.get('f')-1);
                map.put('i', map.get('i')-1);
                map.put('v', map.get('v')-1);
                map.put('e', map.get('e')-1);
            }
            if(s_freq >= 1 && i >= 1 && x >= 1) {
                nums[6]++;
                map.put('s', map.get('s')-1);
                map.put('i', map.get('i')-1);
                map.put('x', map.get('x')-1);
            }
            if(s_freq >= 1 && e >= 2 && v >= 1 && n >= 1) {
                nums[7]++;
                map.put('s', map.get('s')-1);
                map.put('e', map.get('e')-2);
                map.put('v', map.get('v')-1);
                map.put('n', map.get('n')-1);
            }
            if(e >= 1 && i >= 1 && g >= 1 && h >= 1 && t >= 1) {
                nums[8]++;
                map.put('e', map.get('e')-1);
                map.put('i', map.get('i')-1);
                map.put('g', map.get('g')-1);
                map.put('h', map.get('h')-1);
                map.put('t', map.get('t')-1);
            }
            if(n >= 2 && i >= 1 && e >= 1) {
                nums[9]++;
                map.put('n', map.get('n')-2);
                map.put('i', map.get('i')-1);
                map.put('e', map.get('e')-1);
            }
            for(Character c: map.keySet())
                if(map.get(c) > 0)
                    flag=1;
            if(flag == 0)
                break;
            flag = 0;
        }
        for(int i=0;i<nums.length;i++) {
            while(nums[i] > 0) {
                res += String.valueOf(i);
                nums[i]--;
            }
        }
        return res;
    }
}*/