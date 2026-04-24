class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int global_max=nums[0];
        int global_min=nums[0];
        int current_max=0;
        int current_min=0;
        int total=0;
        for(int i=0;i<nums.length;i++){
            total=total+nums[i];
            current_max=current_max+nums[i];
            global_max=Math.max(current_max,global_max);
            if(current_max<0){
                current_max=0;
            }
            current_min=current_min+nums[i];
            global_min=Math.min(current_min,global_min);
            if(current_min>0){
                current_min=0;
            }
        }
        System.out.println(global_max+" "+global_min+" "+total);
        if(global_min==total){
            return global_max;
        }
        return Math.max(global_max,total-global_min);
    }
}