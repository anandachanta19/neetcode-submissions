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
    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        ArrayList<ListNode> visited = new ArrayList<>();
        ListNode temp = head;
        while (temp != null) {
            if (visited.contains(temp)) {
                return true;
            } 
            visited.add(temp);
            temp = temp.next;
        }
        return false;
    }
}
