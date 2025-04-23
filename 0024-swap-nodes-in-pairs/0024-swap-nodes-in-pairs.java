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
    public ListNode swapPairs(ListNode head) {
        ListNode curr=head;
        ListNode prev=null;
        if(head==null){return null;}
        if(head.next==null){return head;}

        ListNode newHead = head.next;
        while(curr!=null&& curr.next!=null)
        {
            ListNode next=curr.next;
            curr.next=next.next;
            next.next=curr;
            if(prev!=null){
                prev.next=next;}

                prev=curr;
                curr=curr.next;
        }
        return newHead;
    }
}