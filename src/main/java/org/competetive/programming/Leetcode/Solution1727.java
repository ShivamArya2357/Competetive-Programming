package org.competetive.programming.Leetcode;

import java.util.ArrayList;
import java.util.List;

public class Solution1727 {

    public static void main(String[] args) {


    }

//    public int largestSubmatrix(int[][] matrix) {
//
//        int row = matrix.length;
//        int col = matrix[0].length;
//        int ans = 0;
//        for (int i = 0; i < col; i++) {
//            for (int j = 1; j < row; j++) {
//                matrix[j][i] += matrix[j - 1][i];
//            }
//        }
//        for (int i = 0; i < row; i++) {
//            List<Integer> noOfOnesList = new ArrayList<>();
//            for (int j = 0; j < col; j++) {
//                if (matrix[i][j] > 0) {
//                    noOfOnesList.add(matrix[i][j]);
//                }
//            }
//            Collections.sort(noOfOnesList, Collections.reverseOrder());
//            for (Integer noOfOne : noOfOnesList) {
//                System.out.print(noOfOne + " ");
//            }
//            System.out.println();
//            for (int k = 0; k < noOfOnesList.size(); k++) {
//                ans = Math.max(ans, (k + 1) * noOfOnesList.get(k));
//            }
//        }
//        return ans;
//    }

    public int largestSubmatrix(int[][] matrix) {

        int n = matrix.length;
        int m = matrix[0].length;
        List<Pair<Integer, Integer> > prevHeights = new ArrayList<>();
        int ans = 0;
        for (int row = 0; row < n; row++) {
            List<Pair<Integer, Integer> > heights = new ArrayList<>();
            Boolean[] seen = new Boolean[m];
            for (int col = 0; col < m; col++) {
                seen[col] = false;
            }
            for (Pair<Integer, Integer> pair : prevHeights) {
                int height = pair.getKey();
                int col = pair.getValue();
                if (matrix[row][col] == 1) {
                    heights.add(new Pair<>(height + 1, col));
                    seen[col] = true;
                }
            }
            for (int col = 0; col < m; col++) {
                if (Boolean.FALSE.equals(seen[col]) && matrix[row][col] == 1) {
                    heights.add(new Pair<>(1, col));
                }
            }
            for (int i = 0; i < heights.size(); i++) {
                ans = Math.max(ans, (i + 1) * heights.get(i).getKey());
            }
            prevHeights = heights;
        }
        return ans;
    }
}

class Pair<T, V> {

    private T key;

    private V value;

    public Pair(T key, V value) {
        this.key = key;
        this.value = value;
    }

    public T getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

    public void setKey(T key) {
        this.key = key;
    }

    public void setValue(V value) {
        this.value = value;
    }
}


