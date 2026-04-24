class Solution {

    public String encode(List<String> strs) {
        String s="";
        for(int i=0;i<strs.size();i++){
            String s1=strs.get(i);
            int length=s1.length();
            s=s+length+"#"+s1;
        }
        return s;
    }

    public List<String> decode(String str) {
        ArrayList<String> a1=new ArrayList<>();
        int i=0;
        while(i<str.length()){
            String length="";
            while(str.charAt(i)!='#'){
                length=length+str.charAt(i)+"";
                i++;
            }
            int len=Integer.parseInt(length);
            String sub=str.substring(i+1,i+len+1);
            a1.add(sub);
            i=i+len+1;
        }
        return a1;
    }
}
