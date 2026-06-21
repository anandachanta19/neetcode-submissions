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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
         ListNode head;
        ListNode current;
        if (list1 == null && list2 == null) {
            return null;
        } else if (list1 == null) {
            return list2;
        } else if (list2 == null) {
            return list1;
        }
        if (list1.val >= list2.val) {
            head = list2;
            current = head;
            list2 = list2.next;
        } else {
            head = list1;
            current = head;
            list1 = list1.next;
        }
        while (list1 != null && list2 != null) {
            if (list1.val >= list2.val) {
                current.next = list2;
                list2 = list2.next;
            } else {
                current.next = list1;
                list1 = list1.next;
            }
            current = current.next;
        }
        if (list1 == null && list2 != null) {
            while (list2 != null) {
                current.next = list2;
                list2 = list2.next;
                current = current.next;
            }
        } else if (list1 != null && list2 == null) {
            while (list1 != null) {
                current.next = list1;
                list1 = list1.next;
                current = current.next;
            }
        }
        return head;
    }
}