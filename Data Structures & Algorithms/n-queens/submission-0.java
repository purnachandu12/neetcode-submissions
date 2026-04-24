class Solution {
    public List<List<String>> solveNQueens(int n) {
        char[][] board=new char[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                board[i][j]='.';
            }
        }
        ArrayList<List<String>> result=new ArrayList<>();
        solve(board,0,result);
        return result;
    }
    public static void solve(char[][] board,int row,ArrayList<List<String>> result){
        if(row==board.length){
            ArrayList<String> a1=new ArrayList<>();
            for (char[] ro : board) {
                a1.add(new String(ro));
            }
            result.add(a1);
            return;
        }
        for(int col=0;col<board.length;col++){
            if(isvalid(board,row,col)==true){
                board[row][col]='Q';
                solve(board,row+1,result);
                board[row][col]='.';
            }
        }
    }
    public static boolean isvalid(char[][] board,int row,int col){
         for (int i = row - 1; i >= 0; i--) {
            if (board[i][col] == 'Q') return false;
        }
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') return false;
        }
        for (int i = row - 1, j = col + 1; i >= 0 && j < board.length; i--, j++) {
            if (board[i][j] == 'Q') return false;
        }
        return true;
    }
}
