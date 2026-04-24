class Solution {
    public boolean canPartition(int[] nums) {
        int total=0;
        for(int i=0;i<nums.length;i++){
            total=total+nums[i];
        }
        return solve(nums,total,0,total);
    }
    public static boolean solve(int[] nums,int total,int index,int target){
        if(target-total==total){
            return true;
        }
        if(index>=nums.length){
            return false;
        }
        boolean take=solve(nums,total-nums[index],index+1,target);
        boolean skip=solve(nums,total,index+1,target);
        return take||skip;
    }
}
