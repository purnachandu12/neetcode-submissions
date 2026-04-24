public class Solution {
    public boolean exist(char[][] board, String word) {
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(solve(board,i,j,word,0)==true){
                    return true;
                }
            }
        }
    return false;
    }
    public static boolean solve(char[][] board,int i,int j,String word,int index){
        if(index==word.length()){
            return true;
        }
        if(i<0 || i>=board.length || j<0 || j>=board[0].length){
            return false;
        }
        if(word.charAt(index)!=board[i][j]){
            return false;
        }
        char value=board[i][j];
        board[i][j]='#';
        boolean top=solve(board,i+1,j,word,index+1);
        boolean down=solve(board,i-1,j,word,index+1);
        boolean right=solve(board,i,j-1,word,index+1);
        boolean left=solve(board,i,j+1,word,index+1);
        board[i][j]=value;
        return top||down||right||left;
    }
}
