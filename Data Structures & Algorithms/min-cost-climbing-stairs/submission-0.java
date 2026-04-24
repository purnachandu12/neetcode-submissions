class Solution {
    public int minCostClimbingStairs(int[] cost) {
        return Math.min(solve(0,cost),solve(1,cost));
    }
    public static int solve(int index,int[] cost){
        if(index>=cost.length){
            return 0;
        }
        int take1=cost[index]+solve(index+1,cost);
        int take2=cost[index]+solve(index+2,cost);
        return Math.min(take1,take2);
    }
}
