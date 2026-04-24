class Solution {
    public int minDistance(String word1, String word2) {
        return solve(word1,word2,0,0);
    }
    public static int solve(String s1,String s2,int index1,int index2){
        if(index2==s2.length()){
            return s1.length()-index1;
        }
        if(index1==s1.length()){
            return s2.length()-index2;
        }
        if(s1.charAt(index1)==s2.charAt(index2)){
            return solve(s1,s2,index1+1,index2+1);
        }
        else{
            int insert=1+solve(s1,s2,index1,index2+1);
            int delete=1+solve(s1,s2,index1+1,index2);
            int replace=1+solve(s1,s2,index1+1,index2+1);
            return Math.min(Math.min(insert,delete),replace);
        }
    }
}
