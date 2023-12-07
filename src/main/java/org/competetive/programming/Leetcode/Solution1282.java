package org.competetive.programming.Leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution1282 {

    public static void main(String[] args) {

    }

    public List<List<Integer> > groupThePeople(int[] groupSizes) {

        Map<Integer, List<Integer> > groupMap = new HashMap<>();
        List<List<Integer> > res = new ArrayList<>();
        for (int i = 0; i < groupSizes.length; i++) {
            if (groupMap.containsKey(groupSizes[i])) {
                List<Integer> existingGroup = groupMap.get(groupSizes[i]);
                existingGroup.add(i);
            } else {
                List<Integer> newGroup = new ArrayList<>();
                newGroup.add(i);
                groupMap.put(groupSizes[i], newGroup);
            }
            if (groupMap.get(groupSizes[i]).size() == groupSizes[i]) {
                res.add(groupMap.get(groupSizes[i]));
                groupMap.remove(groupSizes[i]);
            }
        }
        return res;
    }
}
