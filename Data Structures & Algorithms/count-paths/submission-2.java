class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp=new int[101][101];
        memo(dp);
        return solve(m,n,0,0,dp);       
    }
    public static void memo(int[][] dp){
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp.length;j++){
                dp[i][j]=-1;
            }
        }
    }
    public static int solve(int m,int n,int index1,int index2,int[][] dp){
        if(index1==m-1 && index2==n-1){
            return 1;
        }
        if(index1<0 || index1>=m || index2<0 || index2>=n){
            return 0;
        }
        if(dp[index1][index2]!=-1){
            return dp[index1][index2];
        }
        int down=solve(m,n,index1+1,index2,dp);
        int right=solve(m,n,index1,index2+1,dp);
        return dp[index1][index2]=down+right;
    }
}