package org.competetive.programming.Leetcode;

public class Solution2181 {

    ListNode prevNode = null;

    public ListNode mergeNodes(ListNode head) {

        int newNodeValue = 0;
        ListNode head1 = head;
        ListNode head2 = head;
        head = head.next;
        while (head != null) {
            if (head.val == 0) {
                head1 = update(newNodeValue, head1);
                newNodeValue = 0;
            } else {
                newNodeValue += head.val;
            }
            head = head.next;
        }
        prevNode.next = null;
        return head2;
    }

    private ListNode update(int newNodeValue, ListNode head) {

        head.val = newNodeValue;
        prevNode = head;
        head = head.next;
        return head;
    }
}


class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
