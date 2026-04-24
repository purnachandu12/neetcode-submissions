class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int rows=heights.length;
        int cols=heights[0].length;
        Solution s1=new Solution();
        int[][] visited=new int[rows][cols];
        int[][] visited2=new int[rows][cols];
        //pacific ocean
        Queue<pair> queue=new LinkedList<>();
        for(int i=0;i<heights.length;i++){
            for(int j=0;j<heights[0].length;j++){
                if(i==0 || j==0){
                    visited[i][j]=1;
                    queue.add(new pair(i,j));
                }
            }
        }
        s1.dfs(heights,visited,queue);
        //atlantic ocean
        Queue<pair> queue1=new LinkedList<>();
        for(int i=0;i<heights.length;i++){
            for(int j=0;j<heights[0].length;j++){
                if(i==rows-1 || j==cols-1){
                    visited2[i][j]=1;
                    queue1.add(new pair(i,j));
                }
            }
        }
        s1.dfs(heights,visited2,queue1);
        ArrayList<List<Integer>> list=new ArrayList<>();
        for(int i=0;i<visited.length;i++){
            for(int j=0;j<visited[0].length;j++){
                if(visited[i][j]==visited2[i][j]){
                    if(visited[i][j]==1){
                    ArrayList<Integer> temp=new ArrayList<>();
                    temp.add(i);
                    temp.add(j);
                    list.add(temp);
                    }
                }
            }
        }
        return list;
    }
    public  void dfs(int[][] heights,int[][] visited,Queue<pair> queue){
        int rows=heights.length;
        int cols=heights[0].length;
        while(queue.isEmpty()!=true){
            pair current=queue.remove();
            int row=current.row;
            int col=current.col;
            int[] del_row={-1,0,1,0};
            int[] del_col={0,1,0,-1};
            for(int i=0;i<4;i++){
                int new_row=row+del_row[i];
                int new_col=col+del_col[i];
                if(new_row>=0 && new_row<rows && new_col>=0 && new_col<cols && visited[new_row][new_col]!=1){
                    if(heights[new_row][new_col]>=heights[row][col]){
                        queue.add(new pair(new_row,new_col));
                        visited[new_row][new_col]=1;
                    }
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
