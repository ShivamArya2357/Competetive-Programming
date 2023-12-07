package org.competetive.programming.Leetcode;


import java.util.*;

/**
 * https://leetcode.com/problems/arithmetic-subarrays/
 *
 */
public class Solution1630 {

    public static void main(String[] args) {

    }

    // 1. First Approach
//    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
//
//        Boolean[] ans = new Boolean[l.length];
//        List<Range> ranges = new ArrayList<>();
//        for (int i = 0; i < l.length; i++) {
//            ranges.add(new Range(l[i], r[i], i));
//        }
//        Collections.sort(ranges, Comparator.comparingInt(Range::getL));
//        Deque<Integer> deque = new ArrayDeque<>();
//        for (Range range : ranges) {
//            if (deque.isEmpty() || (!deque.isEmpty() && deque.getLast() <= range.getL())) {
//                while (!deque.isEmpty()) {
//                    deque.removeFirst();
//                }
//                for (int i = range.getL(); i <= range.getR(); i++) {
//                    deque.add(i);
//                }
//            } else {
//                if (deque.getLast() > range.getL()) {
//                    while (!deque.isEmpty() && deque.getFirst() < range.getL()) {
//                        deque.removeFirst();
//                    }
//                }
//                if (deque.getLast() > range.getR()) {
//                    while (!deque.isEmpty() && deque.getLast() > range.getR()) {
//                        deque.removeLast();
//                    }
//                }
//                if (deque.getLast() < range.getR()) {
//                    for (int i = deque.getLast() + 1; i <= range.getR(); i++) {
//                        deque.add(i);
//                    }
//                }
//            }
//            if (deque.size() < 3) {
//                ans[range.getIndex()] = true;
//            } else {
//                int[] temp = new int[deque.size()];
//                int index = 0;
//                for (Integer arrIndex : deque) {
//                    temp[index++] = nums[arrIndex];
//                }
//                Arrays.sort(temp);
//                int diff = temp[1] - temp[0];
//                boolean isArithmetic = true;
//                for (int i = 2; i < deque.size(); i++) {
//                    if (temp[i] - temp[i - 1] != diff) {
//                        isArithmetic = false;
//                        break;
//                    }
//                }
//                ans[range.getIndex()] = isArithmetic;
//            }
//        }
//        return List.of(ans);
//    }

    // 2. Second Approach
//    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
//
//        List<Boolean> res = new ArrayList<>();
//        for (int i = 0; i < l.length; i++) {
//            int[] arr = new int[r[i] - l[i] + 1];
//            int index = 0;
//            for (int j = l[i]; j <= r[i]; j++) {
//                arr[index++] = nums[j];
//            }
//            Arrays.sort(arr);
//            res.add(isArithmetic(arr));
//        }
//        return res;
//    }
//
//    private boolean isArithmetic(int[] arr) {
//
//        if (arr.length < 3) {
//            return true;
//        } else {
//            int diff = arr[1] - arr[0];
//            for (int i = 2; i < arr.length; i++) {
//                if (arr[i] - arr[i - 1] != diff) {
//                    return false;
//                }
//            }
//            return true;
//        }
//    }

    // 3. Third Approach
    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {

        List<Boolean> res = new ArrayList<>();
        for (int i = 0; i < l.length; i++) {
            int[] arr = new int[r[i] - l[i] + 1];
            int index = 0;
            for (int j = l[i]; j <= r[i]; j++) {
                arr[index++] = nums[j];
            }
            res.add(isArithmetic(arr));
        }
        return res;
    }

    private boolean isArithmetic(int[] arr) {

        if (arr.length < 3) {
            return true;
        } else {
            int maxEle = Integer.MIN_VALUE;
            int minEle = Integer.MAX_VALUE;
            Set<Integer> set = new HashSet<>();
            for (int i = 0; i < arr.length; i++) {
                maxEle = Math.max(maxEle, arr[i]);
                minEle = Math.min(minEle, arr[i]);
                set.add(arr[i]);
            }
            if ((maxEle - minEle) % (arr.length - 1) != 0) {
                return false;
            }
            int diff = (maxEle - minEle) / (arr.length - 1);
            int count = 1;
            int key = minEle + diff;
            while (key < arr.length && set.contains(key)) {
                count++;
                key += diff;
            }
            // System.out.println(diff + " " + minEle);
            return count == arr.length;
        }
    }
}

class Range {

    private int l;

    private int r;

    private int index;

    public Range(int l, int r, int index) {
        this.l = l;
        this.r = r;
        this.index = index;
    }

    public int getL() {
        return l;
    }

    public void setL(int l) {
        this.l = l;
    }

    public int getR() {
        return r;
    }

    public void setR(int r) {
        this.r = r;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}
