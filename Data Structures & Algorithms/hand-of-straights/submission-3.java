class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if(hand.length%groupSize!=0){
            return false;
        }
        int no=hand.length/groupSize;
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<hand.length;i++){
            if(map.containsKey(hand[i])!=true){
                map.put(hand[i],1);
            }
            else{
                int value=map.get(hand[i]);
                value++;
                map.put(hand[i],value);
            }
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>(map.keySet());
        while(pq.isEmpty()!=true){
            int first=pq.peek();
            for(int i=0;i<groupSize;i++){
                int value=first+i;
                if(map.containsKey(value)==false){
                    return false;
                }
                int count=map.get(value);
                count--;
                map.put(value,count);
                if(count==0){
                    if(pq.peek()!=value){
                        return false;
                    }
                    else{
                        pq.poll();
                    }
                }
            }
        }
        return true;
    }
}