class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        ArrayList<Integer> result=new ArrayList<>();
        Deque<Integer> queue=new LinkedList<>();
        int i=0;
        int j=0;
        while(j<nums.length){
            while(queue.isEmpty()!=true && queue.getLast()<nums[j]){
                queue.removeLast();
            }
            if(queue.isEmpty()){
                queue.addFirst(nums[j]);
            }
            else{
                queue.addLast(nums[j]);
            }
            if(j-i+1==k){
                result.add(queue.getFirst());
                if(queue.getFirst()==nums[i]){
                    queue.removeFirst();
                }
                i++;
            }
            j++;
        }
        int[] ans=new int[result.size()];
        for(int m=0;m<ans.length;m++){
            ans[m]=result.get(m);
        }
        return ans;
    }
}
