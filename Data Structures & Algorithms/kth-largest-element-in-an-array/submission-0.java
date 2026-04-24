class Solution {
    public int findKthLargest(int[] nums, int k) {
        if(nums.length==0){
            return 0;
        }
        PriorityQueue<Integer> minheap=new PriorityQueue<>();
        for(int i=0;i<nums.length;i++){
            minheap.add(nums[i]);
            if(minheap.size()>k){
                minheap.remove();
            }
        }
        return minheap.peek();
    }
}
