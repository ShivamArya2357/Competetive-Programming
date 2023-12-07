package org.competetive.programming.Leetcode;

import java.util.*;

public class Solution2610 {

    public static void main(String[] args) {

    }

    // 1. First Approach
//    public List<List<Integer> > findMatrix(int[] nums) {
//
//        List<List<Integer> > res = new ArrayList<>();
//        LinkedList<Integer> linkedList = new LinkedList<>();
//        for (int i = 0; i < nums.length; i++) {
//            linkedList.add(nums[i]);
//        }
//        while (linkedList.size() > 0) {
//            Iterator<Integer> itr = linkedList.iterator();
//            List<Integer> temp = new ArrayList<>();
//            Set<Integer> seen = new HashSet<>();
//            while (itr.hasNext()) {
//                int num = itr.next();
//                if (!seen.contains(num)) {
//                    temp.add(num);
//                    itr.remove();
//                    seen.add(num);
//                }
//            }
//            if (temp.size() > 0) {
//                res.add(temp);
//            }
//        }
//        return res;
//    }

    // 2. Second Approach
    public List<List<Integer>> findMatrix(int[] nums) {

        List<List<Integer> > res = new ArrayList<>();
        int[] freq = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            freq[nums[i]]++;
            if (res.size() < freq[nums[i]]) {
                List<Integer> temp = new ArrayList<>();
                temp.add(nums[i]);
                res.add(temp);
            } else {
                List<Integer> temp = res.get(freq[nums[i]] - 1);
                temp.add(nums[i]);
            }
        }
        return res;
    }
}
