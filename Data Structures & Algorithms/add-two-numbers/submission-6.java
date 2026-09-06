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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        ListNode prev = new ListNode(0);
        ListNode head = prev;
        int carry=0;

        while(l1!=null && l2!=null)
        {
            int data = carry+l1.val+l2.val;
            ListNode newNode = new ListNode(data%10);
            carry=data/10;

            prev.next = newNode;
            prev=newNode;
            
            l1=l1.next;
            l2=l2.next;
        }

        while(l1!=null)
        {
            int data = carry+l1.val;
            ListNode newNode = new ListNode(data%10);
            carry=data/10;

            prev.next = newNode;
            prev=newNode;
            
            l1=l1.next;
        }
        while(l2!=null)
        {
            int data = carry+l2.val;
            ListNode newNode = new ListNode(data%10);
            carry=data/10;

            prev.next = newNode;
            prev=newNode;
            
            l2=l2.next;
        }

        if(carry>0)
        {
            ListNode newNode = new ListNode(carry);
            prev.next = newNode;
            prev=newNode;  
        }
           return head.next;
    }
}
