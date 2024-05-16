class Solution {
    public String multiply(String num1, String num2) {
        if(num1.length() > num2.length())
            multiply(num2, num1);
        int arr[] = new int[num1.length()+num2.length()+1];
        int lenCount=0, c=0, carry=0;
        for(int i=num1.length()-1;i>=0;i--) {
            int tempCount=c;
            for(int j=num2.length()-1;j>=0;j--) {
                int x = num1.charAt(i) - '0';
                int y = num2.charAt(j) - '0';
                int digit = (x * y) + arr[tempCount] + carry;
                arr[tempCount] = digit % 10;
                carry = digit / 10;
                tempCount++;
            }
            if(carry > 0) {
                arr[tempCount++] = carry;
                carry = 0;
            }
            c++;
            lenCount = tempCount;
        }
        // If str = "0000", then return 0
        int f=0;
        for(int i: arr)
            if(i != 0)
                f=1;
        if(f == 0)
            return "0";
        String str="";
        for(int i=0;i<lenCount;i++)
            str = arr[i] + str;
        return str;
    }
}