class Solution {
    public List<Integer> partitionLabels(String s) {
        HashMap<Character,Integer> map=new HashMap<>();
        for(int i=0;i<s.length();i++){
            map.put(s.charAt(i),i);
        }
        ArrayList<Integer> list=new ArrayList<>();
        for(int i=0;i<s.length();i++){
            char element=s.charAt(i);
            int value=map.get(s.charAt(i));
            for(int j=i;j<=value;j++){
                if(s.charAt(j)!=element){
                    element=s.charAt(j);
                    value=Math.max(value,map.get(element));
                }
            }
            System.out.println(i+" "+value);
            list.add(value+1-i);
            i=value;
            System.out.println(i);
        }
        return list;
    }
}
