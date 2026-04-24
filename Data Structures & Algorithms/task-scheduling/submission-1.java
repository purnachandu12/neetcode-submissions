class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq=new int[26];
        for(int i=0;i<tasks.length;i++){
            freq[tasks[i]-'A']++;
        }
        PriorityQueue<Integer> maxheap=new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0;i<freq.length;i++){
            if(freq[i]!=0){
                maxheap.add(freq[i]);
            }
        }
        int time=0;
        Queue<pair> queue=new LinkedList<>();
        while(maxheap.isEmpty()!=true || queue.isEmpty()!=true){
            time++;
             if(maxheap.isEmpty()!=true){
            int value=maxheap.remove();
            value--;
            if(value!=0){
            queue.add(new pair(time+n,value));
            }
            }
            if(queue.isEmpty()!=true){
                if(queue.peek().time==time){
                    pair current=queue.remove();
                    maxheap.add(current.value);
                }
            }
        }
        return time;
    }
}
class pair{
    int time;
    int value;
    public pair(int time,int value){
        this.time=time;
        this.value=value;
    }
}
