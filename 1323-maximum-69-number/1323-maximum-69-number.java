class Solution {
    public int maximum69Number (int num) {
        char arr[] = Integer.toString(num).toCharArray();
        for(int i=0;i<arr.length;i++) {
            if(arr[i] == '6') {
                arr[i] = '9';
                break;
            }
        }
        num = 0;
        for(int i=0;i<arr.length;i++) 
            num = (num * 10) + (arr[i]-'0');
        return num;
    }
}