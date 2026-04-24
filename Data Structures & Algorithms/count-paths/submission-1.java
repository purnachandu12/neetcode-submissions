class Solution {
    public int uniquePaths(int m, int n) {
        return solve(m,n,0,0);       
    }
    public static int solve(int m,int n,int index1,int index2){
        if(index1==m-1 && index2==n-1){
            return 1;
        }
        if(index1<0 || index1>=m || index2<0 || index2>=n){
            return 0;
        }
        int down=solve(m,n,index1+1,index2);
        int right=solve(m,n,index1,index2+1);
        return down+right;
    }
}
