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
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null||head.next==null||k==0){return head;}
        int l=1;
        ListNode tail=head;
        while(tail.next!=null){
            tail=tail.next;
            l++;
        }
        k=k%l;
        if(k==0){
            return head;
        }
        tail.next=head;
        ListNode newtail=head;
        for(int i=0;i<(l-k-1);i++){
            newtail=newtail.next;
        }
        ListNode newhead=newtail.next;
        newtail.next=null;
        return newhead;

    }
    }