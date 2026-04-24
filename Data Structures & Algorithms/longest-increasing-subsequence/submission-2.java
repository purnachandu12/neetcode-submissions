class Solution {
    public static int[][] dp=new int[1001][1001];
    public int lengthOfLIS(int[] nums) {
        memo(dp);
        int index=0;
        int prev=-1;
        return solve(nums,index,prev,dp);
    }
    public static void memo(int[][] dp){
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp.length;j++){
                dp[i][j]=-1;
            }
        }
    }
    public static int solve(int[] nums,int index,int prev,int[][] dp){
        if(index==nums.length){
            return 0;
        }
        if(dp[index][prev+1]!=-1){
            return dp[index][prev+1];
        }
        if(prev==-1 || nums[index]>nums[prev]){
        int take=1+solve(nums,index+1,index,dp);
        int skip=solve(nums,index+1,prev,dp);
        return dp[index][prev+1]=Math.max(take,skip);
        }
        else{
            return dp[index][prev+1]=solve(nums,index+1,prev,dp);
        }
    }
}
