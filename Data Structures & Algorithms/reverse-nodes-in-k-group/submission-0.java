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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode curr = head;
        int n =0;

        while(curr!=null)
        {
            curr=curr.next;
            n++;
        }

        if(n<k)
            return head;
        
        n=n/k;

        curr=head;
        ListNode resultHead = null;
        ListNode prevGroupTail = null;

        while(n>0)
        {
            ListNode groupHead = curr;
            ListNode prev = null;

            for(int i=0;i<k;i++)
            {
                ListNode nextNode = curr.next;
                curr.next=prev;
                prev=curr;
                curr=nextNode;
            }
                        // prev is the new head of this reversed group
            if (resultHead == null)
                resultHead = prev;

            // Connect previous group to current group
            if (prevGroupTail != null)
                prevGroupTail.next = prev;

            // groupHead is now the tail of this group
            prevGroupTail = groupHead;

            n--;
        }
        
        // Connect last reversed group to remaining nodes
        prevGroupTail.next = curr;

        return resultHead;
    }
}
