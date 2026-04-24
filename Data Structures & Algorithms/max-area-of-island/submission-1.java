class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int row=grid.length;
        int col=grid[0].length;
        boolean[][] visited=new boolean[row][col];
        int max=0;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(visited[i][j]!=true && grid[i][j]==1){
                max=Math.max(max,bfs(grid,i,j,visited));
                }
            }
        }
        return max;
    }
    public static int bfs(int[][] grid,int i,int j,boolean[][] visited){
        Queue<pair> queue=new LinkedList<>();
        int count=1;
        queue.add(new pair(i,j));
        visited[i][j]=true;
        while(queue.isEmpty()!=true){
            pair current=queue.remove();
            int row=current.row;
            int col=current.col;
            if(row+1>=0 && row+1<grid.length && visited[row+1][col]!=true && grid[row+1][col]==1){
                queue.add(new pair(row+1,col));
                visited[row+1][col]=true;
                count++;
            }
            if(row-1>=0 && row-1<grid.length && visited[row-1][col]!=true && grid[row-1][col]==1){
                queue.add(new pair(row-1,col));
                visited[row-1][col]=true;
                count++;
            }
            if(col+1>=0 && col+1<grid[0].length && visited[row][col+1]!=true && grid[row][col+1]==1){
                queue.add(new pair(row,col+1));
                visited[row][col+1]=true;
                count++;
            }
            if(col-1>=0 && col-1<grid[0].length && visited[row][col-1]!=true && grid[row][col-1]==1){
                queue.add(new pair(row,col-1));
                visited[row][col-1]=true;
                count++;
            }
        }
        return count;
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
