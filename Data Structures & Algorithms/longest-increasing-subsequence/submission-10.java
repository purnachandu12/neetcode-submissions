class Solution {
    public int lengthOfLIS(int[] nums) {
        int[][] dp=new int[nums.length][nums.length+1];
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                dp[i][j]=-1;
            }
        }
        return solve(nums,0,-1,dp);
    }
    public static int solve(int[] nums,int index,int prev,int[][] dp){
        if(index==nums.length){
            return 0;
        }
        if(dp[index][prev+1]!=-1){
            return dp[index][prev+1];
        }
        int not_take=solve(nums,index+1,prev,dp);
        int take=0;
        if(prev==-1 || nums[index]>nums[prev]){
            take=1+solve(nums,index+1,index,dp);
        }
        return dp[index][prev+1]=Math.max(take,not_take);
    }
}
