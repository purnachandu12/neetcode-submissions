class Solution {
    public int orangesRotting(int[][] grid) {
        int rows=grid.length;
        int cols=grid[0].length;
        int[][] visited=new int[grid.length][grid[0].length];
        Queue<pair> queue=new LinkedList<>();
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==2){
                    visited[i][j]=1;
                    queue.add(new pair(i,j,0));
                }
            }
        }
        int max_time=0;
        int count=0;
        while(queue.isEmpty()!=true){
            pair current=queue.remove();
            int row=current.row;
            int col=current.col;
            int time=current.time;
            max_time=Math.max(max_time,time);
            int[] del_row={-1,0,1,0};
            int[] del_col={0,1,0,-1};
            for(int i=0;i<4;i++){
                int new_row=row+del_row[i];
                int new_col=col+del_col[i];
                if(new_row>=0 && new_row<rows && new_col>=0 && new_col<cols && grid[new_row][new_col]==1 && visited[new_row][new_col]!=1){
                    visited[new_row][new_col]=1;
                    queue.add(new pair(new_row,new_col,time+1));
                    count++;
                }
            }
        }
        System.out.println(count);
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1){
                    count--;
                }
            }
        }
        if(count==0){
            return max_time;
        }
        else{
            return -1;
        }
    }
}
class pair{
    int row;
    int col;
    int time;
    public pair(int row,int col,int time){
        this.row=row;
        this.col=col;
        this.time=time;
    }
}
