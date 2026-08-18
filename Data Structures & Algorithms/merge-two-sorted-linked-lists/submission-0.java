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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode tail=null;
        ListNode head=null;

        while(list1!=null&&list2!=null)
        {
            if(list1.val<list2.val)
            {
                if(head==null)
                {
                    head=list1;
                    tail=head;
                }
                else
                {
                    tail.next=list1;
                    tail=tail.next;
                }
                list1=list1.next;
            }
            else
            {
                if(head==null)
                {
                    head=list2;
                    tail=head;
                }
                else
                {
                    tail.next=list2;
                    tail=tail.next;
                }
                list2=list2.next;
            }
        }
        while(list1!=null)
        {
               if(head==null)
                {
                    head=list1;
                    tail=list1;
                }
                else
                {
                    tail.next=list1;
                    tail=tail.next;
                }
                list1=list1.next;
        }
        while(list2!=null)
        {
               if(head==null)
                {
                    head=list2;
                    tail=head;
                }
                else
                {
                    tail.next=list2;
                    tail=tail.next;
                }
                list2=list2.next;
        }

        return head;
    }
}