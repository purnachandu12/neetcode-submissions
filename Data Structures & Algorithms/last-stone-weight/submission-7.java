class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> queue=new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0;i<stones.length;i++){
            queue.add(stones[i]);
        }
        while(queue.isEmpty()!=true && queue.size()>1){
            int val1=queue.remove();
            int val2=queue.remove();
            if(val1==val2){
                continue;
            }
            else{
                int temp=Math.abs(val1-val2);
                queue.add(temp);
            }
        }
        if(queue.size()==0){
            return 0;
        }
        return queue.peek();
    }
}
