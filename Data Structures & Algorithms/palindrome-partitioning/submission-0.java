class Solution{
    public  ArrayList<List<String>> partition(String s) {
        ArrayList<List<String>> result=new ArrayList<>();
        ArrayList<String> temp=new ArrayList<>();
        helper(s,0,result,temp);
        return result;
    }
    public static void helper(String s,int index,ArrayList<List<String>> result,  ArrayList<String> temp){
        if(index==s.length()){
            result.add(new ArrayList<String>(temp));
            return;
        }
        for(int i=index;i<s.length();i++){
            String s1=s.substring(index,i+1);
            if(palindrome(s1)==true){
                temp.add(s1);
                helper(s,i+1,result,temp);
                temp.remove(temp.size()-1);
            }
        }
    }
    public static boolean palindrome(String s){
        for(int i=0;i<s.length()/2;i++){
            int start=i;
            int end=s.length()-1-i;
            if(s.charAt(start)!=s.charAt(end)){
                return false;
            }
        }
        return true;
    }
}