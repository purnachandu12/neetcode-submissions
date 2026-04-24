class Solution {

    public String encode(List<String> strs) {
        String s="";
        for(int i=0;i<strs.size();i++){
            s=s+strs.get(i).length()+"#"+strs.get(i);
        }
        System.out.println(s);
        return s;
    }

    public List<String> decode(String str) {
       ArrayList<String> a1=new ArrayList<>();
       int i=0;
       while(i<str.length()){
        String length="";
        while(str.charAt(i)!='#'){
            length=length+str.charAt(i);
            i++;
        }
        int len=Integer.parseInt(length);
        a1.add(str.substring(i+1,i+1+len));
        i=i+1+len;
       }
       return a1;
    }
}
