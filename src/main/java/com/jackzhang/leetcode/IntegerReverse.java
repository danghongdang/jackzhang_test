package com.jackzhang.leetcode;

public class IntegerReverse {

    public static int reverse2(int x) {
        if (x < 10 && x > -10) {
            return x;
        }
        boolean isNegative = x < 0;
        if (isNegative) {
            x = -x;
        }
        String str = String.valueOf(x);
        System.out.println(str);
        char[] charArray = str.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i=charArray.length-1; i>=0; i--) {
            sb.append(charArray[i]);
        }
        int result;
        try {
            result = Integer.parseInt(sb.toString());
        } catch (Exception e) {
            result = 0;
        }
        return isNegative ? -result : result;
    }

    public static int reverse(int x) {
        if (x < 10 && x > -10) {
            return x;
        }
        boolean isNegative = x < 0;
        if (isNegative) {
            x = -x;
        }
        long result = 0;
        int i = 1;
        while (x > 0) {
            result = (x%10 + result*i*10) > Integer.MAX_VALUE ? 0 : (x%10 + result*i*10);
            x = x / 10;
        }
        return isNegative ? (int)-result : (int)result;
    }

    public static void main(String args[]) {
        System.out.println(reverse(1534236469));
    }
}
