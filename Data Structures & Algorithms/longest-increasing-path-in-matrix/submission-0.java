class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        int max=Integer.MIN_VALUE;
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                max=Math.max(solve(matrix,i,j,-1),max);
            }
        }
        return max;
    }
    public static int solve(int[][] matrix,int index1,int index2,int prev){
        if(index1==matrix.length || index2==matrix[0].length){
            return 0;
        }
        if(index1<0 || index2<0){
            return 0;
        }
        if(prev==-1 || matrix[index1][index2]>prev){
            int top=1+solve(matrix,index1-1,index2,matrix[index1][index2]);
            int bottom=1+solve(matrix,index1+1,index2,matrix[index1][index2]);
            int right=1+solve(matrix,index1,index2+1,matrix[index1][index2]);
            int left=1+solve(matrix,index1,index2-1,matrix[index1][index2]);
            return Math.max(Math.max(top,bottom),Math.max(right,left));
        }
        else{
            return 0;
        }
    }
}
