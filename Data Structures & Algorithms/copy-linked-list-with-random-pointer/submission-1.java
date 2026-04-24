/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head==null){
            return null;
        }
       HashMap<Node,Node> map=new HashMap<>();
       Node node1=new Node(head.val);
       map.put(head,node1);
       Node head1=node1;
       Node head2=node1;
       Node current=head;
       current=current.next;
       int index=0;
       while(current!=null){
        Node node2=new Node(current.val);
        map.put(current,node2);
        head2.next=node2;
        head2=head2.next;
        current=current.next;
        index++;
       }
       current=head;
       head2=head1;
       while(current!=null){
        if(current.random!=null){
        head2.random=map.get(current.random);
        }
        else{
            head2.random=null;
        }
        current=current.next;
        head2=head2.next;
       }
       return head1;
    }
}
