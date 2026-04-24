class Solution {
    public int coinChange(int[] coins, int amount) {
        int ans=solve(coins,amount,coins.length);
        if(ans==Integer.MAX_VALUE-1){
            return -1;
        }
        else{
            return ans;
        }
    }
    public static int solve(int[] coins,int amount,int index){
        if(amount==0){
            return 0;
        }
        if(index==0){
            return Integer.MAX_VALUE-1;
        }
        if(coins[index-1]<=amount){
            int take=1+solve(coins,amount-coins[index-1],index);
            int skip=solve(coins,amount,index-1);
            return Math.min(take,skip);
        }
        else{
        return solve(coins,amount,index-1);
        }
    }
}
