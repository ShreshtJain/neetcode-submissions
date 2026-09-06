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
    ListNode[] lists;
    public ListNode mergeKLists(ListNode[] lists) {
        int n =lists.length;
        this.lists=lists;
        
        mergeSort(0,n-1);
        
        return n>0?lists[n-1]:null;
    }

    void mergeSort(int left, int right)
    {
        int mid;

        if(left<right)
        {
            mid = left + (right - left) / 2;
            
            mergeSort(left,mid);
            mergeSort(mid+1,right);
            merge(left,mid+1,right);
        }
    }

    void merge(int left, int mid, int right)
    {
        ListNode left_head=lists[mid-1];
        ListNode right_head =lists[right];
        ListNode head=null;
        ListNode tail=null;

        while(left_head!=null && right_head!=null)
        {
            if(left_head.val<=right_head.val)
            {
                if(head==null)
                {
                    head=left_head;
                    tail=head;
                }
                else
                {
                    tail.next=left_head;
                    tail=tail.next;
                }
                left_head=left_head.next;
            }
            else if(right_head.val<left_head.val)
            {
                if(head==null)
                {
                    head=right_head;
                    tail=head;
                }
                else
                {
                    tail.next=right_head;
                    tail=tail.next;
                }
                right_head=right_head.next;
            }
        }

        while(left_head!=null)
        {
            if(head==null)
            {
                head=left_head;
                tail=head;
            }
            else
            {
                tail.next=left_head;
                tail=tail.next;
            }
            left_head=left_head.next;
        }

        while(right_head!=null)
        {
            if(head==null)
            {
                    head=right_head;
                    tail=head;
            }
            else
            {
                    tail.next=right_head;
                    tail=tail.next;
            }
            right_head=right_head.next;
        }

        lists[right]=head;
    }
}
