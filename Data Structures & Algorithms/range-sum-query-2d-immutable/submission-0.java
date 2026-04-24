class NumMatrix {

    int[][] mat;

    public NumMatrix(int[][] matrix) {
        mat=new int[matrix.length][matrix[0].length];
        for(int i=0;i<matrix.length;i++){
            int count=0;
            count=matrix[i][0];
            mat[i][0]=count;
            for(int j=1;j<matrix[0].length;j++){
                mat[i][j]=matrix[i][j]+count;
                count=mat[i][j];
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sum=0;
        for(int i=row1;i<=row2;i++){
            if(col1-1>=0){
                sum=sum+mat[i][col2]-mat[i][col1-1];
            }
            else{
                sum=sum+mat[i][col2];
            }
        }
        return sum;
    }

}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */