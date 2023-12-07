package org.competetive.programming.Leetcode;

public class Solution11 {

    public static void main(String[] args) {

    }

//    1. Brute Force Approach
//    public int maxArea(int[] height) {
//
//        int len = height.length;
//        int ans = 0;
//        int area;
//        for (int i = 0; i < len; i++) {
//            area = 0;
//            for (int j = 0; j < i; j++) {
//                if (height[j] >= height[i]) {
//                    area += (i - j + 1) * height[i];
//                    break;
//                }
//            }
//            for (int j = len - 1; j >= i; j--) {
//                if (height[j] >= height[i]) {
//                    area += (j - i) * height[i];
//                    break;
//                }
//            }
//            ans = Math.max(ans, area);
//        }
//        return ans;
//    }

//    2. Optimized Approach

    public int maxArea(int[] height) {

        int len = height.length;
        int ans = 0;
        int l = 0;
        int r = len - 1;
        while (l < r) {
            ans = Math.max(ans, (Math.min(height[l], height[r])) * (r - l));
            if (height[l] <= height[r]) {
                l++;
            } else {
                r--;
            }
        }
        return ans;
    }
}
