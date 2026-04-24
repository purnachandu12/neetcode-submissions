class LRUCache {
    HashMap<Integer,Node> map;
    int capacity;
    Node head;
    Node tail;
    public LRUCache(int capacity) {
        this.capacity=capacity;
        this.map=new HashMap<>();
        this.head=new Node(0,0);
        this.tail=new Node(0,0);
        this.head.next=this.tail;
        this.tail.prev=this.head;
    }
    public void remove(Node node){
        node.prev.next=node.next;
        node.next.prev=node.prev;
    }
    public void add(Node node){
        node.next=head.next;
        head.next.prev=node;
        node.prev=head;
        head.next=node;
    }
    public int get(int key) {
        if(map.containsKey(key)!=true){
            return -1;
        }
        else{
            Node node=map.get(key);
            remove(node);
            add(node);
            return node.value;
        }
    }
    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node node=map.get(key);
            node.value=value;
            remove(node);
            add(node);
        }
        else{
            if(map.size()==capacity){
                Node node=tail.prev;
                map.remove(node.key);
                remove(node);
            }
            Node node=new Node(key,value);
            map.put(key,node);
            add(node);
        }
    }
}
class Node{
    int value;
    int key;
    Node next;
    Node prev;
    public Node(int key,int value){
        this.value=value;
        this.key=key;
    }
}
