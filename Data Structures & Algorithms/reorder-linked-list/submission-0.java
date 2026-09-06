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
    public void reorderList(ListNode head) {
        ListNode fast = head;
        ListNode slow= head;
        ListNode prev = null;

        while(fast!=null && fast.next!=null)
        {
            prev=slow;
            slow=slow.next;
            fast=fast.next.next;
        }

        if(fast!=null)
        {
            prev=slow;
            slow=slow.next;
        }
        
        ListNode temp =null;
        while(slow!=null)
        {
            ListNode nextNode = slow.next;
            slow.next = temp;
            temp=slow;
            slow=nextNode;
        }

        prev.next = null;
        ListNode curr =head;

        while(temp!=null)
        {
            ListNode currNext = curr.next;
            ListNode tempNext = temp.next;

            curr.next=temp;
            temp.next=currNext;
            curr=currNext;
            temp=tempNext;
        }

    }
}
