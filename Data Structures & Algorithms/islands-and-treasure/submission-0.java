class Solution {
    public void islandsAndTreasure(int[][] grid) {
        int rows=grid.length;
        int cols=grid[0].length;
        Queue<pair> queue=new LinkedList<>();
        int[][] distance=new int[rows][cols];
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(grid[i][j]==0){
                    queue.add(new pair(i,j,0));
                }
            }
        }
        while(queue.isEmpty()!=true){
            pair current=queue.remove();
            int row=current.row;
            int col=current.col;
            int dist=current.distance;
            int[] del_row={-1,0,1,0};
            int[] del_col={0,1,0,-1};
            for(int i=0;i<4;i++){
                int new_row=row+del_row[i];
                int new_col=col+del_col[i];
                if(new_row>=0 && new_row<rows && new_col>=0 && new_col<cols && grid[new_row][new_col]==Integer.MAX_VALUE){
                    if(grid[new_row][new_col]>dist+1){
                        grid[new_row][new_col]=dist+1;
                        queue.add(new pair(new_row,new_col,dist+1));
                    }
                }
            }
        }
    }
}
class pair{
    int row;
    int col;
    int distance;
    public pair(int row,int col,int distance){
        this.row=row;
        this.col=col;
        this.distance=distance;
    }
}
