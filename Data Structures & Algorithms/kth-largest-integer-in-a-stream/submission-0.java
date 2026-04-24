class KthLargest {
    PriorityQueue<Integer> maxheap=new PriorityQueue<>();
    int k;
    public KthLargest(int k, int[] nums) {
        for(int i=0;i<nums.length;i++){
            maxheap.add(nums[i]);
        }
        this.k=k; 
        return;
    }
    public int add(int val) {
        maxheap.add(val);
        while(maxheap.size()>k){
            maxheap.remove();
        }
        return maxheap.peek();
    }
}
