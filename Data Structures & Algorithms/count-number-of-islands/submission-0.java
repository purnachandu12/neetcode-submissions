class Solution {
    public int numIslands(char[][] grid) {
        int row=grid.length;
        int col=grid[0].length;
        boolean[][] visited=new boolean[row][col];
        int count=0;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(visited[i][j]!=true && grid[i][j]=='1'){
                dfs(grid,i,j,visited);
                count++;
                }
            }
        }
        return count;
    }
    public static void dfs(char[][] grid,int i,int j,boolean[][] visited){
        visited[i][j]=true;
        Queue<pair> queue=new LinkedList<>();
        queue.add(new pair(i,j));
        while(queue.isEmpty()!=true){
            pair current=queue.remove();
            int row=current.row;
            int col=current.col;
            if(row-1>=0 && row-1<grid.length && grid[row-1][col]=='1'  && visited[row-1][col]!=true){
                visited[row-1][col]=true;
                queue.add(new pair(row-1,col));
            }
            if(row+1>=0 && row+1<grid.length && grid[row+1][col]=='1' && visited[row+1][col]!=true){
                visited[row+1][col]=true;
                queue.add(new pair(row+1,col));
            }
            if(col-1>=0 && col-1<grid[0].length && grid[row][col-1]=='1' && visited[row][col-1]!=true){
                visited[row][col-1]=true;
                queue.add(new pair(row,col-1));
            }
             if(col+1>=0 && col+1<grid[0].length && grid[row][col+1]=='1' && visited[row][col+1]!=true){
                visited[row][col+1]=true;
                queue.add(new pair(row,col+1));
            }
        }
    }
}
static class pair{
    int row;
    int col;
    public pair(int row,int col){
        this.row=row;
        this.col=col;
    }
}
