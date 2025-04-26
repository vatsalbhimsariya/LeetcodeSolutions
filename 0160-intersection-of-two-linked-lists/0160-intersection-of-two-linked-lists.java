/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;

        ListNode pointerA = headA;
        ListNode pointerB = headB;

        // Traverse both lists. When pointerA reaches the end of listA, start it from headB.
        // When pointerB reaches the end of listB, start it from headA.
        // The second time both pointers traverse will equalize their distance to the intersection point.
        while (pointerA != pointerB) {
            // If pointerA reaches the end of listA, restart from headB.
            pointerA = (pointerA == null) ? headB : pointerA.next;
            // If pointerB reaches the end of listB, restart from headA.
            pointerB = (pointerB == null) ? headA : pointerB.next;
        }

        // Either both pointers meet at the intersection or they both end at null.
        return pointerA;  
    }
}