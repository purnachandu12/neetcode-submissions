class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows=matrix.length;
        int coloumns=matrix[0].length;
        int i=0;
        int j=rows-1;
        while(i<=j){
            int mid=(i+j)/2;
            if(matrix[mid][0]==target){
                return true;
            }
            else if(matrix[mid][0]<=target && target<=matrix[mid][coloumns-1]){
                int start=0;
                int end=coloumns-1;
                while(start<=end){
                    int mid2=(start+end)/2;
                    if(matrix[mid][mid2]==target){
                        return true;
                    }
                    else if(matrix[mid][mid2]<target){
                        start=mid2+1;
                    }
                    else{
                        end=mid2-1;
                    }
                }
                return false;
            }
            else if(matrix[mid][0]<target){
                i=mid+1;
            }
            else{
                j=mid-1;
            }
        }
        return false;
    }
}
