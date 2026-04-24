class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
       PriorityQueue<Integer> maxheap=new PriorityQueue<>(Collections.reverseOrder());
       int i=0;
       int j=0;
       int max=Integer.MIN_VALUE;
       ArrayList<Integer> a1=new ArrayList<>();
       while(j<nums.length){
        maxheap.add(nums[j]);
        if(j-i+1==k){
            a1.add(maxheap.peek());
            maxheap.remove(nums[i]);
            i++;
        }
        j++;
        }
       int[] result=new int[a1.size()];
       for(int m=0;m<a1.size();m++){
        result[m]=a1.get(m);
       }
       return result;
}
}
