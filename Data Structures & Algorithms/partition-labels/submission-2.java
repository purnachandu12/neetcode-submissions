class Solution {
    public List<Integer> partitionLabels(String s) {
        HashMap<Character,Integer> map=new HashMap<>();
        for(int i=0;i<s.length();i++){
            map.put(s.charAt(i),i);
        }
        for(Map.Entry<Character,Integer> entry:map.entrySet()){
            System.out.println(entry.getKey()+" "+entry.getValue());
        }
        HashSet<Character> set=new HashSet<>();
        ArrayList<Integer> result=new ArrayList<>();
        for(int i=0;i<s.length();i++){
            char element=s.charAt(i);
            int last=map.get(s.charAt(i));
            for(int j=i;j<=last;j++){
                if(element!=s.charAt(j)){
                    element=s.charAt(j);
                    last=Math.max(last,map.get(element));
                }
            }
            System.out.println(last);
            result.add(last-i+1);
            i=last;
        }
        return result;
    }
}
