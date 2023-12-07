package org.competetive.programming.Leetcode;

import java.util.TreeSet;

public class Solution414 {

    public static void main(String[] args) {


    }

//    1. First Approach

//    public int thirdMax(int[] nums) {
//
//        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
//        Set<Integer> set = new HashSet<>();
//        int len = nums.length;
//        for (int i = 0; i < len; i++) {
//            if (minHeap.size() < 3 && !set.contains(nums[i])) {
//                minHeap.add(nums[i]);
//                set.add((nums[i]));
//            } else if (minHeap.size() >= 3) {
//                if (minHeap.peek() < nums[i] && !set.contains(nums[i])) {
//                    set.remove(minHeap.peek());
//                    minHeap.poll();
//                    minHeap.add(nums[i]);
//                    set.add(nums[i]);
//                }
//            }
//        }
//        return minHeap.size() == 3 ? minHeap.peek() : findMax(minHeap);
//    }
//
//    private int findMax(PriorityQueue<Integer> minHeap) {
//
//        int firstMaxEle = Integer.MIN_VALUE;
//        while (!minHeap.isEmpty()) {
//            firstMaxEle = Math.max(firstMaxEle, minHeap.poll());
//        }
//        return firstMaxEle;
//    }

    //    2. Second Approach
    public int thirdMax(int[] nums) {

        TreeSet<Integer> treeSet = new TreeSet<>();
        for (int key : nums) {
            if (treeSet.size() < 3 && !treeSet.contains(key)) {
                treeSet.add(key);
            } else if (treeSet.size() >= 3) {
                if (treeSet.first() < key) {
                    treeSet.pollFirst();
                    treeSet.add(key);
                }
            }
        }
        return treeSet.size() == 3 ? treeSet.first() : treeSet.last();
    }
}
