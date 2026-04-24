class Solution {
    public List<String> generateParenthesis(int n) {
        int open=n;
        int closed=n;
        String temp="";
        ArrayList<String> result=new ArrayList<>();
        helper(open,closed,temp,result);
        return result;
    }
    public static void helper(int open,int closed,String temp,ArrayList<String> a1){
        if(open==0 && closed==0){
            a1.add(temp);
            return;
        }
        if(open!=0){
            helper(open-1,closed,temp+"(",a1);
        }
        if(open<closed){
            helper(open,closed-1,temp+")",a1);
        }
        return;
    }
}
