class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int total_gas=0;
        int total_cost=0;
        for(int i=0;i<gas.length;i++){
            total_gas=total_gas+gas[i];
        }
        for(int i=0;i<cost.length;i++){
            total_cost=total_cost+cost[i];
        }
        if(total_cost>total_gas){
            return -1;
        }
        int total=0;
        int res=0;
        for(int i=0;i<gas.length;i++){
            total=total+(gas[i]-cost[i]);
            if(total<0){
                total=0;
                res=i+1;
            }
        }
        return res;
    }
}
