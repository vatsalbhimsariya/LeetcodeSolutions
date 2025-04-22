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
        if(head==null){return null;}
        ListNode first=head;
        for(int i=0;i<n;i++){
            if(first==null){return null;}
            first=first.next;
        }
        if(first==null){return head.next;}
        ListNode second=head;
        while(first!=null&& first.next!=null){
            second=second.next;
            first=first.next;
        }
        if(second.next!=null)second.next=second.next.next;
        return head;
    }
}