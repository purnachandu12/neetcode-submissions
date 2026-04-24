class Solution {
    public int rob(int[] nums) {
        if(nums.length==1){
            return nums[0];
        }
        int[] nums1=new int[nums.length-1];
        int[] nums2=new int[nums.length-1];
        for(int i=0;i<nums1.length;i++){
            nums1[i]=nums[i];
        }
        for(int j=0;j<nums2.length;j++){
            nums2[j]=nums[j+1];
        }
        int[] dp1=new int[nums.length-1];
        int[] dp2=new int[nums.length-1];
        for(int i=0;i<dp1.length;i++){
            dp1[i]=-1;
            dp2[i]=-1;
        }
        return Math.max(solve(nums1,0,dp1),solve(nums2,0,dp2));
    }
    public static int solve(int[] nums,int index,int[] dp){
        if(index>=nums.length){
            return 0;
        }
        if(dp[index]!=-1){
            return dp[index];
        }
        int take=nums[index]+solve(nums,index+2,dp);
        int leave=solve(nums,index+1,dp);
        return dp[index]=Math.max(take,leave);
    }
}
