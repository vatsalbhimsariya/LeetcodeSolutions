/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int data;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int data) { this.data = data; }
 *     ListNode(int data, ListNode next) { this.data = data; this.next = next; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head=new ListNode(0);
        ListNode curr=head;
        int c=0;
        while(l1!=null || l2!=null || c!=0){
            int n=(l1!=null)?l1.val:0;
            int n2=(l2!=null)?l2.val:0;
            int s=n+n2+c;
            c=s/10;
            curr.next=new ListNode(s%10);
            curr=curr.next;
            if(l1!=null) l1=l1.next;
            if(l2!=null) l2=l2.next;
        }
        return head.next;
    }
}