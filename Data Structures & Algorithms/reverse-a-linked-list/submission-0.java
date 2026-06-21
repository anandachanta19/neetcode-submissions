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
    public ListNode reverseList(ListNode head) {
        ListNode tail = head;
        if (head == null) {
            return head;
        }
        ListNode temp = head.next;
        while (temp != null) {
            ListNode temp2 = temp.next;
            temp.next = head;
            head = temp;
            temp = temp2;
        }
        tail.next = null;
        return head;
    }
}
