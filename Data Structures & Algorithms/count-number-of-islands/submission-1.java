class Solution {
    public int numIslands(char[][] grid) {
        int count=0;
        int[][] visited=new int[grid.length][grid[0].length];
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]=='1' && visited[i][j]!=1){
                    count++;
                    dfs(grid,i,j,visited);
                }
            }
        }
        return count;
    }
    public  void dfs(char[][] grid,int row,int col,int[][] visited){
        visited[row][col]=1;
        Queue<pair> queue=new LinkedList<>();
        queue.add(new pair(row,col));
        while(queue.isEmpty()!=true){
            pair current=queue.remove();
            int[] del_row={-1,0,1,0};
            int[] del_col={0,1,0,-1};
            for(int i=0;i<4;i++){
                int new_row=current.row+del_row[i];
                int new_col=current.col+del_col[i];
                if(new_row>=0 && new_row<grid.length && new_col>=0 && new_col<grid[0].length && visited[new_row][new_col]!=1 && grid[new_row][new_col]=='1'){
                    queue.add(new pair(new_row,new_col));
                    visited[new_row][new_col]=1;
                }
            }
        }
    }
}
class pair{
    int row;
    int col;
    public pair(int row,int col){
        this.row=row;
        this.col=col;
    }
}
