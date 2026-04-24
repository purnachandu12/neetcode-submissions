class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet<String> set=new HashSet<>();
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]!='.'){
                    if(set.add(i+"row"+board[i][j])==false){
                        return false;
                    }
                    if(set.add(j+"col"+board[i][j])==false){
                        return false;
                    }
                    int sub=(i/3)*3+(j/3);
                    if(set.add(sub+"sub"+board[i][j])==false){
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
