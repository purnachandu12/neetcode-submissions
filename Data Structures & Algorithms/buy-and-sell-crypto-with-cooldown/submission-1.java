class Solution {
    public int maxProfit(int[] prices) {
        boolean buy=false;
        return solve(prices,0,buy);
    }
    public static int solve(int[] prices,int index,boolean buy){
        if(index>=prices.length){
            return 0;
        }
        if(buy==true){
            int sell=solve(prices,index+2,false)+prices[index];
            int cool=solve(prices,index+1,true);
            return Math.max(sell,cool);
        }
        else{
            int buying=solve(prices,index+1,true)-prices[index];
            int cool=solve(prices,index+1,false);
            return Math.max(buying,cool);
        }
    }
}
