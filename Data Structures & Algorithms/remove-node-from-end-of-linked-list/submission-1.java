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
        int length=0;

        ListNode temp=head;

        while(temp!=null)
        {
            length++;
            temp=temp.next;
        }
        int k=length-n;

        temp=head;
        if(k==0)
            return head.next;
       
        while(k>1)
        {
            temp=temp.next;
            k--;
        }

        ListNode next=temp.next;

        temp.next=next.next;
        return head;
    }
}
