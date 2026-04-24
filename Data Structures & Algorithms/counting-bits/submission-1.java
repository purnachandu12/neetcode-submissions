class Solution {
    public int[] countBits(int n) {
        if(n==0){
            int[] num=new int[1];
            num[0]=0;
            return num;
        }
        int[] dp=new int[n+1];
        dp[0]=0;
        dp[1]=1;
        for(int i=2;i<=n;i++){
            dp[i]=dp[i/2]+(i&1);
        }
        return dp;
    }
}
