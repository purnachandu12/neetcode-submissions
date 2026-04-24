class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet<String> set=new HashSet<>();
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                char num=board[i][j];
                if(num!='.'){
                String row="row"+i+"have"+num;
                String coloumn="coloumn"+j+"have"+num;
                String grid="box " + (i / 3) + "-" + (j / 3) + " has " + num;
                 if (!set.add(row) || !set.add(coloumn) || !set.add(grid)) {
                        return false;
                }
            }
        }
    }
    return true;
}
}
