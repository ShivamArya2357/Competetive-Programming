package org.competetive.programming.Leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution2545 {

    public static void main(String[] args) {

    }

    public int[][] sortTheStudents(int[][] score, int k) {

        List<Pair<Integer, Integer> > scoreList = new ArrayList<>();
        int row = score.length;
        int col = score[0].length;
        for (int i = 0; i < row; i++) {
            scoreList.add(new Pair<>(score[i][k], i));
        }
        Collections.sort(scoreList, (o1, o2) -> o2.getKey() - o1.getKey());
        int[][] ans = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                ans[i][j] = score[scoreList.get(i).getValue()][j];
            }
        }
        return ans;
    }

}

