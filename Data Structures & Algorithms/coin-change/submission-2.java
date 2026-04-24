class Solution {
    public int coinChange(int[] coins, int amount) {
        int value=solve(coins,0,amount);
        if(value==(int)1e9){
            return -1;
        }
        return value;
    }
    public static int solve(int[] coins,int index,int amount){
        if(amount==0){
            return 0;
        }
        if(index==coins.length){
            return (int)1e9;
        }
        if(amount>=coins[index]){
            int take=1+solve(coins,index,amount-coins[index]);
            int skip=solve(coins,index+1,amount);
            return Math.min(take,skip);
        }
        return solve(coins,index+1,amount);
    }
}
