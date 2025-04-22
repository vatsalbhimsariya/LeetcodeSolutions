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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // Create a dummy node to simplify the merging process
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        // Merge the two lists
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                current.next = l1; // Add l1 node to the merged list
                l1 = l1.next;      // Move l1 pointer
            } else {
                current.next = l2; // Add l2 node to the merged list
                l2 = l2.next;      // Move l2 pointer
            }
            current = current.next; // Move the current pointer
        }

        // If one of the lists is not exhausted, add the rest of the list
        if (l1 != null) {
            current.next = l1;
        } else if (l2 != null) {
            current.next = l2;
        }

        // Return the merged list (skipping the dummy node)
        return dummy.next;
    }
}
