package org.competetive.programming.Leetcode;

import java.util.*;

public class Solution15 {

    public List<List<Integer>> threeSum(int[] nums) {

        int len = nums.length;
        Map<Integer, List<Index> > sumIndexMap = new HashMap<>();
        Set<List<Integer> > res = new HashSet<>();
        Set<Integer> duplicates = new HashSet<>();
        for (int i = 0; i < len; i++) {
            if (duplicates.add(nums[i])) {
                for (int j = i + 1; j < len; j++) {
                    int sum = nums[i] + nums[j];
                    if (sumIndexMap.containsKey(sum)) {
                        List<Index> indexes = sumIndexMap.get(sum);
                        indexes.add(new Index(i, j));
                    } else {
                        List<Index> indexes = new ArrayList<>();
                        indexes.add(new Index(i, j));
                        sumIndexMap.put(sum, indexes);
                    }
                }
            }
        }

        for (int i = 0; i < len; i++) {
            if (sumIndexMap.containsKey(-nums[i])) {
                List<Index> indexes = sumIndexMap.get(-nums[i]);
                for (Index index : indexes) {
                    if (index.getFirstIndex() != i && index.getSecondIndex() != i) {
                        List<Integer> tripletsList = new ArrayList<>();
                        tripletsList.add(nums[index.getFirstIndex()]);
                        tripletsList.add(nums[index.getSecondIndex()]);
                        tripletsList.add(nums[i]);
                        Collections.sort(tripletsList);
                        res.add(tripletsList);
                    }
                }
            }
        }
        return new ArrayList<>(res);
    }
}

class Index {

    private int firstIndex;

    private int secondIndex;

    public Index(int firstIndex, int secondIndex) {
        this.firstIndex = firstIndex;
        this.secondIndex = secondIndex;
    }

    public int getFirstIndex() {
        return firstIndex;
    }

    public void setFirstIndex(int firstIndex) {
        this.firstIndex = firstIndex;
    }

    public int getSecondIndex() {
        return secondIndex;
    }

    public void setSecondIndex(int secondIndex) {
        this.secondIndex = secondIndex;
    }
}

class Triplet {

    private int firstIndex;

    private int secondIndex;

    private int thirdIndex;

    public Triplet(int firstIndex, int secondIndex, int thirdIndex) {
        this.firstIndex = firstIndex;
        this.secondIndex = secondIndex;
        this.thirdIndex = thirdIndex;
    }

    public int getFirstIndex() {
        return firstIndex;
    }

    public void setFirstIndex(int firstIndex) {
        this.firstIndex = firstIndex;
    }

    public int getSecondIndex() {
        return secondIndex;
    }

    public void setSecondIndex(int secondIndex) {
        this.secondIndex = secondIndex;
    }

    public int getThirdIndex() {
        return thirdIndex;
    }

    public void setThirdIndex(int thirdIndex) {
        this.thirdIndex = thirdIndex;
    }

    @Override
    public boolean equals(Object o) {

        Triplet triplet = (Triplet) o;
        return firstIndex == triplet.firstIndex && secondIndex == triplet.secondIndex && thirdIndex == triplet.thirdIndex;
    }
}
