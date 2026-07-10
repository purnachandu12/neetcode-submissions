class Solution {
    public int integerBreak(int n) {
        int[] memo=new int[n+1];
        Arrays.fill(memo,-1);
        return solve(n,memo,false);
    }
    public int solve(int n,int[] memo,boolean falg){
        if(n==0){
            if(falg==true){
                return 1;
            }
            return -1;
        }
        if(memo[n]!=-1){
            return memo[n];
        }
        int max=-1;
        for(int i=1;i<=n;i++){
            if(n-i==0 && falg==false){
                continue;
            }
            int pro=i*solve(n-i,memo,true);
            max=Math.max(max,pro);
        }
        return memo[n]=max;
    }
}