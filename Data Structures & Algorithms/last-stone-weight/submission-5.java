class Solution {
    public int lastStoneWeight(int[] stones) {
    if(stones.length==0){
        return 0;
    }
       PriorityQueue<Integer> max=new PriorityQueue<>(Collections.reverseOrder());
       for(int i=0;i<stones.length;i++){
        max.add(stones[i]);
       }
       while(max.size()>1){
        int value1=max.poll();
        int value2=max.poll();
        if(value1>value2){
            max.add(value1-value2);
        }
        else if(value1==value2){
            continue;
        }
       }
       if(max.size()==0){
        return 0;
       }
       else{
         return max.poll();
       }
    }
}
