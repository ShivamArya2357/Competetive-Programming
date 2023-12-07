package org.competetive.programming.Leetcode;

public class Solution8 {

    public static void main(String[] args) {

    }

//    1. First Approach
//    public int myAtoi(String s) {
//
//        s = s.trim();
//        int sign = 0;
//        int len = s.length();
//        if (len > 0 && s.charAt(0) == '-') {
//            sign = -1;
//        } else if (len > 0 && s.charAt(0) == '+') {
//            sign = 1;
//        }
//        StringBuilder newS = new StringBuilder();
//        if (sign == 0) {
//            if (len > 0 && Character.isDigit(s.charAt(0))) {
//                newS.append(s.charAt(0));
//            } else {
//                return 0;
//            }
//        }
//        for (int i = 1; i < len; i++) {
//            if (Character.isDigit(s.charAt(i))) {
//                newS.append(s.charAt(i));
//            } else {
//                break;
//            }
//        }
//        String numWithoutLeadingZeroes = removeLeadingZeroes(newS.toString());
//        if (numWithoutLeadingZeroes.length() == 0) {
//            return 0;
//        } else if (numWithoutLeadingZeroes.length() > 10) {
//            return (sign == 0  || sign == 1) ? (1 << 31) - 1 : -(1 << 31);
//        } else if (numWithoutLeadingZeroes.length() == 10) {
//            String lowerBound = "2147483648";
//            String upperBound = "2147483647";
//            if (sign == 0 || sign == 1) {
//                for (int i = 0; i < 10; i++) {
//                    if (numWithoutLeadingZeroes.charAt(i) - '0' <
//                            upperBound.charAt(i) - '0'
//                    ) {
//                        return sign == 0 ? Integer.parseInt(numWithoutLeadingZeroes) :
//                                ((sign == 1) ? +Integer.parseInt(numWithoutLeadingZeroes) :
//                                        Integer.parseInt("-" + numWithoutLeadingZeroes));
//                    } else if (numWithoutLeadingZeroes.charAt(i) - '0' >
//                            upperBound.charAt(i) - '0'
//                    ) {
//                        break;
//                    }
//                }
//                return Integer.parseInt(upperBound);
//            } else {
//                for (int i = 0; i < 10; i++) {
//                    if (numWithoutLeadingZeroes.charAt(i) - '0' <
//                            lowerBound.charAt(i) - '0'
//                    ) {
//                        return sign == 0 ? Integer.parseInt(numWithoutLeadingZeroes) :
//                                ((sign == 1) ? +Integer.parseInt(numWithoutLeadingZeroes) :
//                                        Integer.parseInt("-" + numWithoutLeadingZeroes));
//                    } else if (numWithoutLeadingZeroes.charAt(i) - '0' >
//                            lowerBound.charAt(i) - '0'
//                    ) {
//                        break;
//                    }
//                }
//                return Integer.parseInt("-" + lowerBound);
//            }
//        } else if (sign == 0) {
//            return Integer.parseInt(numWithoutLeadingZeroes);
//        } else if (sign == 1) {
//            return +Integer.parseInt(numWithoutLeadingZeroes);
//        } else {
//            return Integer.parseInt("-" + numWithoutLeadingZeroes);
//        }
//    }
//
//    private String removeLeadingZeroes(String num) {
//
//        StringBuilder sb = new StringBuilder();
//        int len = num.length();
//        for (int i = 0; i < len; i++) {
//            if (num.charAt(i) == '0' && sb.length() == 0) {
//            } else {
//                sb.append(num.charAt(i));
//            }
//        }
//        return sb.toString();
//    }

    public int myAtoi(String s) {

        s = s.trim();
        int sign = 0;
        int len = s.length();
        if (len > 0 && s.charAt(0) == '-') {
            sign = -1;
        } else if (len > 0 && s.charAt(0) == '+') {
            sign = 1;
        }
        int num = 0;
        if (sign == 0) {
            if (len > 0 && Character.isDigit(s.charAt(0))) {
                num = s.charAt(0) - '0';
            } else {
                return 0;
            }
        }
        for (int i = 1; i < len; i++) {
            if (Character.isDigit(s.charAt(i))) {
                int digit = s.charAt(i) - '0';
                if ((num < Integer.MAX_VALUE / 10) || ((sign == 0 || sign == 1) && num == Integer.MAX_VALUE / 10 && digit >= 0 &&
                        digit < 7) || (sign == -1 && num == Integer.MAX_VALUE / 10 && digit >= 0 &&
                        digit < 8)
                ) {
                    num = (num * 10) + digit;
                } else if ((num > Integer.MAX_VALUE / 10) || ((sign == 0 || sign == 1) &&
                        num == Integer.MAX_VALUE / 10 && digit >= 7) || ((sign == -1) &&
                        num == Integer.MAX_VALUE / 10 && digit >= 8)
                ) {
                    return sign == 0 || sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
                }
            } else {
                break;
            }
        }
        if (sign == 0 || num == 0) {
            return num;
        } else if (sign == 1) {
            return +num;
        } else {
            return -num;
        }
    }
}
