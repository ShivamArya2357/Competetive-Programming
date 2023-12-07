package org.competetive.programming.Leetcode;

import java.util.LinkedList;

public class Solution933 {

    public static void main(String[] args) {


    }
}

class RecentCounter {

    private LinkedList<Integer> requestTimeList;

    public RecentCounter() {
        requestTimeList = new LinkedList<>();
    }

    public int ping(int t) {

        requestTimeList.addLast(t);
        while (requestTimeList.getFirst() < t - 3000) {
            requestTimeList.removeFirst();
        }
        int lowerBound = findLowerBound(t - 3000);
        int upperBound = findUpperBound(t);
        return upperBound - lowerBound + 1;
    }

    private int findUpperBound(int key) {

        int low = 0;
        int high = requestTimeList.size() - 1;
        int upperBound = -1;
        while (low <= high) {
            int mid = (low) + (high - low) / 2;
            if (requestTimeList.get(mid) <= key) {
                upperBound = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return upperBound;
    }

    private int findLowerBound(int key) {

        int low = 0;
        int high = requestTimeList.size() - 1;
        int lowerBound = -1;
        while (low <= high) {
            int mid = (low) + (high - low) / 2;
            if (requestTimeList.get(mid) >= key) {
                lowerBound = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return lowerBound;
    }
}