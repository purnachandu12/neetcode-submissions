class Solution {
    public int connectSticks(int[] sticks) {
        PriorityQueue<Integer> queue=new PriorityQueue<>();
        for(int i=0;i<sticks.length;i++){
            queue.add(sticks[i]);
        }
        int ans=0;
        while(queue.size()>1){
            int value1=queue.remove();
            int value2=queue.remove();
            int sum=value1+value2;
            ans=ans+sum;
            queue.add(sum);
        }
        return ans;
    }
}
