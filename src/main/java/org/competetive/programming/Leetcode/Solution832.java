package org.competetive.programming.Leetcode;

public class Solution832 {

    public static void main(String[] args) {


    }

    public int[][] flipAndInvertImage(int[][] image) {

        int row = image.length;
        int col = image[0].length;
        for (int i = 0; i < row; i++) {
            int l = 0;
            int r = col - 1;
            while (l < r) {
                int temp = image[i][l];
                image[i][l] = image[i][r];
                image[i][r] = temp;
                l++;
                r--;
            }
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                image[i][j] = 1 - image[i][j];
            }
        }
        return image;
    }
}
