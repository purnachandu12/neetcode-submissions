class Solution {
    public static int[] dp=new int[100+1];
    public int rob(int[] nums) {
       memo(dp);
       return solve(nums,0);
    }
    public static void memo(int[] dp){
        for(int i=0;i<101;i++){
            dp[i]=-1;
        }
    }
    public static int solve(int[] nums,int index){
        if(index>=nums.length){
            return 0;
        }
        if(dp[index]!=-1){
            return dp[index];
        }
        int take=nums[index]+solve(nums,index+2);
        int leave=solve(nums,index+1);
        return dp[index]=Math.max(take,leave);
    }
}
