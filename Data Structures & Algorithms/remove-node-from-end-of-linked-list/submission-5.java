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
        int size=0;
        ListNode current=head;
        while(current!=null){
            size++;
            current=current.next;
        }
        if(size==0 || size==1){
            return null;
        }
        if(size==n){
            ListNode current1=head;
            current1=current1.next;
            head=current1;
            return head;
        }
        System.out.println(size);
        size=size-n;
        System.out.println(size);
        current=head;
        for(int i=0;i<size-1;i++){
            current=current.next;
        }
        ListNode temp=current.next;
        current.next=current.next.next;
        temp.next=null;
        return head;
    }
}
