/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        //Let's create a temp node for iteration.
        ListNode temp = head;

        //Find the No of Nodes in the list or size of the list.
        int length = 1;
        while (temp.next != null) {
            length++;
            temp = temp.next;
        }
        temp = head;

        // If we want nth element from end that means (length - n)th element from start.
        int k = length - n;
        if (k == 0 && temp.next == null) {
            return null;
        } else if (k == 0) {
            return head.next;
        }

        for (int i = 1; i < k; i++) {
            temp = temp.next;
        }
        temp.next = temp.next.next;
        return head;
    }
}