class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] dp=new int[text1.length()+1][text2.length()+1];
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                dp[i][j]=-1;
            }
        }
        return solve(text1,text2,0,0,dp);
    }
    public static int solve(String text1,String text2,int index1,int index2,int[][] dp){
       if(index1==text1.length() || index2==text2.length()){
        return 0;
       }
       if(dp[index1][index2]!=-1){
        return dp[index1][index2];
       }
       if(text1.charAt(index1)==text2.charAt(index2)){
        return dp[index1][index2]=1+solve(text1,text2,index1+1,index2+1,dp);
       }
       else{
        return dp[index1][index2]=Math.max(solve(text1,text2,index1+1,index2,dp),solve(text1,text2,index1,index2+1,dp));
       }
    }
}
