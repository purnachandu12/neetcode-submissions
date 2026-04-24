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
        ListNode slow=head;
        ListNode fast=head.next;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        System.out.println(slow.val);
        ListNode current=slow.next;
        ListNode next=null;
        ListNode prev=null;
        slow.next=null;
        while(current!=null){
            next=current.next;
            current.next=prev;
            prev=current;
            current=next;
        }
        ListNode start=head;
        ListNode end=prev;
        while(end!=null){
            ListNode temp1=start.next;
            ListNode temp2=end.next;
            start.next=end;
            end.next=temp1;
            start=temp1;
            end=temp2;
        }
        return;
    }
}
