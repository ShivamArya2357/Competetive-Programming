package org.competetive.programming.Leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;

public class Solution1700 {

    public static void main(String[] args) {

        int[] students = {1,1,1,0,0,1};
        int[] sandwiches = {1,0,0,0,1,1};
        int ans = countStudents(students, sandwiches);
        System.out.println(ans);
    }

    public static int countStudents(int[] students, int[] sandwiches) {

        int len = students.length;
        LinkedList<Integer> preferenceQueue = new LinkedList<>();
        Stack<Integer> sandwichStack = new Stack<>();
        int[] studentPreferenceCount = new int[2];
        Arrays.fill(studentPreferenceCount, 0);
        for (int i = 0; i < len; i++) {
            studentPreferenceCount[students[i]]++;
        }
        for (int i = 0; i < len; i++) {
            preferenceQueue.addLast(students[i]);
        }
        for (int i = len - 1; i >= 0; i--) {
            sandwichStack.add(sandwiches[i]);
        }
        while (preferenceQueue.size() > 0) {
            int preference = preferenceQueue.getFirst();
            int sandwichType = sandwichStack.peek();
            if (preference == sandwichType) {
                preferenceQueue.removeFirst();
                sandwichStack.pop();
                studentPreferenceCount[preference]--;
            } else if (studentPreferenceCount[1 - preference] == 0) {
                break;
            } else {
                preferenceQueue.removeFirst();
                preferenceQueue.addLast(preference);
            }
        }
        return preferenceQueue.size();
    }
}
