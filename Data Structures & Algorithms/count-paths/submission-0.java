class Solution {
    public int uniquePaths(int m, int n) {
        int count[]=new int[1];
        count[0] =0;
         solve(m,n,0,0,count);       
         return count[0];
    }
    public static int solve(int m,int n,int index1,int index2,int[] count){
        if(index1==m-1 && index2==n-1){
            return count[0]++;
        }
        if(index1<0 || index1>=m || index2<0 || index2>=n){
            return 0;
        }
        int down=solve(m,n,index1+1,index2,count);
        int right=solve(m,n,index1,index2+1,count);
        return down+right;
    }
}
