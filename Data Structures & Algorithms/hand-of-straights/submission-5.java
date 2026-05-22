class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        int groups=hand.length/groupSize;
        if(hand.length%groupSize!=0){
            return false;
        }
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<hand.length;i++){
            if(map.containsKey(hand[i])!=true){
                map.put(hand[i],1);
            }
            else{
                int count=map.get(hand[i]);
                count++;
                map.put(hand[i],count);
            }
        }
        PriorityQueue<Integer> queue=new PriorityQueue<>();
        for(Map.Entry<Integer,Integer> entry:map.entrySet()){
            queue.add(entry.getKey());
        }
        for(int i=0;i<groups;i++){
            int value=queue.peek();
            for(int j=0;j<groupSize;j++){
                int temp=value+j;
                if(map.containsKey(temp)!=true){
                    return false;
                }
                int count=map.get(temp);
                count--;
                map.put(temp,count);
                if(count==0){
                    if(queue.peek()!=temp){
                        return false;
                    }
                    map.remove(temp);
                    queue.remove();
                }
            }
        }
        return true;
    }
}
