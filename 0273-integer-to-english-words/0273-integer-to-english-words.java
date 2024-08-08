class Solution {
    public String numberToWords(int num) {
        if(num == 0)
            return "Zero";
        Map<Integer, String> ones_map = new HashMap<>();
        Map<Integer, String> tens_map = new HashMap<>();
        ones_map.put(1, "One");
        ones_map.put(2, "Two");
        ones_map.put(3, "Three");
        ones_map.put(4, "Four");
        ones_map.put(5, "Five");
        ones_map.put(6, "Six");
        ones_map.put(7, "Seven");
        ones_map.put(8, "Eight");
        ones_map.put(9, "Nine");
        ones_map.put(10, "Ten");
        ones_map.put(11, "Eleven");
        ones_map.put(12, "Twelve");
        ones_map.put(13, "Thirteen");
        ones_map.put(14, "Fourteen");
        ones_map.put(15, "Fifteen");
        ones_map.put(16, "Sixteen");
        ones_map.put(17, "Seventeen");
        ones_map.put(18, "Eighteen");
        ones_map.put(19, "Nineteen");
        tens_map.put(20, "Twenty");
        tens_map.put(30, "Thirty");
        tens_map.put(40, "Forty");
        tens_map.put(50, "Fifty");
        tens_map.put(60, "Sixty");
        tens_map.put(70, "Seventy");
        tens_map.put(80, "Eighty");
        tens_map.put(90, "Ninety");
        String titles[] = {"", "Thousand", "Million", "Billion"};
        int c=0;
        List<String> ls = new ArrayList<>();
        while(num != 0) {
            int last_3_digits = num % 1000;
            List<String> temp = helper(last_3_digits, ones_map, tens_map);
            if(!temp.isEmpty()) {
                temp.addFirst(titles[c]);
                ls.addAll(temp);
            }
            c++;
            num /= 1000;
        }
        Collections.reverse(ls);
        String ans = String.join(" ", ls);
        return ans.charAt(ans.length()-1) == ' ' ? ans.substring(0, ans.length()-1) : ans;
    }
    public List<String> helper(int num, Map<Integer, String> ones_map, Map<Integer, String> tens_map) {
        // types of possible numbers => 123 012 005 105 000
        if(num == 0)
            return new ArrayList<>();
        int last_2_dgts = num % 100;
        int fst_dgt = num / 100;
        List<String> ls = new ArrayList<>();
        if(last_2_dgts >= 20 && last_2_dgts % 10 != 0) {
            int scnd_last_dgt = last_2_dgts / 10;
            ls.add(ones_map.get(last_2_dgts % 10));
            ls.add(tens_map.get(scnd_last_dgt * 10));
        }
        else {
            if(last_2_dgts >= 20)
                ls.add(tens_map.get(last_2_dgts));
            else if(last_2_dgts != 0)
                ls.add(ones_map.get(last_2_dgts));
        }
        if(fst_dgt != 0) {
            ls.add("Hundred");
            ls.add(ones_map.get(fst_dgt));
        }
        return ls;
    }
}