class Solution {
    public void islandsAndTreasure(int[][] grid) {
        Queue<pair> queue=new LinkedList<>();
        boolean[][] visited=new boolean[grid.length][grid[0].length];
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==0){
                    visited[i][j]=true;
                    queue.add(new pair(i,j,0));
                }
            }
        }
        while(queue.isEmpty()!=true){
            pair current=queue.remove();
            int[] del_row={-1,0,1,0};
            int[] del_col={0,1,0,-1};
            for(int i=0;i<4;i++){
                int new_row=current.row+del_row[i];
                int new_col=current.col+del_col[i];
                if(isvalid(new_row,new_col,grid,visited)){
                    if(grid[new_row][new_col]>current.dist+1){
                    grid[new_row][new_col]=current.dist+1;
                    queue.add(new pair(new_row,new_col,current.dist+1));
                    }
                }
            }
        }
    }
    public boolean isvalid(int row,int col,int[][] grid,boolean[][] visited){
        if(row>=0 && row<grid.length && col>=0 && col<grid[0].length && grid[row][col]!=-1){
            return true;
        }
        else{
            return false;
        }
    }
}
class pair{
    int row;
    int col;
    int dist;
    public pair(int row,int col,int dist){
        this.row=row;
        this.col=col;
        this.dist=dist;
    }
}
