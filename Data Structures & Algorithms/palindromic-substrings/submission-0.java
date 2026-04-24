class Solution {
    public int countSubstrings(String s) {
        ArrayList<String> result=new ArrayList<>();
        HashSet<String> set=new HashSet<>();
        Solution s1=new Solution();
        s1.solve(s,0,result,set);
        
        return result.size();
    }
    public void solve(String s,int index,ArrayList<String> result,HashSet<String> set){
        for(int i=index;i<s.length();i++){
            String s1=s.substring(index,i+1);
            int value=i+1;
            if(palindrome(s1)==true && set.add("the"+index+"col"+value)==true){
                result.add(s1);
                solve(s,i+1,result,set);
            }
        }
    }
    public static boolean palindrome(String sub){
        if(sub.length()==1){
            return true;
        }
        for(int i=0;i<sub.length()/2;i++){
            int start=i;
            int end=sub.length()-i-1;
            if(sub.charAt(start)!=sub.charAt(end)){
                return false;
            }
        }
        return true;
    }
}
class pair{
    int start;
    int end;
    public pair(int start,int end){
        this.start=start;
        this.end=end;
    }
}
